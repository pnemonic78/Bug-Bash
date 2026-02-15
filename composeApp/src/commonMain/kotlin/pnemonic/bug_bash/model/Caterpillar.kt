package pnemonic.bug_bash.model

import pnemonic.bug_bash.sound.SoundType

class Caterpillar : BugThatSlithers(speed = 0.25f, score = 5, hits = 3, soundBash = SoundType.Squeeze) {
    override val description = "\uD83D\uDC1B"
}