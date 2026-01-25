package pnemonic.bug_bash.sound

expect class AudioPlayer {
    val soundType: SoundType
    fun prepare()
    fun play()
    fun pause()
    fun stop()
    fun release()
}