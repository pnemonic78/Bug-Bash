package pnemonic.bug_bash.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import pnemonic.bug_bash.sound.SoundType

sealed class Bonus(val score: Int, val hits: Int, val sound: SoundType, progress: Int = 0) {
    var progress by mutableIntStateOf(progress)

    object None : Bonus(score = 0, hits = 0, sound = SoundType.None)

    class Flower(progress: Int = 0) :
        Bonus(score = 100, hits = 1, sound = SoundType.Pop, progress = progress)

    class Insecticide(progress: Int = 0) :
        Bonus(score = 200, hits = 2, sound = SoundType.Spray, progress = progress)

    class Life(progress: Int = 0) :
        Bonus(score = 100, hits = 0, sound = SoundType.Kiss, progress = progress)

    class RainbowSprinkles(progress: Int = 0) :
        Bonus(score = 200, hits = -1, sound = SoundType.Chips, progress = progress)

    class Shoe(progress: Int = 0) :
        Bonus(score = 250, hits = 5, sound = SoundType.Drop, progress = progress)

    class Swatter(progress: Int = 0) :
        Bonus(score = 350, hits = 5, sound = SoundType.Swish, progress = progress)

    class Zapper(progress: Int = 0) :
        Bonus(score = 400, hits = 4, sound = SoundType.Laser, progress = progress)
}