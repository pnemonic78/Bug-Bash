package pnemonic.bug_bash.model

import pnemonic.bug_bash.sound.SoundType

class Dragonfly : BugThatFlies(speed = 0.5f, score = -20, hits = 1, sound = SoundType.SpitSplat) {
    override val description = "🐞"
}