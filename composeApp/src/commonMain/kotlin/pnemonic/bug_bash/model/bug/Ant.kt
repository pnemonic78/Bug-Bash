package pnemonic.bug_bash.model.bug

import pnemonic.bug_bash.sound.SoundType

class Ant : BugThatCrawls(speed = 0.7f, score = 5, hits = 1, soundBash = SoundType.Squirt) {
    override val description = "🐜"
}