package pnemonic.bug_bash

import pnemonic.bug_bash.sound.SoundType

sealed class Feedback {
    object None : Feedback()

    object Vibrate : Feedback()

    data class Sound(val soundType: SoundType) : Feedback()

    data class Bash(val soundType: SoundType) : Feedback()
}

