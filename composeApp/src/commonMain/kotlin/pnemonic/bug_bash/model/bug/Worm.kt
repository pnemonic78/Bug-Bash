package pnemonic.bug_bash.model.bug

import pnemonic.bug_bash.sound.SoundType

class Worm : BugThatSlithers(speed = 0.1f, score = 5, hits = 3, soundBash = SoundType.Squeeze) {
    override val description = "〰"
}