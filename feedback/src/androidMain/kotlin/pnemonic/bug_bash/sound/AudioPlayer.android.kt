package pnemonic.bug_bash.sound

import androidx.annotation.MainThread
import androidx.media3.common.Player
import androidx.media3.common.Player.REPEAT_MODE_ONE
import androidx.media3.exoplayer.ExoPlayer

actual class AudioPlayer(actual val soundType: SoundType, private val player: ExoPlayer) {

    @MainThread
    actual fun prepare() {
        if (soundType.repeat) {
            player.repeatMode = REPEAT_MODE_ONE
            player.volume = 0.15f
        }
        player.prepare()
    }

    @MainThread
    actual fun play() {
        if (player.playbackState == Player.STATE_IDLE) {
            player.prepare()
        }
        player.seekTo(1L)
        player.play()
    }

    @MainThread
    actual fun pause() {
        player.pause()
    }

    @MainThread
    actual fun stop() {
        player.stop()
    }

    actual fun release() {
        player.release()
    }
}