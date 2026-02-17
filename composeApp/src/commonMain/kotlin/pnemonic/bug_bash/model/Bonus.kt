package pnemonic.bug_bash.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.setValue
import pnemonic.bug_bash.sound.SoundType

sealed class Bonus(val score: Long, val hits: Int, val sound: SoundType, progress: Long = 0) {

    var progress by mutableLongStateOf(progress)

    val isActive: Boolean get() = progress >= score

    object None : Bonus(score = 0, hits = 0, sound = SoundType.None)

    // Attract bugs to the cupcake.
    class Cupcake(progress: Long = 0) :
        Bonus(score = 200, hits = -1, sound = SoundType.Chips, progress = progress)

    // Attract bugs to the flower.
    class Flower(progress: Long = 0) :
        Bonus(score = 100, hits = 1, sound = SoundType.Pop, progress = progress)

    // Freezes bugs when touching the paper.
    class GluePaper(progress: Long = 0) :
        Bonus(score = 200, hits = 2, sound = SoundType.Chips, progress = progress)

    // Bash bugs with insecticide spray.
    class Insecticide(progress: Long = 0) :
        Bonus(score = 200, hits = 2, sound = SoundType.Spray, progress = progress)

    // Extra life.
    class Life(progress: Long = 0) :
        Bonus(score = 100, hits = 0, sound = SoundType.Kiss, progress = progress)

    // Add to main score.
    class Score(progress: Long = 0) :
        Bonus(score = 1000, hits = 2000, sound = SoundType.Clang, progress = progress)

    // Bash bugs with a shoe.
    class Shoe(progress: Long = 0) :
        Bonus(score = 250, hits = 5, sound = SoundType.Drop, progress = progress)

    // Bash bugs with a fly swatter.
    class Swatter(progress: Long = 0) :
        Bonus(score = 350, hits = 5, sound = SoundType.Swish, progress = progress)

    // Bash bugs with a zapper.
    class Zapper(progress: Long = 0) :
        Bonus(score = 400, hits = 4, sound = SoundType.Laser, progress = progress)
}