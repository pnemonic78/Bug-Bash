package pnemonic.bug_bash

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.IntSize
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import pnemonic.bug_bash.model.Board
import pnemonic.bug_bash.model.Bonus
import pnemonic.bug_bash.model.GameState
import pnemonic.bug_bash.model.Scene
import pnemonic.bug_bash.model.bug.Bug
import pnemonic.bug_bash.model.bug.Swarm
import pnemonic.bug_bash.model.tool.Tool
import pnemonic.bug_bash.sound.SoundType
import pnemonic.copy
import pnemonic.half
import pnemonic.removeAll
import kotlin.math.max
import kotlin.random.Random

class GameEngine(private val coroutineScope: CoroutineScope) : EngineCallback {
    private var ticker: Job? = null

    private val _boards = MutableStateFlow(Board())
    val boards: StateFlow<Board> = _boards

    private val _state = MutableStateFlow(GameState.NOT_STARTED)
    val state: StateFlow<GameState> = _state
    val isRunning get() = (state.value === GameState.STARTED) || (state.value === GameState.RESUMED)
    val isPaused get() = state.value === GameState.PAUSED

    private val rand = Random.Default
    private val touches = mutableListOf<Offset>()
    private val touchedBugs = mutableListOf<Bug>()
    private val squashed = mutableListOf<Bug>()
    private val bonusEngine = BonusEngine(this, coroutineScope)

    private val _feedback = MutableSharedFlow<Feedback>(extraBufferCapacity = 10)
    val feedback: Flow<Feedback> = _feedback

    fun start() {
        ticker = coroutineScope.launch(Dispatchers.Default) {
            _state.update { GameState.STARTED }
            playSound(SoundType.GameStart)
            while (isActive) {
                run()
                delay(TICK)
            }
        }
    }

    fun pause() {
        _state.update { GameState.PAUSED }
    }

    fun resume() {
        _state.update { GameState.RESUMED }
    }

    fun stop() {
        _state.value = GameState.STOPPED
        ticker?.cancel()
        ticker = null
    }

    private suspend fun run() {
        if (!isRunning) return
        var board = boards.value
        if ((board.width <= 0f) || (board.height <= 0f)) {
            return
        }
        // Mo more lives -> game is done.
        val livesBefore = board.lives
        if (livesBefore <= 0) {
            finished()
            return
        }

        // No more bugs -> level is done.
        if (board.isLevelFinished()) {
            board = nextLevel(board)
        }
        board = move(board)
        board = touch(board)
        board = bonus(board)

        val livesAfter = board.lives
        if (livesAfter < livesBefore) {
            playSound(SoundType.Clang)
        }

        _boards.update { board }
    }

    private fun move(board: Board): Board {
        if (board.swarm.isEmpty()) return board
        val boardSize = board.size
        if ((boardSize.width <= 0) || (boardSize.height <= 0)) return board
        var lives = board.lives
        val bugs = board.swarm.bugs
        val removed = mutableListOf<Bug>()

        for (bug in bugs) {
            if (bug.isBadMove()) {
                continue
            }
            if (bug.thaw(TICK)) {
                continue
            }
            bug.move()
            if (bug.didEscape(boardSize)) {
                removed.add(bug)
                if (bug.score > 0) {
                    lives--
                }
            }
        }

        return if (removed.isEmpty()) {
            board
        } else {
            val bugs = bugs.removeAll(removed)
            board.copy(swarm = Swarm(bugs), lives = lives)
        }
    }

    fun onSize(size: IntSize) {
        if (!isRunning) return
        //TODO set each bug's new destination relative to old destination
        _boards.update { board ->
            board.setSize(width = size.width.toFloat(), height = size.height.toFloat())
        }
    }

    override fun touch(bug: Bug) {
        if (isRunning) {
            touchedBugs.add(bug)
        }
    }

    fun touch(offset: Offset) {
        if (isRunning) {
            touches.add(offset)
        }
    }

    private suspend fun touch(board: Board): Board {
        if (touches.isEmpty() && touchedBugs.isEmpty() && squashed.isEmpty()) {
            return board
        }

        // Convert bug touches to tool touches.
        val tool = board.tool
        if (tool != null && !tool.isVisible && touchedBugs.isNotEmpty()) {
            val bugs = touchedBugs.copy()
            touchedBugs.clear()

            for (bug in bugs) {
                bonusEngine.onTap(
                    board,
                    Offset(bug.left + bug.width.half, bug.top + bug.height.half)
                )
            }
        }

        while (touches.isNotEmpty()) {
            val offset = touches.removeAt(0)
            bonusEngine.onTap(board, offset)
        }

        var swarm = board.swarm
        var lives = board.lives
        var score = board.score

        while (touchedBugs.isNotEmpty()) {
            val bug = touchedBugs.removeAt(0)

            if (bug.isSquashed) {
                continue
            }
            bug.hit()
            if (bug.isSquashed) {
                score += bug.score
                if (score < 0) {
                    lives--
                }
                score = max(0, score)
                bash(bug)
            }
        }

        if (squashed.isNotEmpty()) {
            val bugs = swarm.bugs.toMutableList()
            bugs.removeAll(squashed)
            squashed.clear()
            swarm = Swarm(bugs)
        }

        return board.copy(swarm = swarm, score = score, lives = lives)
    }

