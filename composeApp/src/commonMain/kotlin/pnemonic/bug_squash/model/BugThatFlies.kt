package pnemonic.bug_squash.model

import kotlin.math.cos
import kotlin.math.sin

abstract class BugThatFlies(speed: Float, score: Int, hits: Int) :
    Bug(speed = speed, score = score, hits = hits) {
    override fun moveNext(): Boolean = moveZigZag()

    private var angleZigZag = 0f

    protected fun moveZigZag(): Boolean {
        val size = width
        val angle = rotationMovement
        val c = cos(angle)  //TODO cache this value
        val s = sin(angle)  //TODO cache this value
        val x1 = left
        val y1 = top
        val dx = velocity * size
        val dy = size * 0.075f * sin(angleZigZag)
        val x2 = x1 + ((dx * c) - (dy * s))
        val y2 = y1 + ((dx * s) + (dy * c))
        moveTo(x2, y2)
        angleZigZag += 0.1f
        return true
    }
}