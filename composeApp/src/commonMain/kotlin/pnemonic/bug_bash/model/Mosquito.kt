package pnemonic.bug_bash.model

import pnemonic.bug_bash.sound.SoundType

class Mosquito : BugThatFlies(speed = 1f, score = 15, hits = 1, sound = SoundType.Pop) {
    override val description = "\uD83E\uDD9F"
}