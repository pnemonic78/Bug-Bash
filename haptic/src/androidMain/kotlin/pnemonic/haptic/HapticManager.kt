package pnemonic.haptic

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import androidx.annotation.IntRange
import kotlin.math.roundToInt

actual object HapticManager {
    private var vibrator: Vibrator? = null

    fun initialize(context: Context): HapticManager {
        vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val vibratorManager =
                context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
            vibratorManager.defaultVibrator
        } else {
            @Suppress("DEPRECATION")
            context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        }
        return this
    }

    actual fun vibrate(duration: Long, amplitude: Float) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            @IntRange(1, 255)
            val amplitudeInt: Int = 1 + (amplitude * 254).roundToInt()
            vibrator?.vibrate(VibrationEffect.createOneShot(duration, amplitudeInt))
        } else {
            @Suppress("DEPRECATION")
            vibrator?.vibrate(duration)
        }
    }
}