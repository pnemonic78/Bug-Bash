package pnemonic.bug_squash

import pnemonic.bug_squash.model.Ant
import pnemonic.bug_squash.model.Bee
import pnemonic.bug_squash.model.Bug
import pnemonic.bug_squash.model.Butterfly
import pnemonic.bug_squash.model.Caterpillar
import pnemonic.bug_squash.model.Cockroach
import pnemonic.bug_squash.model.Difficulty
import pnemonic.bug_squash.model.Difficulty.Companion.times
import pnemonic.bug_squash.model.Fly
import pnemonic.bug_squash.model.Ladybug
import pnemonic.bug_squash.model.Mosquito
import pnemonic.bug_squash.model.Moth
import pnemonic.bug_squash.model.Scorpion
import pnemonic.bug_squash.model.Snail
import pnemonic.bug_squash.model.Spider
import pnemonic.bug_squash.model.Swarm
import pnemonic.bug_squash.model.Termite
import pnemonic.bug_squash.model.Wasp
import pnemonic.bug_squash.model.Worm
import kotlin.random.Random
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

object BugFactory {

    private const val BUGS_PER_LEVEL = 10

    private val level1 = listOf(Snail::class)
    private val level2 = level1 + listOf(Worm::class)
    private val level3 = level2 + listOf(Caterpillar::class)
    private val level4 = level3 + listOf(Ant::class)
    private val level5 = level4 + listOf(Cockroach::class, Termite::class)
    private val level6 = level5 + listOf(Spider::class)
    private val level7 = level6 + listOf(Scorpion::class)
    private val level8 = level7 + listOf(Butterfly::class, Moth::class)
    private val level9 = level8 + listOf(Mosquito::class)
    private val level10 = level9 + listOf(Fly::class, Ladybug::class)
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

    private fun createBug(candidates: List<KClass<Bug>>): Bug {
        val i = rand.nextInt(candidates.size)
        val klass = candidates[i]
        return klass.createInstance()
    }

    private fun createCandidates(level: Int): List<KClass<out Bug>> {
        return levels[level] ?: level12
    }

    fun createSwarm(level: Int, difficulty: Difficulty): Swarm {
        val size = BUGS_PER_LEVEL * level * difficulty
        val candidates = createCandidates(level) as List<KClass<Bug>>
        val bugs = mutableListOf<Bug>()

        (1..size).forEach { _ ->
            val bug = createBug(candidates)
            bugs.add(bug)
        }

        return Swarm(bugs)
    }
}