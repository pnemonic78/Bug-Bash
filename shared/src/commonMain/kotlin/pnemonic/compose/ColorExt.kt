package pnemonic.compose

import androidx.compose.ui.graphics.Color
import kotlin.math.max
import kotlin.math.min

fun Color.toHsl(): FloatArray {
    val r = red
    val g = green
    val b = blue

    val max = max(r, max(g, b))
    val min = min(r, min(g, b))

    val h: Float
    val s: Float
    val l = (max + min) / 2

    if (max == min) {
        // achromatic
        h = 0f
        s = 0f
    } else {
        val d = max - min
        s = if (l > 0.5f) d / (2 - max - min) else d / (max + min)
        h = when (max) {
            r -> (g - b) / d + (if (g < b) 6 else 0)
            g -> (b - r) / d + 2
            b -> (r - g) / d + 4
            else -> 0f
        }
    }

    return floatArrayOf(h * 60, s, l)
}

fun Color.lighten(factor: Float = 0.1f): Color {
    val hsl = toHsl()
    // Increase 'Value' (index 2) to make it brighter, capped at 1.0
    hsl[2] = (hsl[2] + factor).coerceIn(0f, 1f)
    return Color.hsl(hsl[0], hsl[1], hsl[2], alpha)
}
