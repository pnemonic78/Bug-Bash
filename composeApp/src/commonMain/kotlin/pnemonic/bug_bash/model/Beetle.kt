package pnemonic.bug_bash.model

import pnemonic.bug_bash.sound.SoundType

class Beetle : BugThatFlies(speed = 0.2f, score = 5, hits = 1, sound = SoundType.Pop) {
    override val description = "🐞"
}