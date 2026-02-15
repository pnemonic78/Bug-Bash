package pnemonic.bug_bash.model

import pnemonic.bug_bash.sound.SoundType

class Mosquito : BugThatFlies(
    speed = 1f,
    score = 20,
    hits = 1,
    noise = SoundType.Mosquito,
    soundBash = SoundType.SpitSplat
) {
    override val description = "\uD83E\uDD9F"
}