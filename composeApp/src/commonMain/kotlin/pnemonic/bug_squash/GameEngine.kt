package pnemonic.bug_squash

import androidx.compose.ui.unit.IntSize
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import pnemonic.bug_squash.model.Ant
import pnemonic.bug_squash.model.Bee
import pnemonic.bug_squash.model.Board
import pnemonic.bug_squash.model.Bug
import pnemonic.bug_squash.model.Butterfly
import pnemonic.bug_squash.model.Caterpillar
import pnemonic.bug_squash.model.Cockroach
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
import pnemonic.bug_squash.model.contains
import kotlin.random.Random
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

class GameEngine(private val coroutineScope: CoroutineScope) {
    private var ticker: Job? = null
    private var isRunning = false

    private val _boards = MutableStateFlow(Board())
    val boards: StateFlow<Board> get() = _boards

    private val rand = Random.Default

    fun start() {
        isRunning = true
        ticker = coroutineScope.launch(Dispatchers.Default) {
            while (isActive) {
                run()
                delay(TICK)
            }
        }
    }

    fun pause() {
        isRunning = false
    }

    fun stop() {
        isRunning = false
        ticker?.cancel()
        ticker = null
    }

    private suspend fun run() {
        if (isRunning) {
            var board = boards.value
            board = move(board)
            _boards.emit(board)
        }
    }

    private fun move(board: Board): Board {
        if ((board.width <= 0) || (board.height <= 0)) return board
        val rect = board.rect
        val bugs = mutableListOf<Bug>()
        var removed = false

        for (bug in board.swarm) {
            //TODO bug.move()
            if (rect.contains(bug)) {
                bugs.add(bug)
            } else {
                removed = true
            }
        }

        return if (removed) {
            board.copy(swarm = Swarm(bugs))
        } else {
            board
        }
    }

    fun onSize(size: IntSize) {
        coroutineScope.launch {
            var board = boards.value
            board = board.copy(width = size.width.toFloat(), height = size.height.toFloat())
            board = generateBugs(board)
            _boards.emit(board)
        }
    }

    fun onTap(bug: Bug) {
        coroutineScope.launch {
            var board = boards.value
            board = touch(board, bug)
            _boards.emit(board)
        }
    }

    private fun touch(board: Board, bug: Bug): Board {
        if (bug.isSquashed) {
            return board
        }
        var score = board.score

        bug.hit()
        if (bug.isSquashed) {
            score += bug.score
            //TODO 1 Animate squish;
            //TODO 2 remove the bug from swarm;
            //TODO 3 add another bug.
        }

        return board.copy(score = score)
    }

    private fun generateBugs(board: Board): Board {
        val width = board.width
        val height = board.height
        val bugs = mutableListOf<Bug>()
        val level = board.level
        val size = BUGS_PER_LEVEL * level
        val candidates = createCandidates(level)

        for (i in 1..size) {
            val bug = createBug(candidates)

            val side = rand.nextInt(0, 4)
            when (side) {
                SIDE_TOP -> {
                    bug.moveTo(rand.nextFloat() * width, 0f)
                    bug.directionDegrees = 270f
                }

                SIDE_BOTTOM -> {
                    bug.moveTo(rand.nextFloat() * width, height)
                    bug.directionDegrees = 90f
                }

                SIDE_LEFT -> {
                    bug.moveTo(0f, rand.nextFloat() * height)
                    bug.directionDegrees = 0f
                }

                SIDE_RIGHT -> {
                    bug.moveTo(width, rand.nextFloat() * height)
                    bug.directionDegrees = 180f
                }

                else -> throw IllegalArgumentException("invalid side")
            }

            bugs.add(bug)
        }

        return board.copy(swarm = Swarm(bugs))
    }

    private fun createCandidates(level: Int): List<KClass<Bug>> {
        return levels[level] ?: level12
    }

    private fun createBug(candidates: List<KClass<Bug>>): Bug {
        val i = rand.nextInt(candidates.size)
        val klass = candidates[i] as KClass<Bug>
        return klass.createInstance()
    }

    companion object {
        private const val TICK = 50L
        private const val BUGS_PER_LEVEL = 20

        private const val SIDE_TOP = 0
        private const val SIDE_RIGHT = 1
        private const val SIDE_LEFT = 2
        private const val SIDE_BOTTOM = 3

        private val level1 = listOf<KClass<Bug>>(Snail::class as KClass<Bug>)
        private val level2 = level1 + listOf<KClass<Bug>>(Worm::class as KClass<Bug>)
        private val level3 = level2 + listOf<KClass<Bug>>(Caterpillar::class as KClass<Bug>)
        private val level4 = level3 + listOf<KClass<Bug>>(Ant::class as KClass<Bug>)
        private val level5 = level4 + listOf<KClass<Bug>>(
            Cockroach::class as KClass<Bug>,
            Termite::class as KClass<Bug>
        )
        private val level6 = level5 + listOf<KClass<Bug>>(Spider::class as KClass<Bug>)
        private val level7 = level6 + listOf<KClass<Bug>>(Scorpion::class as KClass<Bug>)
        private val level8 = level7 + listOf<KClass<Bug>>(
            Butterfly::class as KClass<Bug>,
            Moth::class as KClass<Bug>
        )
        private val level9 = level8 + listOf<KClass<Bug>>(Mosquito::class as KClass<Bug>)
        private val level10 = level9 + listOf<KClass<Bug>>(
            Fly::class as KClass<Bug>, Ladybug::class as KClass<Bug>
        )
        private val level11 = level10 + listOf<KClass<Bug>>(Bee::class as KClass<Bug>)
        private val level12 = level11 + listOf<KClass<Bug>>(Wasp::class as KClass<Bug>)

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
    }
}
