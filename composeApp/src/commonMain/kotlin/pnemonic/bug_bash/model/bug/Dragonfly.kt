package pnemonic.bug_bash.model.bug

import pnemonic.bug_bash.sound.SoundType

class Dragonfly : BugThatFlies(speed = 0.2f, score = -20, hits = 1, soundBash = SoundType.SpitSplat) {
    override val description = "⚚"
}