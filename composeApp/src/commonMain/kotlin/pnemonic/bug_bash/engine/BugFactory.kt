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
import kotlin.random.Random
import kotlin.reflect.KClass

object BugFactory {

    private const val BUGS_PER_LEVEL = 10

    private val level1 = listOf(Centipede::class)
    private val level2 = level1 + listOf(Caterpillar::class, Snail::class)
    private val level3 = level2 + listOf(Ant::class, Termite::class)
    private val level4 = level3 + listOf(Cockroach::class, Worm::class)
    private val level5 = level4 + listOf(Cricket::class, Ladybug::class)
    private val level6 = level5 + listOf(Beetle::class)
    private val level7 = level6 + listOf(Butterfly::class, Scorpion::class)
    private val level8 = level7 + listOf(Fly::class, Moth::class)
    private val level9 = level8 + listOf(Dragonfly::class, Mosquito::class)
    private val level10 = level9 + listOf(Spider::class)
    private val level11 = level10 + listOf(Bee::class)
    private val level12 = level11 + listOf(Wasp::class)

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

    private fun createBug(candidates: List<KClass<out Bug>>): Bug {
        val i = rand.nextInt(candidates.size)
        val klass = candidates[i]
        // klass.createInstance() does not work in JS
        return when (klass) {
            Ant::class -> Ant()
            Bee::class -> Bee()
            Beetle::class -> Beetle()
            Butterfly::class -> Butterfly()
            Caterpillar::class -> Caterpillar()
            Centipede::class -> Centipede()
            Cockroach::class -> Cockroach()
            Cricket::class -> Cricket()
            Dragonfly::class -> Dragonfly()
            Fly::class -> Fly()
            Ladybug::class -> Ladybug()
            Mosquito::class -> Mosquito()
            Moth::class -> Moth()
            Scorpion::class -> Scorpion()
            Snail::class -> Snail()
            Spider::class -> Spider()
            Swarm::class -> Swarm()
            Termite::class -> Termite()
            Wasp::class -> Wasp()
            Worm::class -> Worm()
            else -> throw IllegalArgumentException(klass.toString())
        } as Bug
    }

    private fun createCandidates(level: Int): List<KClass<out Bug>> {
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

    val allBugs: List<Bug> get() = listOf(
        Ant(),
        Bee(),
        Beetle(),
        Butterfly(),
        Caterpillar(),
        Centipede(),
        Cockroach(),
        Cricket(),
        Dragonfly(),
        Fly(),
        Ladybug(),
        Mosquito(),
        Moth(),
        Scorpion(),
        Snail(),
        Spider(),
        Termite(),
        Wasp(),
        Worm()
    )
}