package pnemonic.bug_bash.model

import pnemonic.bug_bash.sound.SoundType

class Cockroach : BugThatCrawls(speed = 0.75f, score = 5, hits = 3, sound = SoundType.SpitSplat) {
    override val description = "\uD83E\uDEB3"
}