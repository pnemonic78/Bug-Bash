package pnemonic.bug_bash.model

import pnemonic.bug_bash.sound.SoundType

// Coccinellidae
class Ladybug : BugThatFlies(speed = 0.5f, score = -15, hits = 1, sound = SoundType.SpitSplat) {
    override val description = "🐞"
}