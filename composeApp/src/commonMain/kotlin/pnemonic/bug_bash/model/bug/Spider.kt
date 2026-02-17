package pnemonic.bug_bash.model.bug

import pnemonic.bug_bash.sound.SoundType

class Spider : BugThatCrawls(speed = 0.5f, score = 15, hits = 2, soundBash = SoundType.SlimeSplash) {
    override val description = "\uD83D\uDD77\uFE0F"
}