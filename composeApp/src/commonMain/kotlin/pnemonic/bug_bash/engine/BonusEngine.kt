package pnemonic.bug_bash.engine

import androidx.compose.ui.geometry.Offset
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import pnemonic.add
import pnemonic.bug_bash.Feedback
import pnemonic.bug_bash.model.Board
import pnemonic.bug_bash.model.Bonus
import pnemonic.bug_bash.model.tool.AttractionTool
import pnemonic.bug_bash.model.tool.BashTool
import pnemonic.bug_bash.model.tool.BonusTool
import pnemonic.bug_bash.model.tool.Cupcake
import pnemonic.bug_bash.model.tool.ExtraLife
import pnemonic.bug_bash.model.tool.Flower
import pnemonic.bug_bash.model.tool.FreezeTool
import pnemonic.bug_bash.model.tool.GluePaper
import pnemonic.bug_bash.model.tool.Score
import pnemonic.bug_bash.model.tool.Shoe
import pnemonic.bug_bash.model.tool.Spray
import pnemonic.bug_bash.model.tool.Swatter
import pnemonic.bug_bash.model.tool.Tool
import pnemonic.bug_bash.model.tool.Zapper
import pnemonic.bug_bash.sound.SoundType
import pnemonic.half
import pnemonic.remove
import kotlin.math.max
import kotlin.math.min

