package pnemonic.bug_bash.model.bug

import pnemonic.bug_bash.sound.SoundType

abstract class BugThatSlithers(
    speed: Float,
    score: Long,
    hits: Int,
    noise: SoundType = SoundType.None,
    soundBash: SoundType
) : Bug(speed = speed, score = score, hits = hits, noise = noise, soundBash = soundBash)