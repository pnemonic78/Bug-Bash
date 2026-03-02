package pnemonic.bug_bash.model.bug

import pnemonic.bug_bash.sound.SoundType

class Mosquito : BugThatFlies(
    speed = 0.5f,
    score = 20,
    hits = 1,
    noise = SoundType.Mosquito,
    soundBash = SoundType.SpitSplat
) {
    override val description = "\uD83E\uDD9F"
}