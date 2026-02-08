package pnemonic.bug_bash.sound

import androidx.annotation.FloatRange
import javax.sound.sampled.Clip
import javax.sound.sampled.FloatControl
import kotlin.math.log10

actual class AudioPlayer(actual val soundType: SoundType, val player: Clip) {
    actual fun prepare() {
        if (soundType.repeat) {
            player.loop(Clip.LOOP_CONTINUOUSLY)
        }
        player.setVolume(soundType.volume)
        player.microsecondPosition = 0L
    }

    actual fun play() {
        player.microsecondPosition = 0L
        player.start()
    }

    actual fun pause() {
        player.stop()
    }

    actual fun stop() {
        player.stop()
    }

    actual fun release() {
        player.close()
    }

    companion object {
        fun Clip.setVolume(@FloatRange(0.0, 1.0) volume: Float) {
            val volumeControl =
                controls.firstOrNull { it.type == FloatControl.Type.VOLUME } as? FloatControl
            if (volumeControl != null) {
                volumeControl.setVolume(volume)
                return
            }

            val gainControl =
                controls.firstOrNull { it.type == FloatControl.Type.MASTER_GAIN } as? FloatControl
            if (gainControl != null) {
                gainControl.setGain(volume)
                return
            }
        }

        private fun FloatControl.setGain(@FloatRange(0.0, 2.0) volume: Float) {
            val db = 20f * log10(volume)
            value = db
        }

        private fun FloatControl.setVolume(@FloatRange(0.0, 1.0) volume: Float) {
            val range = maximum - minimum
            value = minimum + (range * volume)
        }
    }
}