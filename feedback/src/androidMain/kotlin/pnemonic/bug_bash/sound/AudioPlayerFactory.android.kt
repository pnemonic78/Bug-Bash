package pnemonic.bug_bash.sound

import android.annotation.SuppressLint
import android.content.Context
import androidx.annotation.MainThread
import androidx.core.net.toUri
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import bug_bash.feedback.generated.resources.Res

@SuppressLint("StaticFieldLeak")
actual object AudioPlayerFactory {

    private lateinit var context: Context

    fun initialize(context: Context) {
        this.context = context.applicationContext
    }

    @MainThread
    actual fun create(soundType: SoundType): AudioPlayer? {
        val path = Res.getUri("files/sounds/${soundType.fileName}")
        val uri = path.toUri()
        val mediaItem = MediaItem.fromUri(uri)
        val player = ExoPlayer.Builder(context).build()
        player.setMediaItem(mediaItem)
        return AudioPlayer(soundType, player)
    }
}