package pnemonic.bug_bash

import androidx.annotation.FloatRange
import pnemonic.bug_bash.sound.SoundType

sealed class Feedback {
    object None : Feedback()

    data class Vibrate(
        val duration: Long = 300,
        @field:FloatRange(from = 0.0, to = 1.0) val amplitude: Float = 1f
    ) : Feedback()

    data class Sound(val soundType: SoundType) : Feedback()

    data class Silence(val soundType: SoundType) : Feedback() {
        constructor(sound: Sound) : this(sound.soundType)
    }

    data class Bash(
        val soundType: SoundType,
        val duration: Long = VIBRATE_BASH_DURATION,
        @field:FloatRange(from = 0.0, to = 1.0) val amplitude: Float = VIBRATE_BASH_AMPLITUDE
    ) : Feedback()

    data class Hit(
        val duration: Long = VIBRATE_BASH_DURATION,
        @field:FloatRange(from = 0.0, to = 1.0) val amplitude: Float = VIBRATE_BASH_AMPLITUDE
    ) : Feedback()

    companion object {
        private const val VIBRATE_BASH_DURATION = 50L
        private const val VIBRATE_BASH_AMPLITUDE = 0.35f
    }
}

