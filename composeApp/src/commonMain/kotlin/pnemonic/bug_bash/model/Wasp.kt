package pnemonic.bug_bash.model

import pnemonic.bug_bash.sound.SoundType

class Wasp : BugThatFlies(
    speed = 0.5f,
    score = 20,
    hits = 2,
    noise = SoundType.Bee,
    soundBash = SoundType.SpitSplat
) {
    override val description = "🐝"
}