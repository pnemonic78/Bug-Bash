package pnemonic.bug_bash.sound

import org.w3c.dom.Audio
import kotlin.js.ExperimentalWasmJsInterop

actual class AudioPlayer(actual val soundType: SoundType, private val player: Audio) {
    actual fun prepare() {
        if (soundType.repeat) {
            player.loop = true
        }
        player.volume = soundType.volume.toDouble()
        player.load()
    }

    @OptIn(ExperimentalWasmJsInterop::class)
    actual fun play() {
        if (player.paused || player.ended) {
            player.currentTime = 0.0
            player.play()
        }
    }

    actual fun pause() {
        if (!player.paused && !player.ended) {
            player.pause()
        }
    }

    actual fun stop() {
        pause()
        player.currentTime = 0.0
    }

    actual fun release() {
    }
}