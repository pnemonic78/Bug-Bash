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
import pnemonic.bug_squash.model.Difficulty.Companion.times
import pnemonic.bug_squash.model.Fly
import pnemonic.bug_squash.model.GameState
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
    private var state: GameState = GameState.NOT_STARTED
    private val isRunning get() = state === GameState.STARTED

    private val _boards = MutableStateFlow(Board())
    val boards: StateFlow<Board> get() = _boards

    private val rand = Random.Default

    fun start() {
        state = GameState.STARTED
        ticker = coroutineScope.launch(Dispatchers.Default) {
            while (isActive) {
                run()
                delay(TICK)
            }
        }
    }

    fun pause() {
        state = GameState.PAUSED
    }

    fun stop() {
        state = GameState.STOPPED
        ticker?.cancel()
        ticker = null
    }

    private suspend fun run() {
        if (!isRunning) return
        var board = boards.value
        if ((board.width <= 0f) || (board.height <= 0f)) {
            return
        }
        // No more bugs -> level is done.
        if (board.isLevelFinished()) {
            board = nextLevel(board)
        }
        board = move(board)
        _boards.emit(board)
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
        if (!isRunning) return
        coroutineScope.launch {
            var board = boards.value
            board = board.setSize(width = size.width.toFloat(), height = size.height.toFloat())
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
        }

        return board.copy(score = score)
    }

    fun onBugSize(bug: Bug) {
        val board = boards.value
        val width = board.width
        val height = board.height
        val bugWidth = bug.width
        val bugHeight = bug.height

        //TDO try to avoid overlap bugs with each other.
        val side = rand.nextInt(SIDE_TOP, SIDE_BOTTOM + 1)
        when (side) {
            SIDE_TOP -> {
                bug.moveTo(rand.nextFloat() * width, rand.nextFloat() * bugHeight)
                bug.setDestination(rand.nextFloat() * width, height)
            }

            SIDE_BOTTOM -> {
                bug.moveTo(rand.nextFloat() * width, height - 500f - (rand.nextFloat() * bugHeight))
                bug.setDestination(rand.nextFloat() * width, -bugHeight)
            }

            SIDE_LEFT -> {
                bug.moveTo(rand.nextFloat() * bugWidth, rand.nextFloat() * height)
                bug.setDestination(width, rand.nextFloat() * height)
            }

            SIDE_RIGHT -> {
                bug.moveTo(width - (rand.nextFloat() * bugWidth), rand.nextFloat() * height)
                bug.setDestination(-bugWidth, rand.nextFloat() * height)
            }
        }
    }

    private fun generateBugs(board: Board): Board {
        val level = board.level
        val difficulty = board.difficulty
        val size = BUGS_PER_LEVEL * level * difficulty
        val candidates = createCandidates(level)
        val bugs = mutableListOf<Bug>()

        (1..size).forEach { _ ->
            val bug = createBug(candidates)
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

    private fun nextLevel(board: Board): Board {
        var board = board
        val level = board.level + 1
        //if (level > MAX_LEVELS) {
        //    state = GameState.FINISHED
        //    return board
        //}
        board = generateBugs(board.copy(level = level))
        return board
    }

    fun onDead(bug: Bug) {
        coroutineScope.launch {
            var board = boards.value
            board = remove(board, bug)
            _boards.emit(board)
        }
    }

    private fun remove(board: Board, bug: Bug): Board {
        if (!bug.isSquashed) {
            return board
        }
        val swarm = board.swarm.remove(bug)
        return board.copy(swarm = swarm)
    }

    companion object {
        private const val TICK = 50L
        private const val BUGS_PER_LEVEL = 10

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
