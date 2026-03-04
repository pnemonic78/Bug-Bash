package pnemonic.bug_bash.model.bug

import pnemonic.bug_bash.sound.SoundType

class Termite : BugThatCrawls(speed = 0.8f, score = 5, hits = 1, soundBash = SoundType.Squirt) {
    override val description = "🐜"
}