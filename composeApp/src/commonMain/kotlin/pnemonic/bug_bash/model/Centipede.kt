package pnemonic.bug_bash.model

import pnemonic.bug_bash.sound.SoundType

class Centipede : BugThatSlithers(speed = 0.2f, score = 2, hits = 3, sound = SoundType.Pop) {
    override val description = "\uD83E\uDEB1"
}