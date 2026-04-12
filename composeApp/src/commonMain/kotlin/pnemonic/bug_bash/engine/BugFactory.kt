package pnemonic.bug_bash.engine

import pnemonic.bug_bash.model.Difficulty
import pnemonic.bug_bash.model.Difficulty.Companion.times
import pnemonic.bug_bash.model.bug.Ant
import pnemonic.bug_bash.model.bug.Bee
import pnemonic.bug_bash.model.bug.Beetle
import pnemonic.bug_bash.model.bug.Bug
import pnemonic.bug_bash.model.bug.Butterfly
import pnemonic.bug_bash.model.bug.Caterpillar
import pnemonic.bug_bash.model.bug.Centipede
import pnemonic.bug_bash.model.bug.Cockroach
import pnemonic.bug_bash.model.bug.Cricket
import pnemonic.bug_bash.model.bug.Dragonfly
import pnemonic.bug_bash.model.bug.Fly
import pnemonic.bug_bash.model.bug.Ladybug
import pnemonic.bug_bash.model.bug.Mosquito
import pnemonic.bug_bash.model.bug.Moth
import pnemonic.bug_bash.model.bug.Scorpion
import pnemonic.bug_bash.model.bug.Snail
import pnemonic.bug_bash.model.bug.Spider
import pnemonic.bug_bash.model.bug.Swarm
import pnemonic.bug_bash.model.bug.Termite
import pnemonic.bug_bash.model.bug.Wasp
import pnemonic.bug_bash.model.bug.Worm
import pnemonic.times
import kotlin.random.Random

typealias KlassName = String

object BugFactory {

    private const val BUGS_PER_LEVEL = 10

    private const val CLASS_ANT = "Ant"
    private const val CLASS_BEE = "Bee"
    private const val CLASS_BEETLE = "Beetle"
    private const val CLASS_BUTTERFLY = "Butterfly"
    private const val CLASS_CATERPILLAR = "Caterpillar"
    private const val CLASS_CENTIPEDE = "Centipede"
    private const val CLASS_COCKROACH = "Cockroach"
    private const val CLASS_CRICKET = "Cricket"
    private const val CLASS_DRAGONFLY = "Dragonfly"
    private const val CLASS_FLY = "Fly"
    private const val CLASS_LADYBUG = "Ladybug"
    private const val CLASS_MOSQUITO = "Mosquito"
    private const val CLASS_MOTH = "Moth"
    private const val CLASS_SCORPION = "Scorpion"
    private const val CLASS_SNAIL = "Snail"
    private const val CLASS_SPIDER = "Spider"
    private const val CLASS_TERMITE = "Termite"
    private const val CLASS_WASP = "Wasp"
    private const val CLASS_WORM = "Worm"

    private val level1 = listOf(CLASS_CENTIPEDE)
    private val level2 = level1 + listOf(CLASS_CATERPILLAR, CLASS_SNAIL) * 2
    private val level3 = level2 + listOf(CLASS_ANT, CLASS_TERMITE) * 3
    private val level4 = level3 + listOf(CLASS_COCKROACH, CLASS_WORM) * 4
    private val level5 = level4 + listOf(CLASS_CRICKET, CLASS_LADYBUG) * 5
    private val level6 = level5 + listOf(CLASS_BEETLE) * 6
    private val level7 = level6 + listOf(CLASS_BUTTERFLY, CLASS_SCORPION) * 7
    private val level8 = level7 + listOf(CLASS_FLY, CLASS_MOTH) * 8
    private val level9 = level8 + listOf(CLASS_DRAGONFLY, CLASS_MOSQUITO) * 9
    private val level10 = level9 + listOf(CLASS_SPIDER) * 10
    private val level11 = level10 + listOf(CLASS_BEE) * 11
    private val level12 = level11 + listOf(CLASS_WASP) * 12

    private val levels = mapOf(
        1 to level1,
        2 to level2,
        3 to level3,
        4 to level4,
        5 to level5,
        6 to level6,
        7 to level7,
        8 to level8,
        9 to level9,
        10 to level10,
        11 to level11,
        12 to level12
    )

    private val rand = Random.Default

    private fun createBug(candidates: List<KlassName>): Bug {
        val i = rand.nextInt(candidates.size)
        // klass.createInstance() does not work in JS
        return when (val klass = candidates[i]) {
            CLASS_ANT -> Ant()
            CLASS_BEE -> Bee()
            CLASS_BEETLE -> Beetle()
            CLASS_BUTTERFLY -> Butterfly()
            CLASS_CATERPILLAR -> Caterpillar()
            CLASS_CENTIPEDE -> Centipede()
            CLASS_COCKROACH -> Cockroach()
            CLASS_CRICKET -> Cricket()
            CLASS_DRAGONFLY -> Dragonfly()
            CLASS_FLY -> Fly()
            CLASS_LADYBUG -> Ladybug()
            CLASS_MOSQUITO -> Mosquito()
            CLASS_MOTH -> Moth()
            CLASS_SCORPION -> Scorpion()
            CLASS_SNAIL -> Snail()
            CLASS_SPIDER -> Spider()
            CLASS_TERMITE -> Termite()
            CLASS_WASP -> Wasp()
            CLASS_WORM -> Worm()
            else -> throw IllegalArgumentException(klass)
        }
    }

    private fun createCandidates(level: Int): List<KlassName> {
        return levels[level] ?: level12
    }

    fun createSwarm(level: Int, difficulty: Difficulty): Swarm {
        val size = BUGS_PER_LEVEL * level * difficulty
        val candidates = createCandidates(level)
        val bugs = mutableListOf<Bug>()

        (1..size).forEach { _ ->
            val bug = createBug(candidates)
            bugs.add(bug)
        }

        return Swarm(bugs)
    }

    // slowest crawlers start first.
    val allBugs: List<Bug>
        get() = listOf(
            Worm(),
            Snail(),
            Caterpillar(),
            Centipede(),
            Beetle(),

            Ant(),
            Bee(),
            Butterfly(),
            Cockroach(),
            Cricket(),
            Dragonfly(),
            Fly(),
            Ladybug(),
            Mosquito(),
            Moth(),
            Scorpion(),
            Spider(),
            Termite(),
            Wasp(),
        )
}