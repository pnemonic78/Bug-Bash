package pnemonic.bug_bash.model

import pnemonic.bug_bash.sound.SoundType

class Worm : BugThatSlithers(speed = 0.1f, score = 1, hits = 3, sound = SoundType.Squeeze) {
    override val description = "\uD83E\uDEB1"
}