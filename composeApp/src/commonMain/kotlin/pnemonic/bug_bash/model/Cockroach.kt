package pnemonic.bug_bash.model

import pnemonic.bug_bash.sound.SoundType

class Cockroach : BugThatCrawls(speed = 1f, score = 5, hits = 3, sound = SoundType.Pop) {
    override val description = "\uD83E\uDEB3"
}