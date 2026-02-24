package pnemonic.bug_bash.drawable

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import pnemonic.bug_bash.model.bug.Mosquito
import pnemonic.stateOf

private const val durationWing = 200

@Composable
fun mosquito(bug: Mosquito): ImageVector = mosquito(bug.isSquashed)

@Composable
fun mosquito(squashed: Boolean = false): ImageVector {
    val rotateL1: State<Float>
    val rotateR1: State<Float>

    if (squashed) {
        rotateL1 = stateOf(0f)
        rotateR1 = rotateL1
    } else {
        val transition = rememberInfiniteTransition()
        rotateL1 = transition.animateFloat(
            initialValue = 10f,
            targetValue = -10f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationWing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        rotateR1 = transition.animateFloat(
            initialValue = -10f,
            targetValue = 10f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationWing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
    }

    return ImageVector.Builder(
        name = "Mosquito",
        defaultWidth = 35.5.dp,
        defaultHeight = 23.dp,
        viewportWidth = 35.5f,
        viewportHeight = 23f
    ).apply {
        path(fill = SolidColor(Color(0xFFD53D33))) {
            moveToRelative(18.306f, 0.486f)
            curveToRelative(0f, 0.268f, -0.254f, 0.485f, -0.567f, 0.485f)
            curveToRelative(-0.313f, 0f, -0.567f, -0.217f, -0.567f, -0.485f)
            curveToRelative(0f, -0.268f, 0.254f, -0.486f, 0.567f, -0.486f)
            curveToRelative(0.313f, 0f, 0.567f, 0.217f, 0.567f, 0.486f)
            close()
        }
        path(fill = SolidColor(Color(0xFF808080))) {
            moveToRelative(12.385f, 22.565f)
            curveToRelative(-0.04f, 0f, -0.081f, -0.009f, -0.12f, -0.027f)
            curveToRelative(-0.138f, -0.066f, -0.196f, -0.232f, -0.13f, -0.37f)
            lineTo(15.494f, 15.19f)
            lineTo(14.817f, 11.483f)
            curveToRelative(-0.017f, -0.092f, 0.014f, -0.186f, 0.081f, -0.251f)
            lineToRelative(2.219f, -2.115f)
            curveToRelative(0.111f, -0.105f, 0.286f, -0.102f, 0.392f, 0.009f)
            curveToRelative(0.105f, 0.111f, 0.101f, 0.286f, -0.009f, 0.392f)
            lineToRelative(-2.11f, 2.012f)
            lineToRelative(0.667f, 3.649f)
            curveToRelative(0.01f, 0.058f, 0.002f, 0.117f, -0.023f, 0.17f)
            lineToRelative(-3.398f, 7.059f)
            curveToRelative(-0.048f, 0.099f, -0.147f, 0.157f, -0.251f, 0.157f)
            close()
        }
        path(fill = SolidColor(Color(0xFF808080))) {
            moveToRelative(9.544f, 17.462f)
            curveToRelative(-0.064f, 0f, -0.128f, -0.022f, -0.181f, -0.067f)
            curveTo(9.248f, 17.295f, 9.234f, 17.12f, 9.334f, 17.004f)
            lineToRelative(3.487f, -4.063f)
            lineToRelative(1.3f, -3.009f)
            curveToRelative(0.03f, -0.07f, 0.088f, -0.124f, 0.16f, -0.151f)
            lineToRelative(2.881f, -1.048f)
            curveToRelative(0.143f, -0.053f, 0.303f, 0.022f, 0.355f, 0.166f)
            curveToRelative(0.053f, 0.144f, -0.022f, 0.303f, -0.166f, 0.356f)
            lineToRelative(-2.768f, 1.007f)
            lineToRelative(-1.269f, 2.938f)
            curveToRelative(-0.011f, 0.026f, -0.026f, 0.049f, -0.044f, 0.07f)
            lineToRelative(-3.515f, 4.095f)
            curveToRelative(-0.055f, 0.064f, -0.132f, 0.097f, -0.211f, 0.097f)
            close()
        }
        path(fill = SolidColor(Color(0xFF808080))) {
            moveToRelative(17.022f, 7.775f)
            curveToRelative(-0.046f, 0f, -0.092f, -0.014f, -0.131f, -0.043f)
            lineTo(15.003f, 6.344f)
            curveTo(14.946f, 6.302f, 14.912f, 6.236f, 14.912f, 6.165f)
            lineToRelative(0f, -2.059f)
            lineToRelative(-1.567f, -2.133f)
            curveToRelative(-0.073f, -0.099f, -0.051f, -0.238f, 0.047f, -0.31f)
            curveToRelative(0.099f, -0.073f, 0.238f, -0.051f, 0.31f, 0.047f)
            lineToRelative(1.61f, 2.192f)
            curveToRelative(0.028f, 0.038f, 0.043f, 0.084f, 0.043f, 0.131f)
            lineToRelative(0f, 2.02f)
            lineToRelative(1.797f, 1.322f)
            curveToRelative(0.099f, 0.073f, 0.12f, 0.212f, 0.047f, 0.31f)
            curveToRelative(-0.043f, 0.059f, -0.111f, 0.09f, -0.179f, 0.09f)
            close()
        }
        path(fill = SolidColor(Color(0xFF505050))) {
            moveToRelative(16.987f, 6.245f)
            lineToRelative(0f, 1.975f)
            curveToRelative(0f, 0.418f, 0.336f, 0.756f, 0.752f, 0.761f)
            lineToRelative(0f, -3.497f)
            curveToRelative(-0.416f, 0.005f, -0.752f, 0.344f, -0.752f, 0.761f)
            close()
        }
        path(fill = SolidColor(Color(0xFF606060))) {
            moveToRelative(17.739f, 4.462f)
            lineToRelative(-0.504f, 0f)
            curveToRelative(-0.348f, 0f, -0.63f, 0.282f, -0.63f, 0.63f)
            curveToRelative(0f, 0.348f, 0.282f, 0.63f, 0.63f, 0.63f)
            lineToRelative(0.504f, 0f)
            close()
        }
        path(fill = SolidColor(Color(0xFF808080))) {
            moveToRelative(23.094f, 22.565f)
            curveToRelative(0.04f, 0f, 0.081f, -0.009f, 0.12f, -0.027f)
            curveToRelative(0.138f, -0.066f, 0.196f, -0.232f, 0.13f, -0.37f)
            lineTo(19.985f, 15.19f)
            lineTo(20.662f, 11.483f)
            curveToRelative(0.017f, -0.092f, -0.014f, -0.186f, -0.081f, -0.251f)
            lineToRelative(-2.219f, -2.115f)
            curveToRelative(-0.111f, -0.105f, -0.286f, -0.102f, -0.392f, 0.009f)
            curveToRelative(-0.105f, 0.111f, -0.101f, 0.286f, 0.009f, 0.392f)
            lineToRelative(2.11f, 2.012f)
            lineToRelative(-0.667f, 3.648f)
            curveToRelative(-0.01f, 0.058f, -0.002f, 0.117f, 0.023f, 0.17f)
            lineToRelative(3.398f, 7.059f)
            curveToRelative(0.048f, 0.099f, 0.147f, 0.157f, 0.25f, 0.157f)
            close()
        }
        path(fill = SolidColor(Color(0xFF808080))) {
            moveToRelative(25.934f, 17.462f)
            curveToRelative(0.064f, 0f, 0.128f, -0.022f, 0.181f, -0.067f)
            curveToRelative(0.116f, -0.1f, 0.13f, -0.275f, 0.03f, -0.391f)
            lineTo(22.657f, 12.94f)
            lineTo(21.357f, 9.931f)
            curveTo(21.327f, 9.861f, 21.269f, 9.807f, 21.198f, 9.78f)
            lineTo(18.317f, 8.733f)
            curveToRelative(-0.143f, -0.053f, -0.303f, 0.022f, -0.355f, 0.166f)
            curveToRelative(-0.053f, 0.144f, 0.022f, 0.303f, 0.166f, 0.356f)
            lineToRelative(2.768f, 1.007f)
            lineToRelative(1.269f, 2.938f)
            curveToRelative(0.011f, 0.026f, 0.026f, 0.049f, 0.044f, 0.07f)
            lineToRelative(3.515f, 4.095f)
            curveToRelative(0.055f, 0.064f, 0.132f, 0.097f, 0.211f, 0.097f)
            close()
        }
        path(fill = SolidColor(Color(0xFF808080))) {
            moveToRelative(18.457f, 7.775f)
            curveToRelative(0.046f, 0f, 0.092f, -0.014f, 0.131f, -0.043f)
            lineTo(20.476f, 6.344f)
            curveToRelative(0.057f, -0.042f, 0.09f, -0.108f, 0.09f, -0.179f)
            lineToRelative(0f, -2.059f)
            lineToRelative(1.567f, -2.133f)
            curveToRelative(0.073f, -0.099f, 0.051f, -0.238f, -0.047f, -0.31f)
            curveToRelative(-0.099f, -0.073f, -0.238f, -0.051f, -0.31f, 0.047f)
            lineToRelative(-1.61f, 2.192f)
            curveToRelative(-0.028f, 0.038f, -0.043f, 0.084f, -0.043f, 0.131f)
            lineToRelative(0f, 2.02f)
            lineToRelative(-1.797f, 1.322f)
            curveToRelative(-0.099f, 0.073f, -0.12f, 0.212f, -0.047f, 0.31f)
            curveToRelative(0.044f, 0.059f, 0.111f, 0.09f, 0.179f, 0.09f)
            close()
        }
        path(fill = SolidColor(Color(0xFF505050))) {
            moveToRelative(17.739f, 5.484f)
            curveToRelative(0.416f, 0.005f, 0.752f, 0.344f, 0.752f, 0.761f)
            lineToRelative(0f, 1.975f)
            curveToRelative(0f, 0.418f, -0.336f, 0.756f, -0.752f, 0.761f)
            close()
        }
        path(fill = SolidColor(Color(0xFF505050))) {
            moveToRelative(17.739f, 5.484f)
            curveToRelative(-0.416f, 0.005f, -0.752f, 0.344f, -0.752f, 0.761f)
            lineToRelative(0f, 1.975f)
            curveToRelative(0f, 0.418f, 0.336f, 0.756f, 0.752f, 0.761f)
            curveToRelative(0.416f, -0.005f, 0.752f, -0.344f, 0.752f, -0.761f)
            lineTo(18.492f, 6.245f)
            curveToRelative(0f, -0.417f, -0.336f, -0.756f, -0.752f, -0.761f)
            close()
        }
        path(fill = SolidColor(Color(0xFF303030))) {
            moveToRelative(17.739f, 0.439f)
            curveToRelative(-0.148f, 0.006f, -0.267f, 0.126f, -0.267f, 0.275f)
            curveToRelative(0f, 0f, 0.119f, 3.62f, 0.267f, 3.784f)
            curveToRelative(0.148f, -0.163f, 0.267f, -3.784f, 0.267f, -3.784f)
            curveToRelative(0f, -0.15f, -0.119f, -0.269f, -0.267f, -0.275f)
            close()
        }
        path(fill = SolidColor(Color(0xFF606060))) {
            moveToRelative(17.739f, 8.733f)
            curveToRelative(-0.267f, 0.005f, -0.483f, 0.223f, -0.483f, 0.493f)
            lineToRelative(0f, 3.978f)
            curveToRelative(0f, 0.269f, 0.216f, 0.487f, 0.483f, 0.492f)
            curveToRelative(0.267f, -0.005f, 0.483f, -0.223f, 0.483f, -0.492f)
            lineTo(18.223f, 9.225f)
            curveToRelative(0f, -0.269f, -0.216f, -0.487f, -0.483f, -0.493f)
            close()
        }
        group("wing-r", rotate = rotateR1.value, pivotX = 17.739f, 8.113f) {
            path(fill = SolidColor(Color(0xCCD5E5E6))) {
                moveToRelative(17.739f, 8.113f)
                curveToRelative(0.212f, -1.023f, 3.944f, -1.837f, 8.518f, -1.837f)
                curveToRelative(4.71f, 0f, 9.222f, -0.476f, 9.222f, 0.59f)
                curveToRelative(0f, 1.066f, -4.512f, 3.269f, -9.222f, 3.269f)
                curveToRelative(-4.573f, 0f, -8.306f, -0.815f, -8.518f, -1.838f)
                close()
            }
        }
        path(fill = SolidColor(Color(0xFF606060))) {
            moveToRelative(17.739f, 4.462f)
            lineToRelative(0.504f, 0f)
            curveToRelative(0.348f, 0f, 0.63f, 0.282f, 0.63f, 0.63f)
            curveToRelative(0f, 0.348f, -0.282f, 0.63f, -0.63f, 0.63f)
            lineToRelative(-0.504f, 0f)
            close()
        }
        path(fill = SolidColor(Color(0xFF606060))) {
            moveToRelative(18.243f, 4.462f)
            lineToRelative(-0.504f, 0f)
            lineToRelative(-0.504f, 0f)
            curveToRelative(-0.348f, 0f, -0.63f, 0.282f, -0.63f, 0.63f)
            curveToRelative(0f, 0.348f, 0.282f, 0.63f, 0.63f, 0.63f)
            lineToRelative(0.504f, 0f)
            lineToRelative(0.504f, 0f)
            curveToRelative(0.348f, 0f, 0.63f, -0.282f, 0.63f, -0.63f)
            curveToRelative(0f, -0.348f, -0.282f, -0.63f, -0.63f, -0.63f)
            close()
        }
        path(fill = SolidColor(Color(0xFFE0E0E0))) {
            moveToRelative(17.965f, 4.812f)
            curveToRelative(0f, 0.291f, 0.236f, 0.527f, 0.527f, 0.527f)
            curveToRelative(0.291f, 0f, 0.527f, -0.236f, 0.527f, -0.527f)
            curveToRelative(0f, -0.291f, -0.236f, -0.527f, -0.527f, -0.527f)
            curveToRelative(-0.291f, -0f, -0.527f, 0.236f, -0.527f, 0.527f)
            close()
        }
        path(fill = SolidColor(Color(0xFFE0E0E0))) {
            moveToRelative(17.515f, 4.812f)
            curveToRelative(0f, 0.291f, -0.236f, 0.527f, -0.527f, 0.527f)
            curveToRelative(-0.291f, 0f, -0.527f, -0.236f, -0.527f, -0.527f)
            curveToRelative(0f, -0.291f, 0.236f, -0.527f, 0.527f, -0.527f)
            curveToRelative(0.291f, -0f, 0.527f, 0.236f, 0.527f, 0.527f)
            close()
        }
        group("wing-l", rotate = rotateL1.value, pivotX = 17.739f, 8.113f) {
            path(fill = SolidColor(Color(0xCCD5E5E6))) {
                moveToRelative(17.739f, 8.113f)
                curveToRelative(-0.212f, -1.023f, -3.944f, -1.837f, -8.518f, -1.837f)
                curveToRelative(-4.71f, 0f, -9.222f, -0.476f, -9.222f, 0.59f)
                curveToRelative(0f, 1.066f, 4.512f, 3.269f, 9.222f, 3.269f)
                curveToRelative(4.573f, 0f, 8.306f, -0.815f, 8.518f, -1.838f)
                close()
            }
        }
    }.build()
}
