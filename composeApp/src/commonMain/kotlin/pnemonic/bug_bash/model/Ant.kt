package pnemonic.bug_bash.model

import pnemonic.bug_bash.sound.SoundType

class Ant : BugThatCrawls(speed = 1f, score = 5, hits = 1, soundBash = SoundType.Squirt) {
    override val description = "🐜"
}