package pnemonic.bug_bash.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import pnemonic.bug_bash.sound.SoundType

sealed class Bonus(
    // Score required to activate the bonus.
    val score: Long,
    //How many hits does the bonus provide?
    val hits: Long,
    val description: String,
    val sound: SoundType,
    progress: Long = 0
) {
    var progress by mutableLongStateOf(progress)
        private set
    var isActive by mutableStateOf(progress >= score)
        private set

    private fun setProgressImpl(value: Long) {
        progress = value
        isActive = value >= score
    }

    fun incrementProgress(delta: Long) {
        setProgressImpl(progress + delta)
    }

    fun clear() {
        setProgressImpl(0)
    }

    object None : Bonus(score = 0, hits = 0, description = "", sound = SoundType.None)

    // Attract bugs to the cupcake.
    class Cupcake(progress: Long = 0) : Bonus(
        score = 200,
        hits = 1,
        description = "🧁",
        sound = SoundType.Chips,
        progress = progress
    )

    // Attract bugs to the flower.
    class Flower(progress: Long = 0) : Bonus(
        score = 100,
        hits = 1,
        description = "🌼",
        sound = SoundType.Pop,
        progress = progress
    )

    // Freezes bugs when touching the paper.
    class GluePaper(progress: Long = 0) : Bonus(
        score = 200,
        hits = 50,
        description = "📜",
        sound = SoundType.Chips,
        progress = progress
    )

    // Extra life.
    class Life(progress: Long = 0) : Bonus(
        score = 100,
        hits = 1,
        description = "💝",
        sound = SoundType.Kiss,
        progress = progress
    )

    // Add to main score.
    class Score(progress: Long = 0, hits: Long = 2000) : Bonus(
        score = 1000,
        hits = hits,
        description = "🏆",
        sound = SoundType.Clang,
        progress = progress
    )

    // Bash bugs with a shoe.
    class Shoe(progress: Long = 0) : Bonus(
        score = 250,
        hits = 50,
        description = "👞",
        sound = SoundType.Drop,
        progress = progress
    )

    // Bash bugs with insecticide spray.
    class Spray(progress: Long = 0) : Bonus(
        score = 200,
        hits = 50,
        description = "☠",
        sound = SoundType.Spray,
        progress = progress
    )

    // Bash bugs with a fly swatter.
    class Swatter(progress: Long = 0) : Bonus(
        score = 350,
        hits = 70,
        description = "🏸",
        sound = SoundType.Swish,
        progress = progress
    )

    // Bash bugs with a zapper.
    class Zapper(progress: Long = 0) : Bonus(
        score = 400,
        hits = 100,
        description = "⚡",
        sound = SoundType.Laser,
        progress = progress
    )
}