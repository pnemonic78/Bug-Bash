package pnemonic.bug_squash.control

import androidx.compose.ui.unit.IntSize
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.StateFlow
import pnemonic.bug_squash.GameEngine
import pnemonic.bug_squash.model.Board
import pnemonic.bug_squash.model.Bug
import pnemonic.bug_squash.model.GameState

class GameViewModel : ViewModel() {

    private val engine = GameEngine(viewModelScope)

    val board: StateFlow<Board> get() = engine.boards
    val state: StateFlow<GameState> get() = engine.state

    fun onStart() {
        engine.start()
    }

    fun onPause() {
        engine.pause()
    }

    fun onStop() {
        engine.stop()
    }

    fun onSize(size: IntSize) {
        engine.onSize(size)
    }

    fun onTap(bug: Bug) {
        engine.onTap(bug)
    }

    fun onBugSize(bug: Bug) {
        engine.onBugSize(bug)
    }

    fun onDead(bug: Bug) {
        engine.onDead(bug)
    }
}