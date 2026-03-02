package pnemonic.bug_bash.model.bug

import pnemonic.bug_bash.sound.SoundType

class Wasp : BugThatFlies(
    speed = 0.25f,
    score = 20,
    hits = 2,
    noise = SoundType.Bee,
    soundBash = SoundType.SpitSplat
) {
    override val description = "🐝"
}