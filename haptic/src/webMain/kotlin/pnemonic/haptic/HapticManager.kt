package pnemonic.haptic

import kotlinx.browser.window

actual object HapticManager {
    actual fun vibrate(duration: Long, amplitude: Float) {
        if (window.navigator.vibrate != undefined) {
            window.navigator.vibrate(duration)
        }
    }
}