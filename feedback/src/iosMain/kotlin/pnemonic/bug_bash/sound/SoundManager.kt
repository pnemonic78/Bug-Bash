package pnemonic.bug_bash.sound

actual object SoundManager {
    actual suspend fun play(sound: SoundType) {
        // TODO: Implement sound playback for iOS
    }

    actual fun onDestroy() = Unit
}
