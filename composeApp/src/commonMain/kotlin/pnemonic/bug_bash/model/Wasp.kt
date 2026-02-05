package pnemonic.bug_bash.model

import pnemonic.bug_bash.sound.SoundType

class Wasp : BugThatFlies(speed = 1f, score = 20, hits = 2, sound = SoundType.SpitSplat) {
    override val description = "🐝"
}