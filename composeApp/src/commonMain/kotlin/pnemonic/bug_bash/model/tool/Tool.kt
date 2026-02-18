package pnemonic.bug_bash.model.tool

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import pnemonic.bug_bash.model.bug.Bug
import pnemonic.bug_bash.sound.SoundType
import pnemonic.half
import kotlin.math.max

// Visual bonus on the board.
abstract class Tool {
    open val sound: SoundType = SoundType.None
    var bounds: Rect by mutableStateOf(Rect.Zero)
        private set
    val left get() = bounds.left
    val top get() = bounds.top
    val width get() = bounds.width
    val height get() = bounds.height
    val right get() = bounds.right
    val bottom get() = bounds.bottom
    var opacity by mutableFloatStateOf(0f)
        private set
    val isVisible: Boolean get() = opacity > 0f
    abstract val description: String

    fun moveTo(left: Float, top: Float, boardSize: Size) {
        var x1 = max(0f, left)
        var y1 = max(0f, top)
        var x2 = x1 + width
        var y2 = y1 + height
        if (x2 > boardSize.width) {
            x2 = boardSize.width
            x1 = x2 - width
        }
        if (y2 > boardSize.height) {
            y2 = boardSize.height
            y1 = y2 - height
        }
        bounds = Rect(left = x1, top = y1, right = x2, bottom = y2)
    }

    fun moveBy(dx: Float, dy: Float) {
        bounds = bounds.translate(dx, dy)
    }

    fun setSize(width: Float, height: Float, boardSize: Size) {
        val left = boardSize.width.half - width.half
        val top = boardSize.height.half - height.half
        bounds = Rect(left = left, top = top, right = left + width, bottom = top + height)
    }

    fun setSize(size: Size, boardSize: Size) {
        setSize(size.width, size.height, boardSize)
    }

    fun show() {
        opacity = 1f
    }

    fun hide() {
        opacity = 0f
    }

    fun isHit(bug: Bug): Boolean {
        return bug.isHit(bounds)
    }
}