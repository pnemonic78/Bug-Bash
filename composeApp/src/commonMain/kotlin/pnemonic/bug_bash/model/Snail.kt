package pnemonic.bug_bash.model

import pnemonic.bug_bash.sound.SoundType

class Snail : BugThatSlithers(speed = 0.2f, score = 5, hits = 2, soundBash = SoundType.Squeeze) {
    override val description = "\uD83D\uDC0C"
}