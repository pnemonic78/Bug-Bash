package pnemonic.bug_bash.haptic

import androidx.annotation.FloatRange
import kotlinx.browser.window

actual object HapticManager {
    actual fun vibrate(duration: Long, @FloatRange(from = 0.0, to = 1.0) amplitude: Float) {
        window.navigator.vibrate(duration.toInt())
    }

    actual fun onDestroy() = Unit
}