package pnemonic.bug_bash.haptic

import androidx.annotation.FloatRange
import platform.CoreGraphics.CGFloat
import platform.UIKit.UIImpactFeedbackGenerator
import platform.UIKit.UIImpactFeedbackStyle

actual object HapticManager {
    private val feedback = UIImpactFeedbackGenerator(UIImpactFeedbackStyle.UIImpactFeedbackStyleLight)

    actual fun vibrate(duration: Long, @FloatRange(from = 0.0, to = 1.0) amplitude: Float) {
        val intensity: CGFloat = amplitude.toDouble()
        feedback.impactOccurredWithIntensity(intensity)
    }

    actual fun onDestroy() = Unit
}