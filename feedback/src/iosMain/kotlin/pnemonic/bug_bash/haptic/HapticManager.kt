package pnemonic.bug_bash.haptic

import platform.CoreGraphics.CGFloat
import platform.UIKit.UIImpactFeedbackGenerator
import platform.UIKit.UIImpactFeedbackStyle

actual object HapticManager {
    private val feedback = UIImpactFeedbackGenerator(UIImpactFeedbackStyle.UIImpactFeedbackStyleLight)

    actual fun vibrate(duration: Long, amplitude: Float) {
        val intensity: CGFloat = amplitude.toDouble()
        feedback.impactOccurredWithIntensity(intensity)
    }

    actual fun onDestroy() = Unit
}