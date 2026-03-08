package pnemonic.bug_bash.view.home

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.update
import pnemonic.bug_bash.BugFactory
import pnemonic.bug_bash.GameEngine
import pnemonic.bug_bash.model.Board
import pnemonic.bug_bash.model.bug.Caterpillar
import pnemonic.bug_bash.model.bug.Swarm
import pnemonic.bug_bash.model.bug.Worm
import pnemonic.remove

class HomeEngine(coroutineScope: CoroutineScope) : GameEngine(coroutineScope) {
    override fun generateSwarm(board: Board): Swarm {
        val bugs = BugFactory.allBugs
        // Caterpillars and Worms are too slow.
        val caterpillar = bugs.first { it is Caterpillar }
        val worm = bugs.first { it is Worm }
        return Swarm(bugs.remove(caterpillar).remove(worm).shuffled(rand))
    }

    override suspend fun finished() {
        _boards.update { it.copy(lives = Int.MAX_VALUE) }
    }
}