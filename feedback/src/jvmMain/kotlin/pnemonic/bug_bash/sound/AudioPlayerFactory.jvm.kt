package pnemonic.bug_bash.sound

import androidx.annotation.FloatRange
import bug_bash.feedback.generated.resources.Res
import java.io.BufferedInputStream
import java.net.URI
import javax.sound.sampled.AudioSystem
import javax.sound.sampled.Clip
import javax.sound.sampled.FloatControl
import kotlin.math.log10

actual object AudioPlayerFactory {
    actual fun create(soundType: SoundType): AudioPlayer? {
        val path = Res.getUri("files/sounds/${soundType.fileName}")
        val url = URI(path).toURL()
        val stream = BufferedInputStream(url.openStream())
        return try {
            val audio = AudioSystem.getAudioInputStream(stream)
            val clip = AudioSystem.getClip()
            clip.open(audio)
            AudioPlayer(soundType, clip)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}