package pnemonic.bug_bash.model

import pnemonic.bug_bash.sound.SoundType

class Cricket : BugThatCrawls(speed = 0.5f, score = 5, hits = 2, sound = SoundType.SpitSplat) {
    override val description = "\uD83E\uDEB3"
}