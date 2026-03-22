package pnemonic.bug_bash.model.bug

import pnemonic.bug_bash.sound.SoundType

class Centipede : BugThatSlithers(speed = 0.1f, score = 5, hits = 2, soundBash = SoundType.Squeeze) {
    override val description = "\uD83E\uDEB1"
}