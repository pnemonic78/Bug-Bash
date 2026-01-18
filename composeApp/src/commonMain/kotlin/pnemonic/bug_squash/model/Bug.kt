package pnemonic.bug_squash.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.unit.IntSize
import pnemonic.RADIANS_TO_DEGREES
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.max
import kotlin.math.sin

abstract class Bug(
    val speed: Float,
    val score: Int,
    var hits: Int
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
    internal var destinationX: Float = Float.NaN
        private set
    internal var destinationY: Float = Float.NaN
        private set
    protected var velocity: Float = speed / 20
        private set
    var rotation by mutableStateOf(0f)
        private set
    protected var rotationMovement = 0f
        private set
    var isSquashed by mutableStateOf(false)
        private set
    var opacity by mutableStateOf(0f)
        private set
    private var delay: Long = 0L
    abstract val description: String

    override fun toString(): String {
        return "{$description, $left, $top, $width, $height, $rotation, $delay}"
    }

    fun setSize(width: Float, height: Float) {
        this.width = width
        this.height = height
        opacity = 1f
    }

    fun setSize(size: IntSize) {
        setSize(size.width.toFloat(), size.height.toFloat())
    }

    fun setDestination(x: Float, y: Float) {
        destinationX = x
        destinationY = y
        calculateHeading()
    }

    fun move(): Boolean {
        if (isBadMove() || isSquashed || (opacity <= 0f) || (velocity <= 0f)) return false
        return moveNext()
    }

    open fun moveNext() = moveStraight()

    fun moveTo(left: Float, top: Float) {
        this.left = left
        this.top = top
        calculateHeading()
    }

    private fun calculateHeading() {
        if (isBadMove()) {
            rotation = 0f
            rotationMovement = 0f
            return
        }
        val x1 = left
        val y1 = top
        val x2 = destinationX
        val y2 = destinationY
        val dx = x2 - x1
        val dy = y2 - y1
        val theta = atan2(dy, dx)
        val angleDegrees = ((theta * RADIANS_TO_DEGREES) + 360f) % 360f
        val angleVisual = (angleDegrees + 270f) % 360f
        rotation = angleVisual
        rotationMovement = angleDegrees / RADIANS_TO_DEGREES
    }

    protected fun moveStraight(): Boolean {
        val movement = velocity * width
        val angle = rotationMovement
        val x = left + movement * cos(angle)
        val y = top + movement * sin(angle)
        val rotationBefore = rotation
        moveTo(x, y)
        return rotationBefore == rotation
    }

    fun isBadMove(): Boolean {
        return destinationX.isNaN()
                || destinationY.isNaN()
                || (width <= 0)
                || (height <= 0)
    }

    fun isHit(offset: Offset): Boolean {
        return (left <= offset.x) && (offset.x < right) && (top <= offset.y) && (offset.y < bottom)
    }

    fun hit() {
        var hits = this.hits
        hits = max(0, hits - 1)
        if (hits == 0) {
            isSquashed = true
            opacity = 0f
        }
        this.hits = hits
    }

    fun didEscape(): Boolean {
        val angleVisual = rotation
        // heading to Bottom-Left
        if ((angleVisual >= 0f) && (angleVisual <= 90f)) {
            return (right <= destinationX) || (top >= destinationY)
        }
        // heading to Top-Left
        if ((angleVisual > 90f) && (angleVisual <= 180f)) {
            return (right <= destinationX) || (bottom <= destinationY)
        }
        // heading to Top-Right
        if ((angleVisual > 180f) && (angleVisual <= 270f)) {
            return (left >=destinationX) || (bottom <= destinationY)
        }
        // heading to Bottom-Right
        return (left >= destinationX) || (top >= destinationY)
    }

    // delay
    fun freeze(ice: Long) {
        this.delay = ice
    }

    // undelay
    fun thaw(steam: Long): Boolean {
        val delay = max(0L, delay - steam)
        this.delay = delay
        return delay > 0L
    }
}

fun Rect.contains(bug: Bug): Boolean {
    return (left <= bug.right) && (bug.left < right) && (bug.top < bottom) && (bug.bottom >= top)
}
