package pnemonic.bug_bash.model

import pnemonic.bug_bash.sound.SoundType

class Scorpion : BugThatCrawls(speed = 1f, score = 5, hits = 5, sound = SoundType.Pop) {
    override val description = "\uD83E\uDD82"
}