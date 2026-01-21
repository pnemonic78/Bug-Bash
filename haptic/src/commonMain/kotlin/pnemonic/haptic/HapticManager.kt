package pnemonic.haptic

import androidx.annotation.FloatRange

expect object HapticManager {
    fun vibrate(duration: Long = 300, @FloatRange(from = 0.0, to = 1.0) amplitude: Float = 1f)
}