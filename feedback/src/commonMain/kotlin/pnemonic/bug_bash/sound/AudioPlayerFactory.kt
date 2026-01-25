package pnemonic.bug_bash.sound

expect object AudioPlayerFactory {
    fun create(soundType: SoundType): AudioPlayer?
}