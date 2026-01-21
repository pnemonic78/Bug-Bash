package pnemonic.bug_bash

import androidx.compose.ui.unit.IntSize
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import pnemonic.bug_bash.model.Board
import pnemonic.bug_bash.model.Bug
import pnemonic.bug_bash.model.GameState
import pnemonic.bug_bash.model.Swarm
import kotlin.math.max
import kotlin.random.Random

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
        val widthPad = width * 0.125f
        val heightPad = height * 0.125f
        val widthPadded = width - widthPad - widthPad
        val heightPadded = height - heightPad - heightPad
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
                x1 = widthPad + (rand.nextFloat() * widthPadded)
                y1 = -(bugHeight * 1.1f)
                x2 = widthPad + (rand.nextFloat() * widthPadded)
                y2 = height + bugHeight
            }

            SIDE_BOTTOM -> {
                x1 = widthPad + (rand.nextFloat() * widthPadded)
                y1 = height + (bugHeight * 1.1f)
                x2 = widthPad + (rand.nextFloat() * widthPadded)
                y2 = -bugHeight
            }

            SIDE_LEFT -> {
                x1 = -(bugWidth * 1.1f)
                y1 = heightPad + (rand.nextFloat() * heightPadded)
                x2 = width + bugWidth
                y2 = heightPad + (rand.nextFloat() * heightPadded)
            }

            SIDE_RIGHT -> {
                x1 = width + (bugWidth * 1.1f)
                y1 = heightPad + (rand.nextFloat() * heightPadded)
                x2 = -bugWidth
                y2 = heightPad + (rand.nextFloat() * heightPadded)
            }
        }
        bug.moveTo(x1, y1)
        bug.setDestination(x2, y2)
    }

    private fun generateBugs(board: Board): Board {
        val level = board.level
        val difficulty = board.difficulty
        val swarm = BugFactory.createSwarm(level, difficulty)
        var delay = 0L

        for (bug in swarm) {
            bug.freeze(delay)
            delay += DELAY_PER_BUG
        }

        return board.copy(swarm = swarm)
    }

    private fun nextLevel(board: Board): Board {
        var board = board
        val level = board.level + 1
        var scene = board.scene
        if (level % NEXT_SCENE == 0) {
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
        private const val DELAY_PER_BUG = TICK * 15
        private const val NEXT_SCENE = 3

        private const val SIDE_TOP = 0
        private const val SIDE_LEFT = 1
        private const val SIDE_BOTTOM = 2
        private const val SIDE_RIGHT = 3
        private const val SIDE_MIN = SIDE_TOP
        private const val SIDE_MAX = SIDE_RIGHT + 1
    }
}
