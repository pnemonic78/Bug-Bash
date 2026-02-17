package pnemonic.bug_bash.model.bug

import pnemonic.bug_bash.sound.SoundType

class Bee : BugThatFlies(
    speed = 0.5f,
    score = 10,
    hits = 1,
    noise = SoundType.Bee,
    soundBash = SoundType.Squirt
) {
    override val description = "🐝"
}