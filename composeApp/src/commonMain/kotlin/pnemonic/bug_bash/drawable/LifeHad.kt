package pnemonic.bug_bash.drawable

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val LifeHad: ImageVector
    get() {
        if (_LifeHad != null) {
            return _LifeHad!!
        }
        _LifeHad = ImageVector.Builder(
            name = "LifeHad",
            defaultWidth = 8.2.dp,
            defaultHeight = 8.dp,
            viewportWidth = 8.2f,
            viewportHeight = 8f
        ).apply {
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color.White,
                        0.2672f to Color.Red,
                        0.7308f to Color(0xFF880000),
                        1f to Color(0xFF440000)
                    ),
                    start = Offset(1.1549f, 1.1559f),
                    end = Offset(7.0451f, 6.8441f)
                ),
                fillAlpha = 0.25f,
                stroke = SolidColor(Color.Red),
                strokeAlpha = 0.266667f,
                strokeLineWidth = 0.264583f
            ) {
                moveToRelative(5.8157f, 0.4035f)
                curveToRelative(0.3101f, 0f, 0.6006f, 0.0597f, 0.8716f, 0.1791f)
                curveToRelative(0.2733f, 0.1171f, 0.511f, 0.2779f, 0.7131f, 0.4823f)
                curveToRelative(0.2044f, 0.2021f, 0.3652f, 0.4398f, 0.4823f, 0.7131f)
                curveToRelative(0.1194f, 0.271f, 0.1791f, 0.5616f, 0.1791f, 0.8716f)
                curveToRelative(0f, 0.3009f, -0.0563f, 0.588f, -0.1688f, 0.8613f)
                curveTo(7.7805f, 3.782f, 7.6174f, 4.0243f, 7.4038f, 4.2379f)
                lineTo(4.1f, 7.5417f)
                lineTo(0.7961f, 4.2379f)
                curveTo(0.5826f, 4.0243f, 0.4195f, 3.782f, 0.3069f, 3.511f)
                curveTo(0.1944f, 3.2376f, 0.1381f, 2.9506f, 0.1381f, 2.6497f)
                curveToRelative(0f, -0.2067f, 0.0264f, -0.4054f, 0.0792f, -0.596f)
                curveTo(0.2725f, 1.8608f, 0.3483f, 1.6816f, 0.4447f, 1.5162f)
                curveTo(0.5412f, 1.3509f, 0.6583f, 1.1993f, 0.7961f, 1.0615f)
                curveTo(0.934f, 0.9237f, 1.0855f, 0.8066f, 1.2509f, 0.7101f)
                curveToRelative(0.1654f, -0.0965f, 0.3434f, -0.1711f, 0.534f, -0.2239f)
                curveToRelative(0.1929f, -0.0551f, 0.3927f, -0.0827f, 0.5994f, -0.0827f)
                curveToRelative(0.1791f, 0f, 0.3457f, 0.0184f, 0.4995f, 0.0551f)
                curveToRelative(0.1562f, 0.0345f, 0.3032f, 0.085f, 0.441f, 0.1516f)
                curveToRelative(0.1401f, 0.0666f, 0.2733f, 0.1493f, 0.3996f, 0.248f)
                curveTo(3.8531f, 0.9547f, 3.9783f, 1.0649f, 4.1f, 1.189f)
                curveTo(4.2217f, 1.0649f, 4.3458f, 0.9547f, 4.4721f, 0.8582f)
                curveTo(4.5984f, 0.7595f, 4.7316f, 0.6768f, 4.8717f, 0.6102f)
                curveTo(5.0118f, 0.5436f, 5.1588f, 0.4931f, 5.3127f, 0.4586f)
                curveTo(5.4689f, 0.4219f, 5.6365f, 0.4035f, 5.8157f, 0.4035f)
                close()
            }
        }.build()

        return _LifeHad!!
    }

@Suppress("ObjectPropertyName")
private var _LifeHad: ImageVector? = null
