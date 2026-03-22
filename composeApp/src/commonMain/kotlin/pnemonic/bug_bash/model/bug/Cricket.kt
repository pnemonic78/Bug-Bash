package pnemonic.bug_bash.model.bug

import pnemonic.bug_bash.sound.SoundType

class Cricket : BugThatCrawls(
    speed = 0.45f,
    score = 10,
    hits = 2,
    noise = SoundType.Locust,
    soundBash = SoundType.SpitSplat
) {
    override val description = "\uD83E\uDEB3"
}