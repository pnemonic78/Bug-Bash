package pnemonic.bug_bash.haptic

actual object HapticManager {
    actual fun vibrate(duration: Long, amplitude: Float) = Unit

    actual fun onDestroy() = Unit
}