package pnemonic.bug_bash.control

import androidx.compose.ui.unit.IntSize
import androidx.lifecycle.ViewModel
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

class GameViewModel : ViewModel() {

    private val engine = GameEngine(viewModelScope)
    private val platform: Platform = getPlatform()

    val board: StateFlow<Board> get() = engine.boards
    val state: StateFlow<GameState> get() = engine.state

    init {
        viewModelScope.launch {
            engine.feedback.collect { feedback ->
                notifyFeedback(feedback)
            }
        }
    }

    fun onStart() {
        engine.start()
    }

    fun onPause() {
        engine.pause()
    }

    fun onStop() {
        engine.stop()
    }

    fun onDestroy() {
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
            is Feedback.None -> Unit
            Feedback.Bash -> bash()
            is Feedback.Sound -> playSound(feedback.soundType)
            Feedback.Vibrate -> Unit
        }
        engine.feedbackDone()
    }

    private suspend fun bash() {
        platform.haptic.vibrate(VIBRATE_BASH_DURATION, VIBRATE_BASH_AMPLITUDE)
        playSound(SoundType.Bash)
    }

    private suspend fun playSound(soundType: SoundType) {
        if (!isSoundEnabled) return
        withContext(Dispatchers.Main) {
            platform.sound.play(soundType)
        }
    }

    private suspend fun pauseSound(soundType: SoundType) {
        withContext(Dispatchers.Main) {
            if (soundType.repeat) {
                platform.sound.pause(soundType)
            } else {
                platform.sound.stop(soundType)
            }
        }
    }

    private suspend fun stopSound(soundType: SoundType) {
        withContext(Dispatchers.Main) {
            platform.sound.stop(soundType)
        }
    }

    fun onSoundChange(checked: Boolean) {
        isSoundEnabled = checked
    }

    fun onMusicChange(checked: Boolean) {
        isMusicEnabled = checked
        viewModelScope.launch {
            val sound = board.value.scene.music.soundType
            if (checked) {
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