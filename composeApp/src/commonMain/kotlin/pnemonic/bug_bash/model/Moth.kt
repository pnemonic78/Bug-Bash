package pnemonic.bug_bash.model

import pnemonic.bug_bash.sound.SoundType

class Moth : BugThatFlies(speed = 1f, score = 10, hits = 1, sound = SoundType.Pop) {
    override val description = "🦋"
}