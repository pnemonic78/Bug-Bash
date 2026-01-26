package pnemonic.bug_bash.haptic

import kotlinx.browser.window

actual object HapticManager {
    actual fun vibrate(duration: Long, amplitude: Float) {
        window.navigator.vibrate(duration.toInt())
    }

    actual fun onDestroy() = Unit
}