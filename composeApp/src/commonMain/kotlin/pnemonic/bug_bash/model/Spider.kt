package pnemonic.bug_bash.model

import pnemonic.bug_bash.sound.SoundType

class Spider : BugThatCrawls(speed = 0.5f, score = 5, hits = 2, sound = SoundType.SlimeSplash) {
    override val description = "\uD83D\uDD77\uFE0F"
}