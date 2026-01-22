package pnemonic.bug_bash.sound

import android.content.Context
import androidx.annotation.MainThread
import androidx.core.net.toUri
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import bug_bash.feedback.generated.resources.Res

actual object SoundManager {
    private val sounds = mutableMapOf<SoundType, ExoPlayer>()

    @MainThread
    fun initialize(context: Context): SoundManager {
        sounds[SoundType.BASH] = createPlayer(context, SoundType.BASH.fileName)
        return this
    }

    @MainThread
    private fun createPlayer(context: Context, name: String): ExoPlayer {
        val path = Res.getUri("files/sounds/$name")
        val uri = path.toUri()
        val mediaItem = MediaItem.fromUri(uri)
        val player = ExoPlayer.Builder(context).build()
        player.setMediaItem(mediaItem)
        player.prepare()
        return player
    }

    @MainThread
    actual suspend fun play(sound: SoundType) {
        val player = sounds[sound] ?: return
        player.seekTo(1L)
        player.play()
    }

    actual fun onDestroy() {
        for (player in sounds.values) {
            player.release()
        }
        sounds.clear()
    }
}
