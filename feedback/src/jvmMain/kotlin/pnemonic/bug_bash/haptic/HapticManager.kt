package pnemonic.bug_bash.haptic

import androidx.annotation.FloatRange

actual object HapticManager {
    actual fun vibrate(duration: Long, @FloatRange(from = 0.0, to = 1.0) amplitude: Float) = Unit

    actual fun onDestroy() = Unit
}