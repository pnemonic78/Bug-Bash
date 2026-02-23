package pnemonic.bug_bash.sound

object SoundManager {
    private val sounds = mutableMapOf<SoundType, AudioPlayer>()
    private val playing = mutableMapOf<SoundType, Boolean>()

    fun play(sound: SoundType) {
        var player = sounds[sound]
        if (player == null) {
            player = AudioPlayerFactory.create(sound) ?: return
            player.prepare()
            sounds[sound] = player
        }
        player.play()
        if (sound.repeat) {
            playing[sound] = true
        }
    }

    fun pause(sound: SoundType) {
        val player = sounds[sound] ?: return
        player.pause()
    }

    fun stop(sound: SoundType) {
        val player = sounds[sound] ?: return
        player.stop()
        playing[sound] = false
    }

    fun onStart() {
        for (sound in sounds.keys) {
            if (playing[sound] == true) {
                val player = sounds[sound] ?: continue
                player.play()
            }
        }
    }

    fun onStop() {
        for (player in sounds.values) {
            player.pause()
        }
    }

    fun onDestroy() {
        for (player in sounds.values) {
            player.stop()
            player.release()
        }
        sounds.clear()
        playing.clear()
    }
}
