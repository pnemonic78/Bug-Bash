package pnemonic.bug_bash.model.bug

import pnemonic.bug_bash.sound.SoundType

class Fly : BugThatFlies(speed = 0.65f, score = 15, hits = 1, soundBash = SoundType.SpitSplat) {
    override val description = "\uD83E\uDEB0"
}