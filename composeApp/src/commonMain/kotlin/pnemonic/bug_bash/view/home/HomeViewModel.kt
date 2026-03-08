package pnemonic.bug_bash.view.home

import androidx.compose.ui.unit.IntSize
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pnemonic.bug_bash.GameEngine
import pnemonic.bug_bash.control.LifecycleViewModel
import pnemonic.bug_bash.model.Board
import pnemonic.bug_bash.model.Difficulty
import pnemonic.bug_bash.model.bug.Bug
import pnemonic.bug_bash.view.navigation.Routes
import pnemonic.bug_bash.view.settings.SettingsManager

class HomeViewModel : LifecycleViewModel() {
    private val settings = SettingsManager
    val isMusicEnabled get() = settings.isMusicEnabled
    val isSoundEnabled get() = settings.isSoundEnabled
    val difficulty get() = settings.difficulty

    private var engine = HomeEngine(viewModelScope)
    private val _board = MutableStateFlow(engine.boards.value)
    val board: StateFlow<Board> = _board

    init {
        collectAll(engine)
    }

    private fun collectAll(engine: GameEngine) {
        viewModelScope.launch {
            engine.boards.collect {
                _board.emit(it)
            }
        }
        viewModelScope.launch {
            _board.emit(engine.boards.value)
        }
    }

    override fun onStart() {
        engine.start(difficulty)
    }

    override fun onPause() {
        engine.pause()
    }

    override fun onStop() {
        engine.stop()
    }

    fun onMusicChange(enabled: Boolean) {
        SettingsManager.isMusicEnabled = enabled
    }

    fun onSoundChange(enabled: Boolean) {
        SettingsManager.isSoundEnabled = enabled
    }

    fun onPlayClick(navController: NavHostController) {
        navController.navigate(Routes.Board.route)
    }

    fun onHelpClick(navController: NavHostController) {
        navController.navigate(Routes.Help.route)
    }

    fun onDifficultyChange(difficulty: Difficulty) {
        SettingsManager.difficulty = difficulty
    }

    fun onBoardSize(size: IntSize) {
        engine.onSize(size)
    }

    fun onBugSize(bug: Bug) {
        engine.onBugSize(bug)
    }
}