class BonusEngine(
    private val callback: EngineCallback,
    private val coroutineScope: CoroutineScope
) {
    private val activated = mutableListOf<Bonus>()
    private val used = mutableListOf<Tool>()
    private var boardScore = 0L
    private var selected: Bonus? = null
    private var jobHide: Job? = null

    fun onClick(bonus: Bonus) {
        if (bonus.isActive) {
            if (activated.isEmpty()) {
                activated.add(bonus)
            }
            selected = null
        } else {
            selected = bonus
        }
    }

    suspend fun process(board: Board): Board {
        var board = processTools(board)
        board = processBonuses(board)
        return board
    }

    // Apply bonuses to the board that were clicked by player.
    private suspend fun processTools(board: Board): Board {
        val toolActive = board.tool
        if (toolActive == null) {
            val bonusTouched = activated.removeFirstOrNull()
            if (bonusTouched != null) {
                // remove the bonus from the list
                // add the bonus to the board
                return addTool(board, bonusTouched)
            }
        } else {
            val toolUsed = used.removeFirstOrNull()
            if (toolUsed === toolActive) {
                return applyTool(board, toolActive)
            }
            if (toolActive.isVisible && !toolActive.bounds.isEmpty) {
                return useTool(board, toolActive)
            }
        }
        return board
    }

    private fun processBonuses(board: Board): Board {
        // Add potential bonus.
        val scoreBefore = boardScore
        val score = board.score
        val scoreDelta = score - scoreBefore
        if (scoreDelta == 0L) return board
        boardScore = score

        var modified = false
        var bonuses = board.bonuses
        if (bonuses.isEmpty()) {
            bonuses = listOf(
                Bonus.Shoe(),
                Bonus.Spray(),
                Bonus.Swatter(),
                Bonus.Zapper(),
                Bonus.GluePaper(),
                Bonus.Life(),
                Bonus.Cupcake(),
                Bonus.Flower(),
                Bonus.Score(),
            )
            modified = true
        }
        var bonus = selected
        if (bonus == null) {
            bonus = bonuses.firstOrNull { b -> b.progress < b.score }
            if (bonus == null) {
                bonus = next(bonuses, bonus)
                if (bonus != null) {
                    bonuses = bonuses.add(bonus)
                    modified = true
                }
            }
            selected = bonus
        }

        if (bonus != null) {
            val progressDelta = min(scoreDelta, max(0, bonus.score - bonus.progress))
            bonus.incrementProgress(progressDelta)
            val progressNext = scoreDelta - progressDelta
            if (bonus.isActive) {
                // Start progressing the next candidate bonus.
                bonus = bonuses.firstOrNull { b -> b.progress < b.score }
                if (bonus == null) {
                    bonus = next(bonuses, bonus)
                    if (bonus != null) {
                        bonuses = bonuses.add(bonus)
                        modified = true
                        bonus.incrementProgress(progressNext)
                    }
                }
                selected = bonus
            }
        }

        return if (modified) {
            board.copy(bonuses = bonuses)
        } else {
            board
        }
    }

    /** Add the bonus to the board as a tool. */
    private suspend fun addTool(board: Board, bonus: Bonus): Board {
        return when (bonus) {
            Bonus.None -> board
            is Bonus.Cupcake -> add(board, bonus)
            is Bonus.Flower -> add(board, bonus)
            is Bonus.GluePaper -> add(board, bonus)
            is Bonus.Life -> add(board, bonus)
            is Bonus.Score -> add(board, bonus)
            is Bonus.Shoe -> add(board, bonus)
            is Bonus.Spray -> add(board, bonus)
            is Bonus.Swatter -> add(board, bonus)
            is Bonus.Zapper -> add(board, bonus)
        }
    }

    private fun applyTool(board: Board, tool: Tool): Board {
        return when (tool) {
            Bonus.None -> board
            is Cupcake -> used(board, tool)
            is Flower -> used(board, tool)
            is GluePaper -> used(board, tool)
            is ExtraLife -> apply(board, tool)
            is Score -> apply(board, tool)
            is Shoe -> usedTool(board, tool)
            is Spray -> usedTool(board, tool)
            is Swatter -> usedTool(board, tool)
            is Zapper -> usedTool(board, tool)
            else -> board
        }
    }

    private fun add(board: Board, bonus: Bonus.Cupcake): Board {
        val tool = Cupcake(bonus)
        return board.copy(tool = tool)
    }

    private fun add(board: Board, bonus: Bonus.Flower): Board {
        val tool = Flower(bonus)
        return board.copy(tool = tool)
    }

    private fun add(board: Board, bonus: Bonus.GluePaper): Board {
        val tool = GluePaper(bonus)
        return board.copy(tool = tool)
    }

    private suspend fun add(board: Board, bonus: Bonus.Life): Board {
        val lives = board.lives + bonus.hits.toInt()
        if (lives >= Board.MAX_LIVES) return board

        val tool = ExtraLife(bonus)
        playSound(tool.sound)
        return board.copy(tool = tool)
    }

    private suspend fun add(board: Board, bonus: Bonus.Score): Board {
        val tool = Score(bonus)
        playSound(tool.sound)
        return board.copy(tool = tool)
    }

    private fun add(board: Board, bonus: Bonus.Shoe): Board {
        val tool = Shoe(bonus)
        return board.copy(tool = tool)
    }

    private fun add(board: Board, bonus: Bonus.Spray): Board {
        val tool = Spray(bonus)
        return board.copy(tool = tool)
    }

    private fun add(board: Board, bonus: Bonus.Swatter): Board {
        val tool = Swatter(bonus)
        return board.copy(tool = tool)
    }

    private fun add(board: Board, bonus: Bonus.Zapper): Board {
        val tool = Zapper(bonus)
        return board.copy(tool = tool)
    }

    private fun reuse(bonuses: List<Bonus>, bonus: Bonus): List<Bonus> {
        // Re-use the same bonus.
        bonus.clear()
        // Move the bonus to the end.
        return bonuses.remove(bonus) + bonus
    }

    private fun apply(board: Board, tool: ExtraLife): Board {
        val lives = board.lives + tool.hits.toInt()
        if (lives >= Board.MAX_LIVES) return board

        val board = usedTool(board, tool)
        return board.copy(lives = lives)
    }

    private fun used(board: Board, tool: Cupcake): Board {
        tool.thaw()
        return usedTool(board, tool)
    }

    private fun used(board: Board, tool: Flower): Board {
        tool.thaw()
        return usedTool(board, tool)
    }

    private fun used(board: Board, tool: GluePaper): Board {
        tool.thaw()
        return usedTool(board, tool)
    }

    private fun apply(board: Board, tool: Score): Board {
        val score = board.score + tool.hits
        // ignore points earned using bonus tool for other bonuses
        boardScore = score

        val board = usedTool(board, tool)
        return board.copy(score = score)
    }

    private fun usedTool(board: Board, tool: Tool): Board {
        var bonuses = board.bonuses
        val bonus = (tool as? BonusTool)?.bonus
        if (bonus != null) {
            bonuses = reuse(board.bonuses, tool.bonus)
        }
        return board.copy(bonuses = bonuses, tool = null)
    }

    /**
     * Get the next bonus.
     *
     * <ol>
     *   <li>GluePaper</li>
     *   <li>Shoe</li>
     *   <li>Cupcake</li>
     *   <li>Flower</li>
     *   <li>Life</li>
     *   <li>Insecticide</li>
     *   <li>Score</li>
     *   <li>Swatter</li>
     *   <li>Zapper</li>
     * </ol>
     */
    private fun next(bonuses: List<Bonus>, bonus: Bonus?): Bonus? {
        return when (bonus) {
            null -> {
                val first = bonuses.firstOrNull { it is Bonus.GluePaper }
                if (first != null) return null
                Bonus.GluePaper()
            }

            is Bonus.Cupcake -> {
                val first = bonuses.firstOrNull { it is Bonus.Flower }
                if (first != null) return null
                Bonus.Flower()
            }

            is Bonus.Flower -> {
                val first = bonuses.firstOrNull { it is Bonus.Life }
                if (first != null) return null
                Bonus.Life()
            }

            is Bonus.GluePaper -> {
                val first = bonuses.firstOrNull { it is Bonus.Shoe }
                if (first != null) return null
                Bonus.Shoe()
            }

            is Bonus.Life -> {
                val first = bonuses.firstOrNull { it is Bonus.Spray }
                if (first != null) return null
                Bonus.Spray()
            }

            is Bonus.Score -> {
                val first = bonuses.firstOrNull { it is Bonus.Swatter }
                if (first != null) return null
                Bonus.Swatter()
            }

            is Bonus.Shoe -> {
                val first = bonuses.firstOrNull { it is Bonus.Cupcake }
                if (first != null) return null
                Bonus.Cupcake()
            }

            is Bonus.Spray -> {
                val first = bonuses.firstOrNull { it is Bonus.Score }
                if (first != null) return null
                Bonus.Score()
            }

            is Bonus.Swatter -> {
                val first = bonuses.firstOrNull { it is Bonus.Zapper }
                if (first != null) return null
                Bonus.Zapper()
            }

            is Bonus.Zapper -> {
                val first = bonuses.firstOrNull { it is Bonus.Life }
                if (first != null) return null
                Bonus.Life()
            }

            else -> null
        }
    }

    fun onUse(tool: Tool) {
        used.add(tool)
    }

    suspend fun onTap(board: Board, offset: Offset) {
        val tool = board.tool ?: return
        // Not yet on the board?
        if (!tool.isVisible) {
            val left = offset.x - tool.width.half
            val top = offset.y - tool.height.half
            tool.moveTo(left, top, board.size)
            tool.show()
            playSound(tool.sound)
        }
    }

    private suspend fun notifyFeedback(feedback: Feedback) {
        callback.notifyFeedback(feedback)
    }

    private suspend fun playSound(sound: SoundType) {
        if (sound === SoundType.None) return
        notifyFeedback(Feedback.Sound(sound))
    }

    private suspend fun useTool(board: Board, tool: Tool): Board {
        return when (tool) {
            is Cupcake -> useTool(board, tool)
            is Flower -> useTool(board, tool)
            is GluePaper -> useTool(board, tool)
            is Shoe -> useTool(board, tool)
            is Spray -> useTool(board, tool)
            is Swatter -> useTool(board, tool)
            is Zapper -> useTool(board, tool)
            else -> board
        }
    }

    private fun useTool(board: Board, tool: Cupcake): Board {
        return attract(board, tool)
    }

    private fun useTool(board: Board, tool: Flower): Board {
        return attract(board, tool)
    }

    private fun useTool(board: Board, tool: GluePaper): Board {
        return freeze(board, tool)
    }

    private suspend fun useTool(board: Board, tool: Shoe): Board {
        return bash(board, tool)
    }

    private suspend fun useTool(board: Board, tool: Spray): Board {
        return bash(board, tool)
    }

    private suspend fun useTool(board: Board, tool: Swatter): Board {
        return bash(board, tool)
    }

    private suspend fun useTool(board: Board, tool: Zapper): Board {
        return bash(board, tool)
    }

    private fun attract(board: Board, tool: AttractionTool): Board {
        tool.attract(board.swarm)
        return board
    }

    private suspend fun bash(board: Board, tool: BashTool): Board {
        val board = tool.bash(board, callback)
        // ignore points earned using bonus tool for other bonuses
        boardScore = board.score

        if (jobHide == null) {
            jobHide = coroutineScope.launch {
                delay(DURATION_BASH)
                // Hide the tool to bash again.
                tool.hide()
                if (tool.hits <= 0) {
                    onUse(tool)
                }
                jobHide = null
            }
        }

        return board
    }

    // Prevent the swarm from moving.
    private fun freeze(board: Board, tool: FreezeTool): Board {
        tool.freeze(board.swarm)
        return board
    }

    fun clear() {
        activated.clear()
        used.clear()
        boardScore = 0L
        selected = null
    }

    companion object {
        private const val DURATION_BASH = 2000L
    }
}