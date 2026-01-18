package pnemonic.bug_squash.model

import kotlin.math.cos
import kotlin.math.sin

abstract class BugThatFlies(speed: Float, score: Int, hits: Int) :
    Bug(speed = speed, score = score, hits = hits) {
    override fun moveNext(): Boolean = moveZigZag()

    protected fun moveZigZag(): Boolean {
        val movement = velocity * width
        val angle = rotationMovement
        val x = left + movement * cos(angle)
        val y = top + movement * sin(angle)
        moveTo(x, y)
        return true
    }
}