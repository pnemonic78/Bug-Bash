package pnemonic.bug_bash.model.bug

import pnemonic.bug_bash.sound.SoundType

class Moth : BugThatFlies(speed = 0.5f, score = 10, hits = 1, soundBash = SoundType.SpitSplat) {
    override val description = "🦋"
}