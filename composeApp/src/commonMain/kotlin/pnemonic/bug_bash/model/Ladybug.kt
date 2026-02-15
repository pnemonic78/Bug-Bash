package pnemonic.bug_bash.model

import pnemonic.bug_bash.sound.SoundType

// Coccinellidae
class Ladybug : BugThatFlies(speed = 0.5f, score = -50, hits = 1, soundBash = SoundType.SpitSplat) {
    override val description = "🐞"
}