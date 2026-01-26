package pnemonic.bug_bash.sound

import bug_bash.feedback.generated.resources.Res
import org.w3c.dom.Audio

actual object AudioPlayerFactory {
    actual fun create(soundType: SoundType): AudioPlayer? {
        val path = Res.getUri("files/sounds/${soundType.fileName}")
        val player = Audio(path)
        return AudioPlayer(soundType, player)
    }
}