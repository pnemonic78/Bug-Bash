package pnemonic.bug_bash.model.bug

import pnemonic.bug_bash.sound.SoundType

class Butterfly : BugThatFlies(speed = 0.3f, score = -20, hits = 1, soundBash = SoundType.Squish1) {
    override val description = "🦋"
}