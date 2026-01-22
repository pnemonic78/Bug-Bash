package pnemonic.bug_bash.sound

expect object SoundManager {
    suspend fun play(sound: SoundType)
    fun onDestroy()
}