    fun onBugSize(bug: Bug) {
        val board = boards.value
        val width = board.width
        val height = board.height
        val widthPad = width * 0.125f
        val heightPad = height * 0.125f
        val widthPadded = width - widthPad - widthPad
        val heightPadded = height - heightPad - heightPad
        val bugWidth = bug.width
        val bugHeight = bug.height

        //TODO try to avoid overlap bugs with each other.
        val side = rand.nextInt(SIDE_MIN, SIDE_MAX)
        var x1 = 0f
        var y1 = 0f
        var x2 = 0f
        var y2 = 0f
        when (side) {
            SIDE_TOP -> {
                x1 = widthPad + (rand.nextFloat() * widthPadded)
                y1 = -(bugHeight * 2)
                x2 = widthPad + (rand.nextFloat() * widthPadded)
                y2 = height + bugHeight
            }

            SIDE_BOTTOM -> {
                x1 = widthPad + (rand.nextFloat() * widthPadded)
                y1 = height + (bugHeight * 2)
                x2 = widthPad + (rand.nextFloat() * widthPadded)
                y2 = -bugHeight
            }

            SIDE_LEFT -> {
                x1 = -(bugWidth * 2)
                y1 = heightPad + (rand.nextFloat() * heightPadded)
                x2 = width + bugWidth
                y2 = heightPad + (rand.nextFloat() * heightPadded)
            }

            SIDE_RIGHT -> {
                x1 = width + (bugWidth * 2)
                y1 = heightPad + (rand.nextFloat() * heightPadded)
                x2 = -bugWidth
                y2 = heightPad + (rand.nextFloat() * heightPadded)
            }
        }
        bug.moveTo(x1, y1)
        bug.setDestination(x2, y2)
    }

    private fun generateBugs(board: Board): Board {
        val level = board.level
        val difficulty = board.difficulty
        val swarm = BugFactory.createSwarm(level, difficulty)
        var delay = 0L

        for (bug in swarm) {
            bug.freeze(delay)
            delay += DELAY_PER_BUG
        }

        return board.copy(swarm = swarm)
    }

    private suspend fun nextLevel(board: Board): Board {
        var board = board
        val level = board.level + 1
        var scene = board.scene
        if (level % NEXT_SCENE == 0) {
            scene = scene.next()
        }
        board = generateBugs(board.copy(level = level, scene = scene, tool = null))
        if (level > 1) {
            playSound(SoundType.Level)
        }
        playSounds(board)
        return board
    }

    private suspend fun finished() {
        println("No more lives")
        _state.update { GameState.FINISHED }
        _boards.update { it.copy(swarm = Swarm()) }
        playSound(SoundType.GameFinish)
    }

    override suspend fun bash(bug: Bug) {
        notifyFeedback(Feedback.Bash(bug.soundBash))
        coroutineScope.launch {
            delay(DELAY_DEAD_REMOVE)
            squashed.add(bug)
        }
    }

    override suspend fun notifyFeedback(feedback: Feedback) {
        _feedback.emit(feedback)
    }

    suspend fun feedbackDone() {
        notifyFeedback(Feedback.None)
    }

    private suspend fun playSounds(board: Board) {
        playMusic(board.scene)
        for (bug in board.swarm) {
            playSound(bug.noise)
        }
    }

    private suspend fun playMusic(scene: Scene) {
        notifyFeedback(scene.music)
    }

    private suspend fun playSound(sound: SoundType) {
        if (sound === SoundType.None) return
        notifyFeedback(Feedback.Sound(sound))
    }

    // Apply any bonuses
    private suspend fun bonus(board: Board): Board {
        return bonusEngine.process(board)
    }

    fun onBonusClick(bonus: Bonus) {
        if (isRunning) {
            bonusEngine.onClick(bonus)
        }
    }

    fun onToolUse(tool: Tool) {
        if (isRunning) {
            bonusEngine.onUse(tool)
        }
    }

    companion object {
        private const val TICK = 20L
        private const val DELAY_PER_BUG = TICK * 30
        private const val NEXT_SCENE = 3

        // Time to show the score after bug squashed.
        private const val DELAY_DEAD_REMOVE = 1000L

        private const val SIDE_TOP = 0
        private const val SIDE_LEFT = 1
        private const val SIDE_BOTTOM = 2
        private const val SIDE_RIGHT = 3
        private const val SIDE_MIN = SIDE_TOP
        private const val SIDE_MAX = SIDE_RIGHT + 1
    }
}
