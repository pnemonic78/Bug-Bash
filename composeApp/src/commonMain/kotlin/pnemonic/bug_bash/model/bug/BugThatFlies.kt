package pnemonic.bug_bash.model.bug

import pnemonic.bug_bash.sound.SoundType
import kotlin.math.cos
import kotlin.math.sin

abstract class BugThatFlies(
    speed: Float,
    score: Long,
    hits: Int,
    noise: SoundType = SoundType.None,
    soundBash: SoundType
) : Bug(speed = speed, score = score, hits = hits, noise = noise, soundBash = soundBash) {
    override fun moveNext(): Boolean = moveZigZag()

    private var angleZigZag = 0f

    protected fun moveZigZag(): Boolean {
        val size = width
        val angle = rotationMovement
        val c = cos(angle)
        val s = sin(angle)
        val x1 = left
        val y1 = top
        val dx = velocity * size
        val dy = size * 0.01f * sin(angleZigZag)
        val x2 = x1 + ((dx * c) - (dy * s))
        val y2 = y1 + ((dx * s) + (dy * c))
        moveTo(x2, y2)
        angleZigZag += 0.1f
        return true
    }
}