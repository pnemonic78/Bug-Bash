package pnemonic.bug_bash.sound

import platform.AVFAudio.AVAudioPlayer

actual class AudioPlayer(actual val soundType: SoundType, private val player: AVAudioPlayer) {

    actual fun prepare() {
        if (soundType.repeat) {
            player.numberOfLoops = -1
            player.volume = 0.15f
        }
        player.prepareToPlay()
    }

    actual fun play() {
        player.play()
    }

    actual fun pause() {
        player.pause()
    }

    actual fun stop() {
        player.stop()
    }

    actual fun release() = Unit
}