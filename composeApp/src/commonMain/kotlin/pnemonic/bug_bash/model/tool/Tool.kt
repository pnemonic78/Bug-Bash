package pnemonic.bug_bash.model.tool

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Size
import pnemonic.half
import kotlin.math.max

// Visual bonus on the board.
abstract class Tool {
    var left by mutableFloatStateOf(0f)
        private set
    var top by mutableFloatStateOf(0f)
        private set
    var width: Float = 0f
        private set
    var height: Float = 0f
        private set
    val right: Float get() = left + width
    val bottom: Float get() = top + height
    var opacity by mutableStateOf(0f)
        private set
    abstract val description: String

    fun moveTo(left: Float, top: Float) {
        this.left = left
        this.top = top
    }

    fun moveBy(dx: Float, dy: Float) {
        moveTo(left + dx, top + dy)
    }

    fun setSize(width: Float, height: Float, boardSize: Size) {
        this.width = width
        this.height = height
        moveTo(
            max(0f, boardSize.width.half - width.half),
            max(0f, boardSize.height.half - height.half)
        )
        opacity = 1f
    }

    fun setSize(size: Size, boardSize: Size) {
        setSize(size.width, size.height, boardSize)
    }

}