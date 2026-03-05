package pnemonic.bug_bash.model.bug

import pnemonic.bug_bash.sound.SoundType

class Caterpillar : BugThatSlithers(speed = 0.125f, score = 5, hits = 2, soundBash = SoundType.Squeeze) {
    override val description = "\uD83D\uDC1B"
}