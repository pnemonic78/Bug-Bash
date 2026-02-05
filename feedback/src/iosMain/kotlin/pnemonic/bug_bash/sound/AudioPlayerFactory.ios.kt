package pnemonic.bug_bash.sound

import bug_bash.feedback.generated.resources.Res
import kotlinx.cinterop.ExperimentalForeignApi
import platform.AVFAudio.AVAudioPlayer
import platform.Foundation.NSURL

actual object AudioPlayerFactory {
    @OptIn(ExperimentalForeignApi::class)
    actual fun create(soundType: SoundType): AudioPlayer? {
        val name = soundType.fileName
        if (name.isEmpty()) return null
        val path = Res.getUri("files/sounds/$name")
        val url = NSURL.URLWithString(URLString = path)!!
        val player = AVAudioPlayer(url, error = null)
        return AudioPlayer(soundType, player)
    }
}