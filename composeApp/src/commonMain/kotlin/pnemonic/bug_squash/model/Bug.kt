package pnemonic.bug_squash.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.unit.IntSize
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.max

abstract class Bug(
    val score: Int,
    var hits: Int,
) {
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
    protected var destinationX: Float = 0f
        private set
    protected var destinationY: Float = 0f
        private set
    var speed: Float = 0f
        private set
    var directionDegrees: Float = 0f
    var rotation: Float = 0f
        private set
    var isSquashed by mutableStateOf(false)
        private set

    fun setSize(width: Float, height: Float) {
        this.width = width
        this.height = height

        if (left == Float.MIN_VALUE) {
            left = -width
        }
        if (top == Float.MIN_VALUE) {
            top = -height
        }
        if (destinationX == Float.MIN_VALUE) {
            destinationX = -width
        }
        if (destinationY == Float.MIN_VALUE) {
            destinationY = -height
        }
    }

    fun setSize(size: IntSize) {
        setSize(size.width.toFloat(), size.height.toFloat())
    }

    fun setDestination(x: Float, y: Float) {
        destinationX = x
        destinationY = y
    }

    abstract fun move()

    fun moveTo(left: Float, top: Float) {
        this.left = left
        this.top = top
    }

    private fun calculateHeading(x2: Float, y2: Float) {
        val x1 = (left + right) / 2
        val y1 = (top + bottom) / 2
        val dx = x2 - x1
        val dy = y2 - y1
        val theta = atan2(dy, dx) * RADIANS_TO_DEGREES
        rotation = 270f + theta
    }

    fun isHit(offset: Offset): Boolean {
        return (left <= offset.x) && (offset.x < right) && (top <= offset.y) && (offset.y < bottom)
    }

    fun hit() {
        var hits = this.hits
        hits = max(0, hits - 1)
        if (hits == 0) {
            isSquashed = true
            speed = 0f // dead bugs cannot move
        }
        this.hits = hits
    }

    companion object {
        private const val RADIANS_TO_DEGREES = (180.0 / PI).toFloat()
    }
}

fun Rect.contains(bug: Bug): Boolean {
    return (left <= bug.right) && (bug.left < right) && (bug.top < bottom) && (bug.bottom >= top)
}
