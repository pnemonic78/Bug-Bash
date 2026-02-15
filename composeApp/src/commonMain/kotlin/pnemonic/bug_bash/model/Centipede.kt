package pnemonic.bug_bash.model

import pnemonic.bug_bash.sound.SoundType

class Centipede : BugThatSlithers(speed = 0.3f, score = 5, hits = 3, soundBash = SoundType.Squeeze) {
    override val description = "\uD83E\uDEB1"
}