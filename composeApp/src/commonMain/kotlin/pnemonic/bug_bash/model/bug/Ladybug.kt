package pnemonic.bug_bash.model.bug

import pnemonic.bug_bash.sound.SoundType

// Coccinellidae
class Ladybug : BugThatCrawls(speed = 0.45f, score = -50, hits = 1, soundBash = SoundType.SpitSplat) {
    override val description = "🐞"
}