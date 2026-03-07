package pnemonic.bug_bash.model.bug

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.IntSize
import pnemonic.RADIANS_TO_DEGREES
import pnemonic.bug_bash.sound.SoundType
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.max
import kotlin.math.sin

abstract class Bug(
    val speed: Float,
    val score: Long,
    var hits: Int,
    val noise: SoundType = SoundType.None,
    val soundBash: SoundType = SoundType.Squirt,
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
    private var destinationAngle: Float = Float.NaN
    protected var velocity: Float = speed * 0.05f
        private set
    var rotation by mutableFloatStateOf(0f)
        private set
    protected var rotationMovement = 0f
        private set
    var isSquashed by mutableStateOf(false)
        private set
    var damage by mutableIntStateOf(0)
        private set
    var opacity by mutableFloatStateOf(1f)
        private set
    private var delay: Long = 0L
    abstract val description: String

    val isFrozen: Boolean get() = delay > 0L
    val isStopped: Boolean get() = isSquashed || isFrozen

    override fun toString(): String {
        return "${this::class.simpleName}@${hashCode()}($description, l:$left, t:$top, w:$width, h:$height, r:$rotation, d:$delay, h:$hits, o:$opacity)"
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
        destinationAngle = calculateHeading()
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

    private fun calculateHeading(): Float {
        if (isBadMove()) {
            rotation = 0f
            rotationMovement = 0f
            return 0f
        }
        val x1 = left
        val y1 = top
        val x2 = destinationX
        val y2 = destinationY
        val dx = x2 - x1
        val dy = y2 - y1
        val theta = atan2(dy, dx)
        val angleDegrees = ((theta * RADIANS_TO_DEGREES) + 360f) % 360f
        val angleVisual = (angleDegrees + 90f) % 360f
        rotation = angleVisual
        rotationMovement = angleDegrees / RADIANS_TO_DEGREES
        return angleVisual
    }

    protected fun moveStraight(): Boolean {
        val angle = rotationMovement
        val c = cos(angle)  //TODO cache this value
        val s = sin(angle)  //TODO cache this value
        val x1 = left
        val y1 = top
        val dx = velocity * width
        val dy = 0f
        val x2 = x1 + ((dx * c) - (dy * s))
        val y2 = y1 + ((dx * s) + (dy * c))
        moveTo(x2, y2)
        return angle == rotationMovement
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

    fun isHit(rect: Rect): Boolean {
        return rect.contains(this)
    }

    fun hit() {
        damage++
        var hits = this.hits
        hits = max(0, hits - 1)
        this.hits = hits

        if (hits == 0) {
            isSquashed = true
            opacity = 0.75f
        } else {
            opacity = max(1f - (damage * 0.1f), 0.2f)
        }
    }

    fun didEscape(boardSize: Size): Boolean {
        val x1 = left
        val y1 = top
        val x2 = x1 + width
        val y2 = y1 + height
        val x3 = boardSize.width
        val y3 = boardSize.height
        val angle = destinationAngle
        // heading to Top-Right
        if (angle <= 90f) {
            return (x1 + EPSILON_ESCAPE >= x3) || (y2 - EPSILON_ESCAPE < 0f)
        }
        // heading to Bottom-Right
        if (angle <= 180f) {
            return (x1 + EPSILON_ESCAPE >= x3) || (y1 + EPSILON_ESCAPE >= y3)
        }
        // heading to Bottom-Left
        if (angle <= 270f) {
            return (x2 - EPSILON_ESCAPE < 0f) || (y1 + EPSILON_ESCAPE >= y3)
        }
        // heading to Top-Left
        return (x2 - EPSILON_ESCAPE < 0f) || (y2 - EPSILON_ESCAPE < 0f)
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

    companion object {
        private const val EPSILON_ESCAPE = 5f
    }
}

fun Rect.contains(bug: Bug): Boolean {
    return (left <= bug.right) && (bug.left <= right) && (bug.top <= bottom) && (bug.bottom >= top)
}
