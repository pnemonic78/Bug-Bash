package pnemonic.bug_bash.model.bug

import pnemonic.bug_bash.sound.SoundType

class Cockroach : BugThatCrawls(speed = 0.6f, score = 10, hits = 2, soundBash = SoundType.SpitSplat) {
    override val description = "\uD83E\uDEB3"
}