package pnemonic.bug_squash.model

import androidx.compose.ui.geometry.Rect

data class Board(
    val width: Float = 0f,
    val height: Float = 0f,
    val scene: Scene = Scene.Kitchen,
    val swarm: Swarm = Swarm(),
    val level: Int = 1,
    val score: Long = 0,
    val lives: Int = 3,
    val bonus: Bonus = Bonus.None
) {
    val rect: Rect = Rect(0f, 0f, width, height)
}