package pnemonic.bug_bash.model

import pnemonic.bug_bash.sound.SoundType

class Termite : BugThatCrawls(speed = 1f, score = 5, hits = 1, sound = SoundType.Pop) {
    override val description = "🐜"
}