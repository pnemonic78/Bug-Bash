package pnemonic.bug_bash.control

import androidx.compose.ui.unit.IntSize
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pnemonic.bug_bash.Feedback
import pnemonic.bug_bash.GameEngine
import pnemonic.bug_bash.Platform
import pnemonic.bug_bash.getPlatform
import pnemonic.bug_bash.model.Board
import pnemonic.bug_bash.model.Bug
import pnemonic.bug_bash.model.GameState
import pnemonic.bug_bash.sound.SoundType
import pnemonic.bug_bash.view.settings.SettingsManager

class GameViewModel : LifecycleViewModel() {

    private val engine = GameEngine(viewModelScope)
    private val platform: Platform = getPlatform()
    private val settings = SettingsManager

    val board: StateFlow<Board> get() = engine.boards
    val state: StateFlow<GameState> get() = engine.state
    val isMusicEnabled get() = settings.isMusicEnabled
    val isSoundEnabled get() = settings.isSoundEnabled

    init {
        viewModelScope.launch {
            engine.feedback.collect { feedback ->
                notifyFeedback(feedback)
            }
        }
    }

    override fun onStart() {
        engine.start()
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

    suspend fun notifyFeedback(feedback: Feedback) {
        when (feedback) {
            Feedback.None -> Unit
            Feedback.Vibrate -> Unit
            is Feedback.Bash -> bash(feedback.soundType)
            is Feedback.Sound -> playSound(feedback.soundType)
        }
        engine.feedbackDone()
    }

    private suspend fun bash(soundType: SoundType = SoundType.Pop) {
        platform.haptic.vibrate(VIBRATE_BASH_DURATION, VIBRATE_BASH_AMPLITUDE)
        playSound(soundType)
    }

    private suspend fun playSound(soundType: SoundType) {
        if ((soundType.repeat && isMusicEnabled) || isSoundEnabled) {
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

    companion object {
        private const val VIBRATE_BASH_DURATION = 50L
        private const val VIBRATE_BASH_AMPLITUDE = 0.35f
    }
}