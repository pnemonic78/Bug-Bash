package pnemonic.bug_bash.view.board

import androidx.annotation.FloatRange
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.IntSize
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pnemonic.bug_bash.Feedback
import pnemonic.bug_bash.Platform
import pnemonic.bug_bash.control.LifecycleViewModel
import pnemonic.bug_bash.engine.GameEngine
import pnemonic.bug_bash.getPlatform
import pnemonic.bug_bash.model.Board
import pnemonic.bug_bash.model.Bonus
import pnemonic.bug_bash.model.GameState
import pnemonic.bug_bash.model.bug.Bug
import pnemonic.bug_bash.model.tool.Tool
import pnemonic.bug_bash.sound.SoundType
import pnemonic.bug_bash.view.settings.SettingsManager

class GameViewModel : LifecycleViewModel() {

    private var engine = GameEngine(viewModelScope)
    private val platform: Platform = getPlatform()
    private val settings = SettingsManager

    private val _board = MutableStateFlow(engine.boards.value)
    val board: StateFlow<Board> = _board
    private val _state = MutableStateFlow(engine.state.value)
    val state: StateFlow<GameState> get() = engine.state
    val isPaused get() = engine.isPaused
    val isMusicEnabled get() = settings.isMusicEnabled
    val isSoundEnabled get() = settings.isSoundEnabled
    val difficulty get() = settings.difficulty

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
            engine.state.collect {
                _state.emit(it)
            }
        }
        viewModelScope.launch {
            engine.feedback.collect {
                notifyFeedback(it)
            }
        }
        viewModelScope.launch {
            _board.emit(engine.boards.value)
            _state.emit(engine.state.value)
        }
    }

    override fun onStart() {
        engine.start(difficulty)
        platform.sound.onStart()
    }

    override fun onPause() {
        engine.pause()
    }

    override fun onStop() {
        engine.stop()
        platform.sound.onStop()
    }

    override fun onDestroy() {
        platform.haptic.onDestroy()
        platform.sound.onDestroy()
    }

    fun onBoardSize(size: IntSize) {
        engine.onSize(size)
    }

    fun onTap(offset: Offset) {
        engine.touch(offset)
    }

    fun onBugTap(bug: Bug) {
        engine.touch(bug)
    }

    fun onBugSize(bug: Bug) {
        engine.onBugSize(bug)
    }

    suspend fun notifyFeedback(feedback: Feedback) {
        when (feedback) {
            Feedback.None -> return
            is Feedback.Vibrate -> vibrate(feedback.duration, feedback.amplitude)
            is Feedback.Bash -> bash(feedback)
            is Feedback.Silence -> stopSound(feedback.soundType)
            is Feedback.Sound -> playSound(feedback.soundType)
        }
        engine.feedbackDone()
    }

    private suspend fun bash(feedback: Feedback.Bash) {
        vibrate(VIBRATE_BASH_DURATION, VIBRATE_BASH_AMPLITUDE)
        playSound(feedback.soundType)
    }

    private suspend fun playSound(soundType: SoundType) {
        if ((soundType.repeat && isMusicEnabled) || (!soundType.repeat && isSoundEnabled)) {
            withContext(Dispatchers.Main) {
                platform.sound.play(soundType)
            }
        }
    }

    private suspend fun stopSound(soundType: SoundType) {
        withContext(Dispatchers.Main) {
            if (soundType.repeat) {
                platform.sound.pause(soundType)
            } else {
                platform.sound.stop(soundType)
            }
        }
    }

    private fun vibrate(
        duration: Long = 300,
        @FloatRange(from = 0.0, to = 1.0) amplitude: Float = 1f
    ) {
        platform.haptic.vibrate(duration, amplitude)
    }

    fun onSoundChange(enabled: Boolean) {
        SettingsManager.isSoundEnabled = enabled
    }

    fun onMusicChange(enabled: Boolean) {
        SettingsManager.isMusicEnabled = enabled
        viewModelScope.launch {
            val sound = board.value.scene.music.soundType
            if (enabled) {
                playSound(sound)
            } else {
                stopSound(sound)
            }
        }
    }

    fun onBonusClick(bonus: Bonus) {
        engine.onBonusClick(bonus)
    }

    fun onPauseChange(paused: Boolean) {
        if (paused) {
            engine.pause()
        } else {
            engine.resume()
        }
    }

    fun onToolUse(tool: Tool) {
        engine.onToolUse(tool)
    }

    companion object {
        private const val VIBRATE_BASH_DURATION = 50L
        private const val VIBRATE_BASH_AMPLITUDE = 0.35f
    }
}