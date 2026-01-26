package pnemonic.bug_bash.model

import pnemonic.bug_bash.sound.SoundType

class Bee : BugThatFlies(speed = 1f, score = 15, hits = 1, sound = SoundType.Pop) {
    override val description = "🐝"
}