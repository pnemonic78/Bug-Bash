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
import pnemonic.bug_bash.model.Bonus
import pnemonic.stateOf

private const val durationPump = 1000

@Composable
fun insecticide(bonus: Bonus): ImageVector = insecticide(bonus.isActive)

@Composable
fun insecticide(active: Boolean = false): ImageVector {
    val rotate1: State<Float>

    if (active) {
        val transition = rememberInfiniteTransition()
        rotate1 = transition.animateFloat(
            initialValue = 0f,
            targetValue = 15f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationPump
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
    } else {
        rotate1 = stateOf(0f)
    }

    return ImageVector.Builder(
        name = "Insecticide",
        defaultWidth = 10.235.dp,
        defaultHeight = 26.672.dp,
        viewportWidth = 10.235f,
        viewportHeight = 26.672f
    ).apply {
        path(fill = SolidColor(Color(0xFFFBCC02))) {
            moveTo(8.621f, 2.334f)
            lineToRelative(-2.313f, 0.422f)
            lineToRelative(-0.156f, -1.887f)
            lineToRelative(2.469f, 0.356f)
            close()
        }
        path(fill = SolidColor(Color(0xFFFBCC02))) {
            moveTo(4.097f, 2.621f)
            lineToRelative(-1.166f, 0f)
            lineToRelative(-0f, 2.671f)
            lineToRelative(1.166f, 0f)
            close()
        }
        path(fill = SolidColor(Color(0xFFFBCC02))) {
            moveToRelative(0.038f, 24.776f)
            curveToRelative(-0f, -0.902f, -0.086f, -8.615f, -0f, -11.045f)
            curveToRelative(0.06f, -1.693f, 1.135f, -3.722f, 1.782f, -4.799f)
            lineToRelative(0.916f, 0f)
            lineToRelative(1.556f, 0f)
            lineToRelative(0.916f, 0f)
            curveToRelative(0.647f, 1.077f, 1.722f, 3.106f, 1.782f, 4.799f)
            curveToRelative(0.086f, 2.431f, -0f, 10.143f, -0f, 11.045f)
            curveToRelative(-0f, 0.108f, -0.008f, 0.217f, -0.025f, 0.327f)
            lineToRelative(-6.903f, 0f)
            curveToRelative(-0.016f, -0.109f, -0.024f, -0.218f, -0.024f, -0.327f)
            close()
        }
        path(fill = SolidColor(Color(0xFFFF4800))) {
            moveToRelative(5.045f, 26.672f)
            curveToRelative(-0.271f, 0f, -0.523f, 0f, -0.754f, 0f)
            curveToRelative(-0.964f, 0f, -1.556f, 0f, -1.556f, 0f)
            curveToRelative(-0.231f, 0f, -0.483f, 0f, -0.754f, 0f)
            curveToRelative(-1.232f, 0f, -1.801f, -0.77f, -1.92f, -1.569f)
            lineToRelative(6.903f, 0f)
            curveToRelative(-0.119f, 0.799f, -0.688f, 1.569f, -1.92f, 1.569f)
            close()
        }
        path(fill = SolidColor(Color(0xFFF9AE06))) {
            moveTo(4.68f, 5.086f)
            lineToRelative(-2.333f, 0f)
            lineToRelative(-0f, 1.464f)
            lineToRelative(2.333f, 0f)
            close()
        }
        path(fill = SolidColor(Color(0xFFF9AE06))) {
            moveTo(5.194f, 6.397f)
            lineToRelative(-3.36f, 0f)
            lineToRelative(-0f, 2.536f)
            lineToRelative(3.36f, 0f)
            close()
        }
        group("pump", rotate = rotate1.value, pivotX = 2.381f, pivotY = 6.397f) {
            path(fill = SolidColor(Color(0xFFF9AE06))) {
                moveToRelative(0.719f, 1.627f)
                curveToRelative(0.624f, -0.988f, 1.697f, -1.842f, 3.948f, -1.58f)
                curveToRelative(2.251f, 0.262f, 2.508f, 2.727f, 3.172f, 4.551f)
                curveToRelative(0.663f, 1.824f, 1.379f, 2.185f, 2.037f, 2.766f)
                curveToRelative(0.173f, 0.153f, 0.291f, 0.511f, 0.337f, 0.673f)
                curveToRelative(-0.445f, -0.136f, -1.287f, -0.445f, -1.873f, -0.967f)
                curveToRelative(-0.83f, -0.74f, -1.615f, -2.445f, -2.187f, -3.499f)
                curveToRelative(-0.572f, -1.054f, -1.425f, -2.244f, -3.129f, -1.683f)
                curveToRelative(-1.705f, 0.561f, -1.839f, 1.526f, -1.346f, 2.715f)
                curveToRelative(0.207f, 0.499f, 0.461f, 0.875f, 0.686f, 1.144f)
                lineToRelative(0.016f, 0.65f)
                lineToRelative(-0.546f, 0f)
                curveToRelative(-0f, 0f, -0.602f, -0.334f, -1.198f, -1.798f)
                curveToRelative(-0.309f, -0.757f, -0.425f, -2.169f, 0.082f, -2.972f)
                close()
            }
            path(fill = SolidColor(Color(0xFFF78F08))) {
                moveToRelative(3.024f, 1.889f)
                curveToRelative(1.705f, -0.561f, 2.557f, 0.629f, 3.129f, 1.683f)
                curveToRelative(0.572f, 1.054f, 1.357f, 2.759f, 2.187f, 3.499f)
                curveToRelative(0.586f, 0.523f, 1.428f, 0.831f, 1.873f, 0.967f)
                curveToRelative(0.015f, 0.05f, 0.022f, 0.083f, 0.022f, 0.083f)
                curveToRelative(-0f, 0f, -1.107f, 0.074f, -2.406f, -1.023f)
                curveToRelative(-1.3f, -1.097f, -1.891f, -3.713f, -2.833f, -4.214f)
                curveToRelative(-1.04f, -0.553f, -2.472f, -0.204f, -2.837f, 0.415f)
                curveToRelative(-0.451f, 0.767f, 0.189f, 1.787f, 0.189f, 1.787f)
                lineToRelative(0.016f, 0.661f)
                curveToRelative(-0.225f, -0.269f, -0.479f, -0.644f, -0.686f, -1.144f)
                curveToRelative(-0.493f, -1.189f, -0.359f, -2.154f, 1.346f, -2.715f)
                close()
            }
        }
        path(fill = SolidColor(Color.White)) {
            moveTo(6.366f, 14.439f)
            lineToRelative(-5.832f, 0f)
            lineToRelative(-0f, 8.15f)
            lineToRelative(5.832f, 0f)
            close()
        }
        path(fill = SolidColor(Color(0xFFF9AE06))) {
            moveToRelative(3.856f, 16.322f)
            lineToRelative(1.805f, 2.678f)
            curveToRelative(0.202f, 0.3f, -0.013f, 0.705f, -0.375f, 0.705f)
            lineToRelative(-1.805f, 0f)
            lineToRelative(-1.805f, 0f)
            curveToRelative(-0.362f, 0f, -0.577f, -0.405f, -0.375f, -0.705f)
            lineToRelative(1.805f, -2.678f)
            curveToRelative(0.179f, -0.266f, 0.571f, -0.266f, 0.75f, 0f)
            close()
        }
        path(fill = SolidColor(Color(0xFF873217))) {
            moveToRelative(1.056f, 18.583f)
            curveToRelative(0.132f, -0.217f, 0.454f, -0.316f, 0.691f, -0.388f)
            curveToRelative(0.242f, -0.073f, 0.481f, -0.156f, 0.719f, -0.243f)
            curveToRelative(0.186f, -0.068f, 0.371f, -0.134f, 0.545f, -0.225f)
            curveToRelative(0.003f, -0.003f, 0.006f, -0.006f, 0.008f, -0.009f)
            curveToRelative(-0.005f, -0.041f, -0.007f, -0.08f, -0.006f, -0.116f)
            curveToRelative(-0.037f, -0.033f, -0.088f, -0.076f, -0.139f, -0.115f)
            curveToRelative(-0.103f, -0.079f, -0.322f, -0.319f, -0.413f, -0.456f)
            curveToRelative(-0.06f, -0.09f, -0.064f, -0.143f, -0.057f, -0.171f)
            curveToRelative(-0.079f, -0.128f, -0.011f, -0.182f, -0.2f, -0.415f)
            curveToRelative(-0.05f, -0.061f, -0.062f, -0.1f, -0.062f, -0.124f)
            curveToRelative(-0.094f, -0.07f, -0.316f, -0.198f, -0.472f, -0.292f)
            curveToRelative(-0.173f, -0.103f, -0.543f, -0.298f, -0.656f, -0.446f)
            curveToRelative(-0.084f, -0.109f, -0.003f, -0.098f, 0.148f, 0.026f)
            curveToRelative(0.114f, 0.094f, 0.507f, 0.333f, 0.745f, 0.454f)
            curveToRelative(0.132f, 0.067f, 0.212f, 0.166f, 0.245f, 0.228f)
            curveToRelative(0f, -0f, 0.001f, -0.001f, 0.001f, -0.001f)
            curveToRelative(-0f, 0f, 0.079f, 0.071f, 0.183f, 0.214f)
            curveToRelative(0.075f, 0.102f, 0.085f, 0.251f, 0.085f, 0.329f)
            curveToRelative(0.007f, 0.012f, 0.121f, 0.215f, 0.416f, 0.505f)
            curveToRelative(0.087f, 0.086f, 0.143f, 0.16f, 0.18f, 0.215f)
            curveToRelative(0.006f, -0.041f, 0.017f, -0.072f, 0.033f, -0.087f)
            curveToRelative(0.008f, -0.007f, 0.016f, -0.013f, 0.024f, -0.02f)
            curveToRelative(0.059f, -0.047f, 0.126f, -0.074f, 0.189f, -0.09f)
            curveToRelative(-0.031f, -0.016f, -0.058f, -0.037f, -0.082f, -0.062f)
            lineToRelative(-0f, 0.001f)
            curveToRelative(-0f, 0f, -0.183f, -0.093f, -0.17f, -0.257f)
            curveToRelative(0.013f, -0.164f, 0.224f, -0.185f, 0.224f, -0.185f)
            lineToRelative(-0f, 0f)
            curveToRelative(0.011f, -0.007f, 0.023f, -0.013f, 0.035f, -0.019f)
            curveToRelative(-0.058f, -0.107f, -0.189f, -0.339f, -0.33f, -0.517f)
            curveToRelative(-0.176f, -0.222f, -0.202f, -0.29f, -0.051f, -0.19f)
            curveToRelative(0.111f, 0.073f, 0.327f, 0.436f, 0.397f, 0.7f)
            curveToRelative(0.018f, -0.007f, 0.038f, -0.013f, 0.057f, -0.017f)
            lineToRelative(0.032f, -1.449f)
            lineToRelative(0.074f, 1.449f)
            curveToRelative(0.02f, 0.004f, 0.038f, 0.009f, 0.056f, 0.016f)
            curveToRelative(0.07f, -0.264f, 0.286f, -0.626f, 0.397f, -0.699f)
            curveToRelative(0.151f, -0.1f, 0.125f, -0.031f, -0.051f, 0.19f)
            curveToRelative(-0.141f, 0.177f, -0.271f, 0.409f, -0.329f, 0.516f)
            curveToRelative(0.013f, 0.006f, 0.026f, 0.012f, 0.037f, 0.02f)
            curveToRelative(0.026f, 0.003f, 0.207f, 0.033f, 0.219f, 0.184f)
            curveToRelative(0.013f, 0.164f, -0.161f, 0.252f, -0.161f, 0.252f)
            lineToRelative(-0f, -0.002f)
            curveToRelative(-0.023f, 0.027f, -0.051f, 0.049f, -0.083f, 0.066f)
            curveToRelative(0.042f, 0.011f, 0.086f, 0.027f, 0.13f, 0.052f)
            curveToRelative(0.028f, 0.016f, 0.055f, 0.035f, 0.08f, 0.059f)
            curveToRelative(0.019f, 0.017f, 0.03f, 0.058f, 0.035f, 0.11f)
            curveToRelative(0.035f, -0.057f, 0.094f, -0.14f, 0.195f, -0.239f)
            curveToRelative(0.296f, -0.29f, 0.41f, -0.493f, 0.416f, -0.505f)
            curveToRelative(0f, -0.078f, 0.011f, -0.227f, 0.085f, -0.329f)
            curveToRelative(0.104f, -0.143f, 0.183f, -0.214f, 0.183f, -0.214f)
            curveToRelative(-0f, 0f, 0.001f, 0.001f, 0.001f, 0.001f)
            curveToRelative(0.033f, -0.062f, 0.113f, -0.161f, 0.245f, -0.228f)
            curveToRelative(0.238f, -0.121f, 0.631f, -0.36f, 0.745f, -0.454f)
            curveToRelative(0.151f, -0.124f, 0.231f, -0.135f, 0.148f, -0.026f)
            curveToRelative(-0.113f, 0.147f, -0.484f, 0.343f, -0.656f, 0.446f)
            curveToRelative(-0.157f, 0.093f, -0.378f, 0.222f, -0.472f, 0.292f)
            curveToRelative(-0f, 0.024f, -0.012f, 0.062f, -0.062f, 0.124f)
            curveToRelative(-0.189f, 0.233f, -0.121f, 0.287f, -0.2f, 0.415f)
            curveToRelative(0.007f, 0.029f, 0.003f, 0.081f, -0.057f, 0.171f)
            curveToRelative(-0.09f, 0.137f, -0.31f, 0.377f, -0.413f, 0.456f)
            curveToRelative(-0.061f, 0.047f, -0.119f, 0.097f, -0.157f, 0.131f)
            curveToRelative(0.001f, 0.033f, -0.002f, 0.069f, -0.007f, 0.107f)
            curveToRelative(0.175f, 0.093f, 0.363f, 0.159f, 0.551f, 0.228f)
            curveToRelative(0.238f, 0.087f, 0.476f, 0.17f, 0.719f, 0.243f)
            curveToRelative(0.237f, 0.071f, 0.559f, 0.17f, 0.691f, 0.388f)
            curveToRelative(0.018f, 0.029f, 0.032f, 0.065f, 0.039f, 0.102f)
            curveToRelative(0.002f, 0.009f, 0.004f, 0.018f, 0.004f, 0.027f)
            curveToRelative(-0f, 0.001f, -0f, 0.001f, -0f, 0.002f)
            curveToRelative(0.001f, 0.017f, -0f, 0.035f, -0.005f, 0.051f)
            curveToRelative(-0.004f, 0.015f, -0.01f, 0.027f, -0.015f, 0.038f)
            curveToRelative(-0.003f, 0.006f, -0.007f, 0.011f, -0.01f, 0.017f)
            curveToRelative(-0.001f, 0.002f, -0.003f, 0.004f, -0.004f, 0.006f)
            curveToRelative(-0.133f, 0.191f, -0.638f, 0.187f, -1.143f, -0.076f)
            curveToRelative(-0.112f, -0.058f, -0.215f, -0.125f, -0.31f, -0.196f)
            curveToRelative(0.02f, 0.042f, 0.045f, 0.099f, 0.073f, 0.171f)
            curveToRelative(0.059f, 0.153f, 0.256f, 0.545f, 0.32f, 0.672f)
            curveToRelative(0.072f, 0.078f, 0.131f, 0.123f, 0.168f, 0.351f)
            curveToRelative(0.04f, 0.246f, 0.12f, 0.768f, 0.085f, 0.907f)
            curveToRelative(-0.034f, 0.135f, -0.074f, 0.185f, -0.079f, 0.119f)
            curveToRelative(-0.006f, -0.082f, 0.01f, -0.219f, 0.003f, -0.343f)
            curveToRelative(-0.019f, -0.335f, -0.034f, -0.434f, -0.087f, -0.647f)
            curveToRelative(-0.042f, -0.171f, -0.073f, -0.285f, -0.09f, -0.347f)
            curveToRelative(-0.023f, -0.009f, -0.067f, -0.043f, -0.143f, -0.16f)
            curveToRelative(-0.092f, -0.142f, -0.185f, -0.394f, -0.229f, -0.503f)
            curveToRelative(-0.054f, -0.134f, -0.07f, -0.213f, -0.074f, -0.26f)
            curveToRelative(-0.188f, -0.149f, -0.339f, -0.318f, -0.448f, -0.483f)
            curveToRelative(-0.026f, -0.039f, -0.049f, -0.078f, -0.07f, -0.116f)
            curveToRelative(-0.001f, 0.001f, -0.001f, 0.003f, -0.002f, 0.004f)
            curveToRelative(0.099f, 0.167f, 0.293f, 0.498f, 0.35f, 0.631f)
            curveToRelative(0.039f, 0.092f, 0.034f, 0.178f, 0.025f, 0.229f)
            curveToRelative(0.007f, 0.048f, 0.017f, 0.126f, 0.022f, 0.238f)
            curveToRelative(0.008f, 0.167f, 0.074f, 0.62f, 0.093f, 0.749f)
            curveToRelative(0.057f, 0.061f, 0.104f, 0.123f, 0.135f, 0.316f)
            curveToRelative(0.04f, 0.246f, -0.015f, 1.397f, -0.05f, 1.536f)
            curveToRelative(-0.034f, 0.135f, -0.074f, 0.185f, -0.079f, 0.119f)
            curveToRelative(-0.006f, -0.082f, 0.01f, -0.219f, 0.003f, -0.343f)
            curveToRelative(-0.019f, -0.335f, 0.1f, -1.062f, 0.047f, -1.275f)
            curveToRelative(-0.042f, -0.17f, -0.072f, -0.283f, -0.089f, -0.346f)
            curveToRelative(-0.018f, -0.027f, -0.041f, -0.077f, -0.066f, -0.175f)
            curveToRelative(-0.042f, -0.164f, -0.051f, -0.432f, -0.058f, -0.549f)
            curveToRelative(-0.009f, -0.152f, 0.002f, -0.234f, 0.014f, -0.277f)
            curveToRelative(-0.018f, -0.056f, -0.055f, -0.151f, -0.126f, -0.282f)
            curveToRelative(-0.087f, -0.161f, -0.216f, -0.362f, -0.272f, -0.488f)
            curveToRelative(-0.038f, 0.046f, -0.087f, 0.077f, -0.148f, 0.081f)
            curveToRelative(-0.015f, 0.001f, -0.041f, 0.002f, -0.07f, 0.002f)
            curveToRelative(0.071f, 0.004f, 0.173f, 0.024f, 0.216f, 0.101f)
            curveToRelative(0.028f, 0.05f, 0.064f, 0.148f, 0.09f, 0.284f)
            curveToRelative(0.001f, 0.001f, 0.002f, 0.004f, 0.002f, 0.004f)
            lineToRelative(-0.001f, -0.001f)
            curveToRelative(0.016f, 0.083f, 0.028f, 0.18f, 0.032f, 0.291f)
            curveToRelative(0f, 0.001f, 0.001f, 0.003f, 0.001f, 0.003f)
            lineToRelative(-0.001f, -0.001f)
            curveToRelative(0.004f, 0.099f, 0.003f, 0.207f, -0.008f, 0.326f)
            lineToRelative(0.001f, 0.001f)
            lineToRelative(-0.001f, -0f)
            curveToRelative(-0.006f, 0.061f, -0.013f, 0.124f, -0.024f, 0.19f)
            curveToRelative(-0.005f, 0.032f, -0.012f, 0.059f, -0.018f, 0.089f)
            curveToRelative(0.001f, 0.001f, 0.002f, 0.003f, 0.002f, 0.003f)
            curveToRelative(-0f, 0f, -0.002f, 0f, -0.002f, 0f)
            curveToRelative(-0.018f, 0.088f, -0.038f, 0.169f, -0.061f, 0.241f)
            curveToRelative(0f, 0.001f, 0.001f, 0.001f, 0.001f, 0.001f)
            curveToRelative(-0f, 0f, -0.001f, 0.001f, -0.002f, 0.001f)
            curveToRelative(-0.109f, 0.346f, -0.256f, 0.518f, -0.256f, 0.518f)
            curveToRelative(-0f, 0f, -0.181f, -0.177f, -0.303f, -0.533f)
            curveToRelative(-0.001f, -0.001f, -0.002f, -0.002f, -0.002f, -0.002f)
            curveToRelative(-0f, 0f, 0.001f, -0.001f, 0.002f, -0.001f)
            curveToRelative(-0.032f, -0.094f, -0.061f, -0.198f, -0.081f, -0.318f)
            curveToRelative(-0.031f, -0.194f, -0.038f, -0.366f, -0.031f, -0.516f)
            curveToRelative(-0f, 0f, -0.001f, 0.001f, -0.001f, 0.001f)
            curveToRelative(-0f, 0f, 0.001f, -0.002f, 0.001f, -0.002f)
            curveToRelative(0.004f, -0.1f, 0.014f, -0.189f, 0.028f, -0.267f)
            curveToRelative(-0f, 0.001f, -0.002f, 0.002f, -0.002f, 0.002f)
            curveToRelative(-0f, 0f, 0.001f, -0.004f, 0.003f, -0.012f)
            curveToRelative(0.026f, -0.145f, 0.064f, -0.25f, 0.093f, -0.302f)
            curveToRelative(0.043f, -0.076f, 0.144f, -0.096f, 0.216f, -0.101f)
            curveToRelative(-0.029f, -0f, -0.054f, -0.001f, -0.07f, -0.002f)
            curveToRelative(-0.061f, -0.004f, -0.11f, -0.036f, -0.148f, -0.082f)
            curveToRelative(-0.055f, 0.126f, -0.185f, 0.328f, -0.272f, 0.489f)
            curveToRelative(-0.071f, 0.132f, -0.107f, 0.226f, -0.126f, 0.282f)
            curveToRelative(0.012f, 0.044f, 0.023f, 0.125f, 0.014f, 0.277f)
            curveToRelative(-0.007f, 0.117f, -0.016f, 0.386f, -0.058f, 0.549f)
            curveToRelative(-0.025f, 0.098f, -0.048f, 0.148f, -0.066f, 0.175f)
            curveToRelative(-0.017f, 0.062f, -0.047f, 0.176f, -0.089f, 0.346f)
            curveToRelative(-0.053f, 0.213f, 0.066f, 0.94f, 0.047f, 1.275f)
            curveToRelative(-0.007f, 0.125f, 0.009f, 0.261f, 0.003f, 0.343f)
            curveToRelative(-0.005f, 0.066f, -0.045f, 0.016f, -0.079f, -0.119f)
            curveToRelative(-0.035f, -0.139f, -0.09f, -1.29f, -0.05f, -1.536f)
            curveToRelative(0.031f, -0.193f, 0.078f, -0.254f, 0.135f, -0.316f)
            curveToRelative(0.019f, -0.129f, 0.085f, -0.581f, 0.093f, -0.749f)
            curveToRelative(0.005f, -0.112f, 0.015f, -0.191f, 0.022f, -0.238f)
            curveToRelative(-0.009f, -0.051f, -0.015f, -0.138f, 0.025f, -0.229f)
            curveToRelative(0.057f, -0.133f, 0.252f, -0.465f, 0.351f, -0.632f)
            curveToRelative(-0.001f, -0.002f, -0.002f, -0.004f, -0.003f, -0.006f)
            curveToRelative(-0.021f, 0.039f, -0.045f, 0.079f, -0.071f, 0.119f)
            curveToRelative(-0.121f, 0.184f, -0.296f, 0.372f, -0.515f, 0.533f)
            curveToRelative(-0.01f, 0.048f, -0.029f, 0.116f, -0.067f, 0.21f)
            curveToRelative(-0.044f, 0.109f, -0.137f, 0.361f, -0.229f, 0.503f)
            curveToRelative(-0.076f, 0.117f, -0.12f, 0.151f, -0.143f, 0.16f)
            curveToRelative(-0.017f, 0.062f, -0.047f, 0.176f, -0.09f, 0.347f)
            curveToRelative(-0.053f, 0.213f, -0.068f, 0.312f, -0.087f, 0.647f)
            curveToRelative(-0.007f, 0.125f, 0.009f, 0.261f, 0.003f, 0.343f)
            curveToRelative(-0.005f, 0.066f, -0.045f, 0.016f, -0.079f, -0.119f)
            curveToRelative(-0.035f, -0.139f, 0.044f, -0.662f, 0.085f, -0.907f)
            curveToRelative(0.037f, -0.229f, 0.096f, -0.273f, 0.168f, -0.351f)
            curveToRelative(0.064f, -0.127f, 0.261f, -0.519f, 0.32f, -0.672f)
            curveToRelative(0.016f, -0.041f, 0.031f, -0.076f, 0.044f, -0.108f)
            curveToRelative(-0.07f, 0.048f, -0.143f, 0.093f, -0.222f, 0.133f)
            curveToRelative(-0.505f, 0.263f, -1.01f, 0.267f, -1.143f, 0.076f)
            curveToRelative(-0.001f, -0.002f, -0.003f, -0.004f, -0.004f, -0.006f)
            curveToRelative(-0.003f, -0.006f, -0.007f, -0.011f, -0.01f, -0.017f)
            curveToRelative(-0.006f, -0.011f, -0.011f, -0.023f, -0.015f, -0.038f)
            curveToRelative(-0.004f, -0.016f, -0.006f, -0.034f, -0.005f, -0.051f)
            curveToRelative(-0f, -0.001f, -0f, -0.001f, -0f, -0.002f)
            curveToRelative(0f, -0.009f, 0.002f, -0.018f, 0.004f, -0.027f)
            curveToRelative(0.005f, -0.038f, 0.019f, -0.074f, 0.037f, -0.103f)
            close()
        }
        path(fill = SolidColor(Color.White)) {
            moveTo(6.366f, 23.282f)
            lineToRelative(-5.832f, 0f)
            lineToRelative(-0f, 0.53f)
            lineToRelative(5.832f, 0f)
            close()
        }
    }.build()
}