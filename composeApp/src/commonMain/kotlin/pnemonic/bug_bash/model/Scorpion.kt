package pnemonic.bug_bash.model

import pnemonic.bug_bash.sound.SoundType

class Scorpion : BugThatCrawls(speed = 0.5f, score = 15, hits = 5, sound = SoundType.SlimeSplash) {
    override val description = "\uD83E\uDD82"
}