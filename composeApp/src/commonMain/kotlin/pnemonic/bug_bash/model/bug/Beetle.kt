package pnemonic.bug_bash.model.bug

import pnemonic.bug_bash.sound.SoundType

class Beetle : BugThatCrawls(speed = 0.25f, score = 10, hits = 2, soundBash = SoundType.SpitSplat) {
    override val description = "\uD80C\uDDA3"
}