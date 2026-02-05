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

    data class Bash(val soundType: SoundType) : Feedback()
}

