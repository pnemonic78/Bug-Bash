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
import kotlin.math.max
import kotlin.random.Random
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

class GameEngine(private val coroutineScope: CoroutineScope) {
    private var ticker: Job? = null

    private val _boards = MutableStateFlow(Board())
    val boards: StateFlow<Board> get() = _boards

    private val _state = MutableStateFlow(GameState.NOT_STARTED)
    val state: StateFlow<GameState> get() = _state
    private val isRunning get() = state.value === GameState.STARTED

    private val rand = Random.Default
    private val touched = mutableListOf<Bug>()

    fun start() {
        ticker = coroutineScope.launch(Dispatchers.Default) {
            _state.emit(GameState.STARTED)
            while (isActive) {
                run()
                delay(TICK)
            }
        }
    }

    fun pause() {
        _state.value = GameState.PAUSED
    }

    fun stop() {
        _state.value = GameState.STOPPED
        ticker?.cancel()
        ticker = null
    }

    private suspend fun run() {
        if (!isRunning) return
        var board = boards.value
        if ((board.width <= 0f) || (board.height <= 0f)) {
            return
        }
        // Mo more lives -> game is done.
        if (board.lives <= 0) {
            println("No more lives")
            _state.emit(GameState.FINISHED)
            return
        }
        // No more bugs -> level is done.
        if (board.isLevelFinished()) {
            board = nextLevel(board)
        }
        board = move(board)
        board = touch(board)
        _boards.emit(board)
    }

    private fun move(board: Board): Board {
        if (board.swarm.isEmpty()) return board
        if ((board.width <= 0) || (board.height <= 0)) return board
        var lives = board.lives
        val bugs = board.swarm.bugs
        val removed = mutableListOf<Bug>()
        val squashed = mutableListOf<Bug>()

        for (bug in bugs) {
            if (bug.isBadMove()) {
                continue
            }
            if (bug.thaw(TICK)) {
                continue
            }
            bug.move()
            if (bug.didEscape()) {
                removed.add(bug)
                lives--
            }
            if (bug.isSquashed) {
                squashed.add(bug)
            }
        }

        return if (removed.isEmpty() && squashed.isEmpty()) {
            board
        } else {
            val bugs = bugs.toMutableList()
            bugs.removeAll(removed)
            bugs.removeAll(squashed)
            board.copy(swarm = Swarm(bugs), lives = lives)
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
        touched.add(bug)
//        coroutineScope.launch {
//            var board = boards.value
//            board = touch(board, bug)
//            _boards.emit(board)
//        }
    }

    private fun touch(board: Board): Board {
        val bugs = touched
        if (bugs.isEmpty()) return board

        var lives = board.lives
        var score = board.score

        for (bug in bugs) {
            if (bug.isSquashed) {
                continue
            }
            bug.hit()
            if (bug.isSquashed) {
                score += bug.score
                if (score < 0) {
                    lives--
                }
                score = max(0, score)
            }
        }
        bugs.clear()

        return board.copy(score = score, lives = lives)
    }

    fun onBugSize(bug: Bug) {
        val board = boards.value
        val width = board.width
        val height = board.height
        val bugWidth = bug.width
        val bugHeight = bug.height

        //TODO try to avoid overlap bugs with each other.
        val side = rand.nextInt(SIDE_MIN, SIDE_MAX)
        var x1 = 0f
        var y1 = 0f
        var x2 = 0f
        var y2 = 0f
        when (side) {
            SIDE_TOP -> {
                x1 = rand.nextFloat() * width
                y1 = -bugHeight * 1.1f
                x2 = rand.nextFloat() * width
                y2 = height + bugHeight
            }

            SIDE_BOTTOM -> {
                x1 = rand.nextFloat() * width
                y1 = height * 1.1f
                x2 = rand.nextFloat() * width
                y2 = -bugHeight
            }

            SIDE_LEFT -> {
                x1 = -bugWidth * 1.1f
                y1 = rand.nextFloat() * height
                x2 = width + bugWidth
                y2 = rand.nextFloat() * height
            }

            SIDE_RIGHT -> {
                x1 = width * 1.1f
                y1 = rand.nextFloat() * height
                x2 = -bugWidth
                y2 = rand.nextFloat() * height
            }
        }
        x1 = 0f
        y1 = rand.nextFloat() * height
        x2 = width / 2
        y2 = y1
        bug.moveTo(x1, y1)
        bug.setDestination(x2, y2)
    }

    private fun generateBugs(board: Board): Board {
        val level = board.level
        val difficulty = board.difficulty
        val size = BUGS_PER_LEVEL * level * difficulty
        val candidates = createCandidates(level) as List<KClass<Bug>>
        val bugs = mutableListOf<Bug>()
        var delay = 0L

        (1..size).forEach { _ ->
            val bug = createBug(candidates)
            bug.freeze(delay)
            bugs.add(bug)
            delay += DELAY_PER_BUG
        }

        return board.copy(swarm = Swarm(bugs))
    }

    private fun createCandidates(level: Int): List<KClass<out Bug>> {
        return levels[level] ?: level12
    }

    private fun createBug(candidates: List<KClass<Bug>>): Bug {
        val i = rand.nextInt(candidates.size)
        val klass = candidates[i]
        return klass.createInstance()
    }

    private fun nextLevel(board: Board): Board {
        var board = board
        val level = board.level + 1
        var scene = board.scene
        if (level % 3 == 0) {
            scene = scene.next()
        }
        board = generateBugs(board.copy(level = level, scene = scene))
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
        private const val BUGS_PER_LEVEL = 2
        private const val DELAY_PER_BUG = TICK * 15

        private const val SIDE_TOP = 0
        private const val SIDE_LEFT = 1
        private const val SIDE_BOTTOM = 2
        private const val SIDE_RIGHT = 3
        private const val SIDE_MIN = SIDE_TOP
        private const val SIDE_MAX = SIDE_RIGHT + 1

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
    }
}
