package pnemonic.bug_bash.model

import pnemonic.bug_bash.sound.SoundType

abstract class BugThatSlithers(speed: Float, score: Int, hits: Int, sound: SoundType) :
    Bug(speed = speed, score = score, hits = hits, sound = sound)