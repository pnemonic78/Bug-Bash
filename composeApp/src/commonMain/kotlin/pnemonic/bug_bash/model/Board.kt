package pnemonic.bug_bash.model

import androidx.compose.ui.geometry.Rect

data class Board(
    val width: Float = 0f,
    val height: Float = 0f,
    val scene: Scene = Scene.Kitchen,
    val level: Int = 0,
    val difficulty: Difficulty = Difficulty.Easy,
    val score: Long = 0,
    val lives: Int = LIVES,
    val bonus: Bonus = Bonus.None,
    val swarm: Swarm = Swarm()
) {
    fun setSize(width: Float, height: Float): Board {
        return copy(width = width, height = height)
    }

    val rect: Rect = Rect(0f, 0f, width, height)

    fun isLevelFinished(): Boolean = swarm.isEmpty()

    companion object {
        const val LIVES = 10
    }
}