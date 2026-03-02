package pnemonic.bug_bash.model.bug

import pnemonic.bug_bash.sound.SoundType

class Scorpion : BugThatCrawls(speed = 0.2f, score = 20, hits = 4, soundBash = SoundType.SlimeSplash) {
    override val description = "\uD83E\uDD82"
}