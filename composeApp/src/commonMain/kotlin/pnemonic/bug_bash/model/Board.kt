package pnemonic.bug_bash.model

import androidx.compose.ui.geometry.Size
import pnemonic.bug_bash.model.bug.Swarm
import pnemonic.bug_bash.model.tool.Tool

data class Board(
    val size: Size = Size.Zero,
    val scene: Scene = Scene.Grass,
    val level: Int = 0,
    val difficulty: Difficulty = Difficulty.Easy,
    val score: Long = 0,
    val lives: Int = LIVES,
    val bonuses: List<Bonus> = listOf(
        Bonus.Cupcake(progress = Long.MAX_VALUE),
        Bonus.Flower(progress = Long.MAX_VALUE),
        Bonus.GluePaper(progress = Long.MAX_VALUE),
//            Bonus.Life(progress = Long.MAX_VALUE),
//            Bonus.Score(progress = Long.MAX_VALUE),
        Bonus.Shoe(progress = Long.MAX_VALUE),
        Bonus.Spray(progress = Long.MAX_VALUE),
        Bonus.Swatter(progress = Long.MAX_VALUE),
        Bonus.Zapper(progress = Long.MAX_VALUE),
    ),
    val swarm: Swarm = Swarm(),
    // only 1 active tool allowed - so not a list of tools.
    val tool: Tool? = null,
) {
    val width: Float get() = size.width
    val height: Float get() = size.height

    fun setSize(width: Float, height: Float): Board {
        return copy(size = Size(width, height))
    }

    fun isLevelFinished(): Boolean = swarm.isEmpty()

    companion object {
        const val LIVES = 5
        const val MAX_LIVES = 10
    }
}