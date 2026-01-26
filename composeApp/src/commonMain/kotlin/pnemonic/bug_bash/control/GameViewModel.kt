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
    var isSoundEnabled = true
        private set
    var isMusicEnabled = true
        private set

    init {
        viewModelScope.launch {
            engine.feedback.collect { feedback ->
                notifyFeedback(feedback)
            }
        }
    }

    fun onStart() {
        engine.start()
        platform.sound.onStart()
    }

    fun onPause() {
        engine.pause()
    }

    fun onStop() {
        engine.stop()
        platform.sound.onStop()
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