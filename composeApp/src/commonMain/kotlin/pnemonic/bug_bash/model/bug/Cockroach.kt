package pnemonic.bug_bash.model.bug

import pnemonic.bug_bash.sound.SoundType

class Cockroach : BugThatCrawls(speed = 0.7f, score = 10, hits = 3, soundBash = SoundType.SpitSplat) {
    override val description = "\uD83E\uDEB3"
}