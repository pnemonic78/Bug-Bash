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
import pnemonic.bug_bash.model.bug.Moth
import pnemonic.stateOf

private const val durationWing = 1000

@Composable
fun moth(bug: Moth): ImageVector = moth(bug.isSquashed)

@Composable
fun moth(squashed: Boolean = false): ImageVector {
    val rotateL1: State<Float>
    val rotateL2: State<Float>
    val rotateR1: State<Float>
    val rotateR2: State<Float>

    if (squashed) {
        rotateL1 = stateOf(0f)
        rotateL2 = rotateL1
        rotateR1 = rotateL1
        rotateR2 = rotateR1
    } else {
        val transition = rememberInfiniteTransition()
        rotateL1 = transition.animateFloat(
            initialValue = 0f,
            targetValue = 45f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationWing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        rotateL2 = transition.animateFloat(
            initialValue = 0f,
            targetValue = 30f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationWing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        rotateR1 = transition.animateFloat(
            initialValue = 0f,
            targetValue = -45f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationWing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        rotateR2 = transition.animateFloat(
            initialValue = 0f,
            targetValue = -30f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationWing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
    }

    return ImageVector.Builder(
        name = "Moth",
        defaultWidth = 50.dp,
        defaultHeight = 25.5.dp,
        viewportWidth = 50f,
        viewportHeight = 25.5f
    ).apply {
        group("wing-l2", rotate = rotateL2.value, pivotX = 23.454f, pivotY = 11.984f) {
            path(fill = SolidColor(Color(0xFF663A29))) {
                moveTo(23.518f, 14.013f)
                lineToRelative(-0.064f, 4.249f)
                lineToRelative(0.579f, 3.551f)
                lineToRelative(-0.257f, 2.854f)
                lineToRelative(-0.645f, 0.761f)
                lineToRelative(-2.77f, -0.824f)
                lineToRelative(-2.191f, -1.078f)
                lineToRelative(-2.126f, -1.776f)
                lineToRelative(-0.838f, -2.219f)
                lineToRelative(2.513f, -2.854f)
                lineToRelative(4.382f, -4.185f)
                lineToRelative(1.354f, -0.507f)
                close()
            }
            path(fill = SolidColor(Color(0xFF774C36))) {
                moveTo(15.672f, 19.001f)
                lineToRelative(0.952f, 1.353f)
                lineToRelative(1.74f, 1.902f)
                lineToRelative(2.062f, 1.268f)
                lineToRelative(2.062f, 0.634f)
                lineToRelative(1.339f, -0.049f)
                lineToRelative(-0.05f, 0.556f)
                lineToRelative(-0.645f, 0.761f)
                lineToRelative(-2.77f, -0.824f)
                lineToRelative(-2.191f, -1.078f)
                lineToRelative(-2.126f, -1.776f)
                lineToRelative(-0.838f, -2.219f)
                close()
            }
            path(fill = SolidColor(Color(0xFFB27A5B))) {
                moveToRelative(17.567f, 16.849f)
                curveToRelative(0.385f, 0.621f, 0.73f, 1.281f, 1.261f, 1.794f)
                curveToRelative(0.375f, 0.458f, 0.981f, 0.592f, 1.485f, 0.855f)
                curveToRelative(0.581f, 0.267f, 1.196f, 0.449f, 1.795f, 0.664f)
                curveToRelative(0.487f, 0.213f, 1.012f, 0.02f, 1.504f, -0.059f)
                curveToRelative(0.357f, 0.128f, 0.151f, 0.651f, 0.296f, 0.941f)
                curveToRelative(0.082f, 0.483f, 0.197f, 0.993f, 0.037f, 1.473f)
                curveToRelative(-0.259f, 0.341f, -0.723f, 0.056f, -1.074f, 0.091f)
                curveToRelative(-0.561f, -0.051f, -1.14f, -0.111f, -1.633f, -0.409f)
                curveToRelative(-0.677f, -0.351f, -1.378f, -0.657f, -2.04f, -1.036f)
                curveToRelative(-0.779f, -0.485f, -1.446f, -1.127f, -2.084f, -1.78f)
                curveToRelative(-0.25f, -0.323f, -0.497f, -0.669f, -0.618f, -1.062f)
                curveToRelative(-0.078f, -0.349f, 0.296f, -0.535f, 0.466f, -0.785f)
                curveToRelative(0.203f, -0.228f, 0.407f, -0.455f, 0.606f, -0.688f)
                close()
            }
            path(fill = SolidColor(Color(0xFF4C291E))) {
                moveToRelative(18.063f, 23.436f)
                curveToRelative(0.072f, -0.954f, 0.192f, -1.914f, 0.444f, -2.837f)
                curveToRelative(0.437f, -1.316f, 0.767f, -2.673f, 1.373f, -3.927f)
                curveToRelative(0.525f, -1.202f, 1.052f, -2.404f, 1.606f, -3.593f)
                curveToRelative(0.143f, -0.115f, 0.633f, -0.688f, 0.389f, -0.216f)
                curveToRelative(-0.767f, 1.736f, -1.617f, 3.438f, -2.254f, 5.229f)
                curveToRelative(-0.374f, 1.004f, -0.658f, 2.039f, -0.966f, 3.065f)
                curveToRelative(-0.168f, 0.708f, -0.171f, 1.441f, -0.255f, 2.162f)
                curveToRelative(0.005f, 0.348f, -0.049f, 0.359f, -0.338f, 0.119f)
                close()
            }
            path(fill = SolidColor(Color(0xFF4C291E))) {
                moveToRelative(19.845f, 22.066f)
                curveToRelative(0.285f, -1.352f, 0.62f, -2.696f, 1.17f, -3.968f)
                curveToRelative(0.461f, -1.187f, 0.855f, -2.405f, 1.352f, -3.574f)
                curveToRelative(0.342f, -0.469f, 0.906f, -1.708f, 1.105f, -1.68f)
                curveToRelative(-0.126f, 0.991f, -0.917f, 1.728f, -1.139f, 2.695f)
                curveToRelative(-0.481f, 1.538f, -0.989f, 3.066f, -1.585f, 4.564f)
                curveToRelative(-0.533f, 1.343f, -0.704f, 2.785f, -1.028f, 4.184f)
                curveToRelative(-0.576f, -0.161f, -0.08f, -0.864f, -0.074f, -1.285f)
                curveToRelative(0.066f, -0.312f, 0.133f, -0.624f, 0.199f, -0.936f)
                close()
            }
            path(fill = SolidColor(Color(0xFF4C291E))) {
                moveToRelative(21.037f, 24.064f)
                curveToRelative(0.353f, -1.632f, 0.595f, -3.297f, 1.199f, -4.863f)
                curveToRelative(0.269f, -0.992f, 0.799f, -1.875f, 1.245f, -2.792f)
                curveToRelative(0.148f, 0.69f, -0.309f, 1.271f, -0.639f, 1.823f)
                curveToRelative(-0.697f, 1.994f, -1.19f, 4.059f, -1.575f, 6.136f)
                curveToRelative(0.08f, 0.345f, -0.277f, 0.7f, -0.277f, 0.182f)
                curveToRelative(0.012f, -0.162f, 0.079f, -0.323f, 0.047f, -0.486f)
                close()
            }
            path(fill = SolidColor(Color(0xFF4C291E))) {
                moveToRelative(22.345f, 25.193f)
                curveToRelative(-0.026f, -0.593f, -0.03f, -1.194f, 0.113f, -1.774f)
                curveToRelative(0.169f, -1.095f, 0.32f, -2.197f, 0.627f, -3.264f)
                curveToRelative(0.136f, -0.542f, 0.275f, -1.083f, 0.413f, -1.625f)
                curveToRelative(0.05f, 0.309f, 0.101f, 0.619f, 0.151f, 0.928f)
                curveToRelative(-0.316f, 0.621f, -0.347f, 1.332f, -0.523f, 1.996f)
                curveToRelative(-0.2f, 0.904f, -0.41f, 1.811f, -0.481f, 2.737f)
                curveToRelative(-0.038f, 0.356f, -0.069f, 0.714f, -0.062f, 1.073f)
                curveToRelative(-0.079f, -0.024f, -0.159f, -0.047f, -0.238f, -0.071f)
                close()
            }
        }
        group("wing-r2", rotate = rotateR2.value, pivotX = 26.353f, pivotY = 11.984f) {
            path(fill = SolidColor(Color(0xFF663A29))) {
                moveTo(26.289f, 14.013f)
                lineToRelative(0.064f, 4.249f)
                lineToRelative(-0.58f, 3.551f)
                lineToRelative(0.258f, 2.854f)
                lineToRelative(0.645f, 0.761f)
                lineToRelative(2.77f, -0.824f)
                lineToRelative(2.191f, -1.078f)
                lineToRelative(2.126f, -1.776f)
                lineToRelative(0.838f, -2.219f)
                lineToRelative(-2.513f, -2.854f)
                lineToRelative(-4.381f, -4.185f)
                lineToRelative(-1.353f, -0.507f)
                close()
            }
            path(fill = SolidColor(Color(0xFF774C36))) {
                moveTo(34.135f, 19.001f)
                lineToRelative(-0.952f, 1.353f)
                lineToRelative(-1.74f, 1.902f)
                lineToRelative(-2.062f, 1.268f)
                lineToRelative(-2.062f, 0.634f)
                lineToRelative(-1.339f, -0.049f)
                lineToRelative(0.051f, 0.556f)
                lineToRelative(0.645f, 0.761f)
                lineToRelative(2.77f, -0.824f)
                lineToRelative(2.191f, -1.078f)
                lineToRelative(2.126f, -1.776f)
                lineToRelative(0.838f, -2.219f)
                close()
            }
            path(fill = SolidColor(Color(0xFFB27A5B))) {
                moveToRelative(32.239f, 16.849f)
                curveToRelative(-0.541f, 0.863f, -1.039f, 1.889f, -2.019f, 2.326f)
                curveToRelative(-0.935f, 0.436f, -1.903f, 0.811f, -2.897f, 1.086f)
                curveToRelative(-0.514f, 0.12f, -1.455f, -0.58f, -1.346f, 0.333f)
                curveToRelative(-0.026f, 0.629f, -0.589f, 1.849f, 0.209f, 2.098f)
                curveToRelative(0.831f, -0.127f, 1.725f, -0.062f, 2.462f, -0.532f)
                curveToRelative(1.044f, -0.528f, 2.159f, -0.971f, 3.017f, -1.792f)
                curveToRelative(0.513f, -0.475f, 1.087f, -0.921f, 1.411f, -1.552f)
                curveToRelative(0.368f, -0.353f, 0.29f, -0.837f, -0.091f, -1.12f)
                curveToRelative(-0.249f, -0.282f, -0.497f, -0.564f, -0.746f, -0.847f)
                close()
            }
            path(fill = SolidColor(Color(0xFF4C291E))) {
                moveToRelative(31.744f, 23.436f)
                curveToRelative(-0.07f, -1.448f, -0.404f, -2.86f, -0.88f, -4.223f)
                curveToRelative(-0.58f, -2.017f, -1.558f, -3.885f, -2.391f, -5.803f)
                curveToRelative(-0.091f, -0.431f, -0.96f, -1.127f, -0.427f, -0.292f)
                curveToRelative(1.094f, 2.387f, 2.208f, 4.78f, 2.896f, 7.322f)
                curveToRelative(0.376f, 1.022f, 0.379f, 2.117f, 0.491f, 3.186f)
                lineToRelative(0.163f, -0.082f)
                close()
            }
            path(fill = SolidColor(Color(0xFF4C291E))) {
                moveToRelative(29.961f, 22.066f)
                curveToRelative(-0.285f, -1.352f, -0.62f, -2.696f, -1.17f, -3.968f)
                curveToRelative(-0.461f, -1.187f, -0.855f, -2.405f, -1.352f, -3.574f)
                curveToRelative(-0.342f, -0.469f, -0.906f, -1.708f, -1.105f, -1.68f)
                curveToRelative(0.125f, 0.991f, 0.917f, 1.728f, 1.138f, 2.695f)
                curveToRelative(0.481f, 1.538f, 0.99f, 3.066f, 1.585f, 4.564f)
                curveToRelative(0.533f, 1.343f, 0.703f, 2.785f, 1.028f, 4.184f)
                curveToRelative(0.69f, -0.497f, -0.182f, -1.411f, -0.099f, -2.098f)
                close()
            }
            path(fill = SolidColor(Color(0xFF4C291E))) {
                moveToRelative(28.77f, 24.064f)
                curveToRelative(-0.353f, -1.632f, -0.595f, -3.297f, -1.199f, -4.863f)
                curveToRelative(-0.268f, -0.992f, -0.8f, -1.875f, -1.245f, -2.792f)
                curveToRelative(-0.147f, 0.69f, 0.309f, 1.271f, 0.639f, 1.823f)
                curveToRelative(0.697f, 1.994f, 1.191f, 4.059f, 1.575f, 6.136f)
                curveToRelative(-0.081f, 0.347f, 0.277f, 0.696f, 0.277f, 0.18f)
                curveToRelative(-0.013f, -0.161f, -0.08f, -0.322f, -0.047f, -0.484f)
                close()
            }
            path(fill = SolidColor(Color(0xFF4C291E))) {
                moveToRelative(27.462f, 25.193f)
                curveToRelative(0.038f, -0.622f, 0.012f, -1.245f, -0.126f, -1.854f)
                curveToRelative(-0.162f, -1.099f, -0.33f, -2.2f, -0.635f, -3.271f)
                curveToRelative(-0.127f, -0.448f, -0.287f, -1.24f, -0.396f, -1.473f)
                curveToRelative(-0.094f, 0.448f, -0.221f, 0.921f, 0.046f, 1.341f)
                curveToRelative(0.242f, 1.109f, 0.496f, 2.217f, 0.705f, 3.333f)
                curveToRelative(0.074f, 0.662f, 0.177f, 1.326f, 0.168f, 1.995f)
                curveToRelative(0.079f, -0.024f, 0.159f, -0.047f, 0.238f, -0.071f)
                close()
            }
        }
        path(fill = SolidColor(Color(0xFF4C291E))) {
            moveTo(24.641f, 11.413f)
            lineToRelative(1.379f, -0.423f)
            lineToRelative(0.827f, -1.352f)
            lineToRelative(0f, -1.86f)
            lineToRelative(-1.01f, -0.677f)
            lineToRelative(-0.735f, -0.253f)
            lineToRelative(-1.379f, 0.423f)
            lineToRelative(-0.827f, 1.353f)
            lineToRelative(0.275f, 1.86f)
            close()
        }
        path(fill = SolidColor(Color(0xFF4C291E))) {
            moveTo(26.16f, 6.341f)
            lineToRelative(-0.086f, 1.353f)
            lineToRelative(-2.148f, -0.085f)
            lineToRelative(-0.258f, -1.015f)
            lineToRelative(0.687f, -0.676f)
            lineToRelative(1.031f, 0f)
            close()
        }
        path(fill = SolidColor(Color(0xFF4C291E))) {
            moveTo(25.387f, 24.18f)
            lineToRelative(0.515f, -1.353f)
            lineToRelative(0.602f, -2.367f)
            lineToRelative(0.258f, -3.128f)
            lineToRelative(0.258f, -2.789f)
            lineToRelative(-0.258f, -2.537f)
            lineToRelative(-0.429f, -1.183f)
            lineToRelative(-0.945f, -0.169f)
            lineToRelative(-0.602f, 0.085f)
            lineToRelative(-1.375f, 0.423f)
            lineToRelative(-0.687f, 1.183f)
            lineToRelative(0.087f, 2.029f)
            lineToRelative(0.859f, 3.636f)
            lineToRelative(0.687f, 3.212f)
            lineToRelative(0.343f, 2.198f)
            close()
        }
        path(fill = SolidColor(Color(0xFFD3AE7D))) {
            moveToRelative(23.755f, 12.259f)
            lineToRelative(-1.005f, 0.693f)
            lineToRelative(0.027f, 0.652f)
            lineToRelative(0.548f, -0.415f)
            lineToRelative(1.547f, -0.338f)
            lineToRelative(1.546f, 0.085f)
            curveToRelative(0f, 0f, 0.207f, 0.135f, 0.466f, 0.271f)
            lineToRelative(-0.092f, -0.899f)
            lineToRelative(-1.491f, -0.387f)
            close()
        }
        path(fill = SolidColor(Color(0xFFD3AE7D))) {
            moveTo(26.246f, 14.88f)
            lineToRelative(0.725f, 0.178f)
            lineToRelative(0.048f, -0.516f)
            lineToRelative(-0.008f, -0.078f)
            lineToRelative(-1.109f, -0.345f)
            lineToRelative(-2.062f, 0.085f)
            lineToRelative(-0.966f, 0.443f)
            lineToRelative(0.169f, 0.714f)
            lineToRelative(1.141f, -0.396f)
            close()
        }
        path(fill = SolidColor(Color(0xFFD3AE7D))) {
            moveTo(24.184f, 16.571f)
            lineToRelative(-0.793f, 0.261f)
            lineToRelative(0.084f, 0.356f)
            lineToRelative(1.483f, -0.278f)
            lineToRelative(1.375f, 0.338f)
            lineToRelative(0.417f, 0.239f)
            lineToRelative(0.012f, -0.155f)
            lineToRelative(0.045f, -0.491f)
            lineToRelative(-0.131f, -0.1f)
            lineToRelative(-1.203f, -0.254f)
            close()
        }
        path(fill = SolidColor(Color(0xFFD3AE7D))) {
            moveTo(23.693f, 18.123f)
            lineToRelative(0.159f, 0.741f)
            lineToRelative(0.59f, -0.349f)
            lineToRelative(1.203f, 0.084f)
            lineToRelative(0.987f, 0.309f)
            lineToRelative(0.067f, -0.817f)
            lineToRelative(-0.366f, -0.169f)
            lineToRelative(-1.718f, -0.253f)
            close()
        }
        path(fill = SolidColor(Color(0xFFD3AE7D))) {
            moveTo(24.158f, 20.297f)
            lineToRelative(0.714f, -0.175f)
            lineToRelative(1.289f, 0.253f)
            lineToRelative(0.334f, 0.12f)
            lineToRelative(0.009f, -0.035f)
            lineToRelative(0.054f, -0.65f)
            lineToRelative(-0.57f, -0.28f)
            lineToRelative(-1.374f, -0.085f)
            lineToRelative(-0.586f, 0.241f)
            close()
        }
        path(fill = SolidColor(Color(0xFFD3AE7D))) {
            moveTo(24.569f, 22.581f)
            lineToRelative(0.389f, -0.177f)
            lineToRelative(1.089f, -0.143f)
            lineToRelative(0.2f, -0.787f)
            lineToRelative(-1.374f, 0f)
            lineToRelative(-0.437f, 0.25f)
            close()
        }
        path(fill = SolidColor(Color(0xFF4C291E))) {
            moveTo(25.065f, 5.009f)
            lineToRelative(0.451f, 1.205f)
            lineToRelative(-1.095f, -0.064f)
            lineToRelative(0.322f, -1.141f)
            close()
        }
        group("wing-r1", rotate = rotateR1.value, pivotX = 25.988f, pivotY = 9.300f) {
            path(fill = SolidColor(Color(0xFFBF9066))) {
                moveTo(26.675f, 12.809f)
                lineToRelative(-0.58f, -1.268f)
                lineToRelative(-0.515f, -0.951f)
                lineToRelative(0.408f, -1.289f)
                lineToRelative(0.558f, -1.12f)
                lineToRelative(4.253f, 0.317f)
                lineToRelative(5.412f, 1.776f)
                lineToRelative(6.572f, 4.122f)
                lineToRelative(3.093f, 4.375f)
                lineToRelative(0.708f, 2.473f)
                lineToRelative(-0.902f, 0.761f)
                lineToRelative(-1.417f, 0.57f)
                lineToRelative(-1.096f, -0.063f)
                lineToRelative(-0.58f, 0.507f)
                lineToRelative(-0.838f, 0.38f)
                lineToRelative(-1.74f, 0.127f)
                lineToRelative(-1.546f, -0.064f)
                lineToRelative(-0.644f, 0.507f)
                lineToRelative(-0.967f, -0.063f)
                lineToRelative(-0.838f, -0.38f)
                lineToRelative(-0.838f, 0.19f)
                lineToRelative(-0.902f, 0.127f)
                lineToRelative(-1.546f, -0.317f)
                lineToRelative(-0.58f, -1.268f)
                lineToRelative(-1.675f, -4.122f)
                lineToRelative(-1.74f, -2.6f)
                close()
            }
            path(fill = SolidColor(Color(0xFFB27A5B))) {
                moveTo(40.496f, 13.982f)
                lineToRelative(-4.349f, -2.853f)
                lineToRelative(-4.607f, -1.902f)
                lineToRelative(-3.673f, -0.634f)
                lineToRelative(-1.463f, -0.127f)
                lineToRelative(-0.158f, 0.317f)
                lineToRelative(1.138f, 0f)
                lineToRelative(2.803f, 0.476f)
                lineToRelative(1.901f, 0.412f)
                lineToRelative(2.835f, 1.173f)
                lineToRelative(2.803f, 1.617f)
                lineToRelative(2.706f, 1.902f)
                lineToRelative(1.611f, 1.427f)
                lineToRelative(1.128f, 1.046f)
                lineToRelative(1.289f, 2.346f)
                lineToRelative(0.773f, 2.347f)
                lineToRelative(0.189f, 0.581f)
                lineToRelative(0.236f, -0.095f)
                lineToRelative(-0.811f, -2.611f)
                lineToRelative(-1.611f, -2.917f)
                close()
            }
            path(fill = SolidColor(Color(0xFFB27A5B))) {
                moveToRelative(43.138f, 20.196f)
                curveToRelative(-0.644f, -0.967f, -1.147f, -2.038f, -1.891f, -2.932f)
                curveToRelative(-1.161f, -1.127f, -2.27f, -2.332f, -3.658f, -3.189f)
                curveToRelative(-1.166f, -0.866f, -2.346f, -1.735f, -3.689f, -2.311f)
                curveToRelative(-1.08f, -0.59f, -2.195f, -1.141f, -3.413f, -1.374f)
                curveToRelative(-1.416f, -0.389f, -2.83f, -0.793f, -4.218f, -1.275f)
                curveToRelative(-0.677f, 0.419f, 0.877f, 0.567f, 1.209f, 0.717f)
                curveToRelative(2.075f, 0.559f, 4.224f, 0.987f, 6.107f, 2.073f)
                curveToRelative(1.476f, 0.763f, 2.881f, 1.663f, 4.246f, 2.609f)
                curveToRelative(1.019f, 0.87f, 2.048f, 1.745f, 2.945f, 2.745f)
                curveToRelative(0.963f, 1.263f, 2.213f, 2.455f, 2.458f, 4.1f)
                curveToRelative(0.046f, 0.313f, 0.378f, 1.254f, 0.511f, 1.046f)
                curveToRelative(-0.05f, -0.771f, -0.443f, -1.463f, -0.605f, -2.209f)
                close()
            }
            path(fill = SolidColor(Color(0xFFB27A5B))) {
                moveTo(30.574f, 11.826f)
                lineToRelative(-4.798f, -1.853f)
                lineToRelative(-0.152f, 0.479f)
                lineToRelative(3.758f, 1.152f)
                lineToRelative(2.126f, 0.983f)
                lineToRelative(2.191f, 1.205f)
                lineToRelative(2.094f, 1.49f)
                lineToRelative(1.45f, 1.459f)
                lineToRelative(1.16f, 1.585f)
                lineToRelative(0.838f, 1.459f)
                lineToRelative(0.676f, 1.807f)
                lineToRelative(0.226f, 1.458f)
                lineToRelative(0.051f, 0.463f)
                lineToRelative(0.233f, -0.017f)
                lineToRelative(-0.188f, -1.777f)
                lineToRelative(-1.063f, -2.79f)
                lineToRelative(-2.126f, -2.885f)
                lineToRelative(-3.286f, -2.568f)
                close()
            }
            path(fill = SolidColor(Color(0xFFB27A5B))) {
                moveTo(26.004f, 11.372f)
                lineToRelative(0.091f, 0.169f)
                lineToRelative(0.112f, 0.245f)
                lineToRelative(3.303f, 1.277f)
                lineToRelative(1.804f, 0.951f)
                lineToRelative(1.933f, 1.364f)
                lineToRelative(1.482f, 1.205f)
                lineToRelative(1.289f, 1.871f)
                lineToRelative(0.902f, 1.617f)
                lineToRelative(0.644f, 1.712f)
                lineToRelative(0.258f, 1.744f)
                lineToRelative(0f, 0.444f)
                lineToRelative(0.273f, -0.216f)
                lineToRelative(-0.016f, -0.957f)
                lineToRelative(-0.902f, -2.948f)
                lineToRelative(-2.384f, -3.678f)
                lineToRelative(-3.931f, -2.789f)
                close()
            }
            path(fill = SolidColor(Color(0xFFB27A5B))) {
                moveTo(33.403f, 18.17f)
                lineToRelative(1.101f, 1.709f)
                lineToRelative(0.838f, 1.617f)
                lineToRelative(0.355f, 1.871f)
                lineToRelative(0.031f, 0.224f)
                lineToRelative(0.273f, -0.062f)
                lineToRelative(-0.24f, -1.811f)
                lineToRelative(-1.708f, -3.361f)
                lineToRelative(-3.866f, -3.519f)
                lineToRelative(-2.9f, -1.22f)
                lineToRelative(0.355f, 0.469f)
                lineToRelative(1.03f, 0.338f)
                lineToRelative(1.578f, 0.825f)
                lineToRelative(1.579f, 1.49f)
                close()
            }
            path(fill = SolidColor(Color(0xFFD3AE7D))) {
                moveToRelative(42.375f, 17.818f)
                curveToRelative(0.472f, -0.195f, 1.129f, -0.094f, 1.455f, -0.543f)
                curveToRelative(0.208f, -0.344f, 0.748f, -0.703f, 0.244f, -1.047f)
                curveToRelative(-0.479f, -0.032f, -0.945f, 0.477f, -1.438f, 0.63f)
                curveToRelative(-0.489f, 0.133f, -1.023f, -0.125f, -1.532f, -0.137f)
                curveToRelative(-0.586f, -0.07f, -1.178f, -0.105f, -1.766f, -0.094f)
                curveToRelative(-0.471f, 0.087f, -0.937f, 0.234f, -1.37f, 0.436f)
                curveToRelative(-0.468f, 0.303f, -0.743f, 0.809f, -1.106f, 1.215f)
                curveToRelative(-0.207f, 0.642f, -0.732f, 1.001f, -1.399f, 1.003f)
                curveToRelative(-0.949f, 0.175f, -1.919f, 0.21f, -2.882f, 0.186f)
                curveToRelative(-0.563f, 0.09f, -1.278f, 0.688f, -1.035f, 1.297f)
                curveToRelative(0.151f, 0.208f, 0.254f, 0.96f, 0.438f, 0.836f)
                curveToRelative(0.285f, -0.436f, 0.57f, -0.872f, 0.855f, -1.308f)
                curveToRelative(1.088f, -0.054f, 2.184f, -0.094f, 3.266f, 0.054f)
                curveToRelative(0.572f, -0.021f, 1.117f, -0.27f, 1.604f, -0.542f)
                curveToRelative(0.497f, -0.45f, 0.556f, -1.27f, 1.228f, -1.549f)
                curveToRelative(0.542f, -0.369f, 1.154f, -0.526f, 1.808f, -0.435f)
                curveToRelative(0.543f, 0.001f, 1.086f, -0.005f, 1.63f, -0.002f)
                close()
            }
            path(fill = SolidColor(Color(0xFFD3AE7D))) {
                moveToRelative(41.086f, 14.521f)
                curveToRelative(0.604f, 0.083f, 2.205f, -0.051f, 0.982f, -0.582f)
                curveToRelative(-0.786f, -0.681f, -1.858f, -0.513f, -2.813f, -0.602f)
                curveToRelative(-1.108f, -0.092f, -2.23f, 0.209f, -3.196f, 0.742f)
                curveToRelative(-0.839f, 0.466f, -1.002f, 1.433f, -1.425f, 2.199f)
                curveToRelative(-0.455f, 0.851f, -1.516f, 0.503f, -2.282f, 0.489f)
                curveToRelative(-0.822f, -0.197f, -2.52f, 0.231f, -1.948f, 1.349f)
                curveToRelative(0.284f, 0.363f, 0.45f, 1.101f, 0.563f, 0.258f)
                curveToRelative(0.443f, -0.985f, 1.606f, -0.71f, 2.463f, -0.785f)
                curveToRelative(1.083f, 0.069f, 1.846f, -0.766f, 2.198f, -1.697f)
                curveToRelative(-0.091f, -1.165f, 1.143f, -1.289f, 1.954f, -1.624f)
                curveToRelative(0.888f, -0.385f, 1.794f, 0.114f, 2.697f, 0.159f)
                curveToRelative(0.269f, 0.037f, 0.539f, 0.068f, 0.809f, 0.094f)
                close()
            }
            path(fill = SolidColor(Color(0xFFD3AE7D))) {
                moveToRelative(33.707f, 9.451f)
                curveToRelative(-0.618f, 0.242f, -1.302f, 0.162f, -1.952f, 0.19f)
                curveToRelative(-0.443f, 0.081f, -0.874f, 0.541f, -1.082f, 0.929f)
                curveToRelative(-0.075f, 0.422f, -0.292f, 0.843f, -0.164f, 1.275f)
                curveToRelative(0.104f, 0.421f, 0.127f, 1.092f, -0.461f, 1.07f)
                curveToRelative(-0.639f, 0.156f, -1.175f, 0.557f, -1.734f, 0.885f)
                curveToRelative(-0.307f, 0.326f, -0.478f, 0.8f, -0.049f, 1.112f)
                curveToRelative(0.235f, -0.117f, 0.22f, -0.867f, 0.586f, -1.098f)
                curveToRelative(0.259f, -0.439f, 0.761f, -0.113f, 1.132f, -0.312f)
                curveToRelative(0.35f, -0.228f, 0.699f, -0.465f, 1.052f, -0.693f)
                curveToRelative(-0.101f, -0.607f, -0.166f, -1.221f, -0.189f, -1.836f)
                curveToRelative(0.276f, -0.479f, 0.668f, -0.968f, 1.227f, -1.113f)
                curveToRelative(0.572f, -0.122f, 1.166f, 0.143f, 1.732f, -0.054f)
                curveToRelative(0.209f, -0.019f, 0.69f, -0.145f, 0.239f, -0.252f)
                curveToRelative(-0.112f, -0.032f, -0.235f, -0.04f, -0.336f, -0.102f)
                close()
            }
        }
        group("wing-l1", rotate = rotateL1.value, pivotX = 24.012f, pivotY = 9.300f) {
            path(fill = SolidColor(Color(0xFFBF9066))) {
                moveTo(23.325f, 12.809f)
                lineToRelative(0.58f, -1.268f)
                lineToRelative(0.516f, -0.951f)
                lineToRelative(-0.408f, -1.289f)
                lineToRelative(-0.558f, -1.12f)
                lineToRelative(-4.253f, 0.317f)
                lineToRelative(-5.412f, 1.776f)
                lineToRelative(-6.572f, 4.122f)
                lineToRelative(-3.093f, 4.375f)
                lineToRelative(-0.708f, 2.473f)
                lineToRelative(0.902f, 0.761f)
                lineToRelative(1.417f, 0.57f)
                lineToRelative(1.096f, -0.063f)
                lineToRelative(0.58f, 0.507f)
                lineToRelative(0.838f, 0.38f)
                lineToRelative(1.74f, 0.127f)
                lineToRelative(1.547f, -0.064f)
                lineToRelative(0.644f, 0.507f)
                lineToRelative(0.967f, -0.063f)
                lineToRelative(0.838f, -0.38f)
                lineToRelative(0.838f, 0.19f)
                lineToRelative(0.902f, 0.127f)
                lineToRelative(1.546f, -0.317f)
                lineToRelative(0.58f, -1.268f)
                lineToRelative(1.675f, -4.122f)
                lineToRelative(1.74f, -2.6f)
                close()
            }
            path(fill = SolidColor(Color(0xFFB27A5B))) {
                moveTo(9.504f, 13.982f)
                lineToRelative(4.349f, -2.853f)
                lineToRelative(4.607f, -1.902f)
                lineToRelative(3.673f, -0.634f)
                lineToRelative(1.463f, -0.127f)
                lineToRelative(0.158f, 0.317f)
                lineToRelative(-1.138f, 0f)
                lineToRelative(-2.803f, 0.476f)
                lineToRelative(-1.901f, 0.412f)
                lineToRelative(-2.835f, 1.173f)
                lineToRelative(-2.803f, 1.617f)
                lineToRelative(-2.706f, 1.902f)
                lineToRelative(-1.611f, 1.427f)
                lineToRelative(-1.128f, 1.046f)
                lineToRelative(-1.289f, 2.346f)
                lineToRelative(-0.773f, 2.347f)
                lineToRelative(-0.188f, 0.581f)
                lineToRelative(-0.236f, -0.095f)
                lineToRelative(0.811f, -2.611f)
                lineToRelative(1.611f, -2.917f)
                close()
            }
            path(fill = SolidColor(Color(0xFFB27A5B))) {
                moveToRelative(6.862f, 20.196f)
                lineToRelative(1.675f, -2.727f)
                lineToRelative(2.448f, -2.378f)
                lineToRelative(3.544f, -2.536f)
                lineToRelative(3.447f, -1.744f)
                lineToRelative(3.447f, -0.951f)
                lineToRelative(2.472f, -0.792f)
                lineToRelative(0.116f, 0.231f)
                lineToRelative(0.031f, 0.101f)
                lineToRelative(-2.2f, 0.618f)
                lineToRelative(-2.577f, 0.666f)
                lineToRelative(-1.547f, 0.57f)
                lineToRelative(-2.319f, 1.173f)
                lineToRelative(-3.157f, 1.997f)
                lineToRelative(-2.577f, 2.315f)
                lineToRelative(-1.611f, 1.965f)
                lineToRelative(-0.934f, 1.395f)
                curveToRelative(0f, 0f, -0.451f, 1.553f, -0.484f, 1.649f)
                curveToRelative(-0.017f, 0.05f, -0.141f, 0.434f, -0.255f, 0.787f)
                lineToRelative(-0.237f, 0.014f)
                close()
            }
            path(fill = SolidColor(Color(0xFFB27A5B))) {
                moveTo(19.427f, 11.826f)
                lineToRelative(4.798f, -1.853f)
                lineToRelative(0.152f, 0.479f)
                lineToRelative(-3.758f, 1.152f)
                lineToRelative(-2.127f, 0.983f)
                lineToRelative(-2.19f, 1.205f)
                lineToRelative(-2.094f, 1.49f)
                lineToRelative(-1.45f, 1.459f)
                lineToRelative(-1.16f, 1.585f)
                lineToRelative(-0.838f, 1.459f)
                lineToRelative(-0.677f, 1.807f)
                lineToRelative(-0.226f, 1.458f)
                lineToRelative(-0.051f, 0.463f)
                lineToRelative(-0.233f, -0.017f)
                lineToRelative(0.187f, -1.777f)
                lineToRelative(1.063f, -2.79f)
                lineToRelative(2.126f, -2.885f)
                lineToRelative(3.286f, -2.568f)
                close()
            }
            path(fill = SolidColor(Color(0xFFB27A5B))) {
                moveTo(23.996f, 11.372f)
                lineToRelative(-0.092f, 0.169f)
                lineToRelative(-0.111f, 0.245f)
                lineToRelative(-3.303f, 1.277f)
                lineToRelative(-1.804f, 0.951f)
                lineToRelative(-1.933f, 1.364f)
                lineToRelative(-1.482f, 1.205f)
                lineToRelative(-1.289f, 1.871f)
                lineToRelative(-0.902f, 1.617f)
                lineToRelative(-0.644f, 1.712f)
                lineToRelative(-0.258f, 1.744f)
                lineToRelative(0f, 0.444f)
                lineToRelative(-0.273f, -0.216f)
                lineToRelative(0.016f, -0.957f)
                lineToRelative(0.902f, -2.948f)
                lineToRelative(2.384f, -3.678f)
                lineToRelative(3.93f, -2.789f)
                close()
            }
            path(fill = SolidColor(Color(0xFFB27A5B))) {
                moveTo(16.597f, 18.17f)
                lineToRelative(-1.101f, 1.709f)
                lineToRelative(-0.838f, 1.617f)
                lineToRelative(-0.355f, 1.871f)
                lineToRelative(-0.031f, 0.224f)
                lineToRelative(-0.273f, -0.062f)
                lineToRelative(0.24f, -1.811f)
                lineToRelative(1.707f, -3.361f)
                lineToRelative(3.866f, -3.519f)
                lineToRelative(2.9f, -1.22f)
                lineToRelative(-0.355f, 0.469f)
                lineToRelative(-1.03f, 0.338f)
                lineToRelative(-1.578f, 0.825f)
                lineToRelative(-1.579f, 1.49f)
                close()
            }
            path(fill = SolidColor(Color(0xFFD3AE7D))) {
                moveToRelative(7.625f, 17.818f)
                curveToRelative(-0.511f, -0.201f, -1.221f, -0.091f, -1.536f, -0.636f)
                curveToRelative(-0.257f, -0.263f, -0.618f, -0.835f, -0.061f, -0.981f)
                curveToRelative(0.54f, 0.124f, 0.914f, 0.649f, 1.493f, 0.667f)
                curveToRelative(0.715f, 0.044f, 1.405f, -0.226f, 2.121f, -0.209f)
                curveToRelative(0.626f, -0.058f, 1.285f, -0.078f, 1.864f, 0.2f)
                curveToRelative(0.752f, 0.14f, 1.175f, 0.841f, 1.604f, 1.401f)
                curveToRelative(0.252f, 0.412f, 0.515f, 1.003f, 1.091f, 0.968f)
                curveToRelative(0.818f, 0.159f, 1.659f, 0.238f, 2.497f, 0.24f)
                curveToRelative(0.507f, -0.003f, 1.074f, -0.033f, 1.454f, 0.367f)
                curveToRelative(0.384f, 0.294f, 0.433f, 0.828f, 0.183f, 1.225f)
                curveToRelative(-0.128f, 0.303f, -0.256f, 0.905f, -0.489f, 0.322f)
                curveToRelative(-0.261f, -0.411f, -0.432f, -1.05f, -1f, -1.11f)
                curveToRelative(-1.105f, -0.081f, -2.214f, 0.008f, -3.319f, 0.071f)
                curveToRelative(-0.573f, -0.305f, -1.393f, -0.358f, -1.621f, -1.084f)
                curveToRelative(-0.205f, -0.587f, -0.684f, -0.958f, -1.21f, -1.23f)
                curveToRelative(-0.78f, -0.376f, -1.668f, -0.163f, -2.499f, -0.212f)
                curveToRelative(-0.191f, -0f, -0.381f, -0f, -0.572f, -0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFD3AE7D))) {
                moveToRelative(8.914f, 14.521f)
                curveToRelative(-0.459f, -0.026f, -1.318f, 0.104f, -1.505f, -0.243f)
                curveToRelative(0.617f, -0.371f, 1.216f, -0.931f, 1.991f, -0.861f)
                curveToRelative(0.843f, -0.047f, 1.699f, -0.149f, 2.539f, -0.048f)
                curveToRelative(0.928f, 0.244f, 1.982f, 0.442f, 2.595f, 1.259f)
                curveToRelative(0.501f, 0.528f, 0.497f, 1.341f, 0.997f, 1.873f)
                curveToRelative(0.418f, 0.504f, 1.127f, 0.314f, 1.692f, 0.299f)
                curveToRelative(0.756f, -0.055f, 1.65f, -0.192f, 2.259f, 0.377f)
                curveToRelative(0.489f, 0.344f, 0.178f, 0.918f, -0.102f, 1.283f)
                curveToRelative(-0.149f, 0.188f, -0.226f, 0.608f, -0.259f, 0.147f)
                curveToRelative(-0.176f, -0.754f, -1.024f, -1.113f, -1.737f, -0.992f)
                curveToRelative(-0.671f, 0.026f, -1.355f, -0.059f, -1.993f, -0.276f)
                curveToRelative(-0.432f, -0.385f, -0.74f, -0.913f, -1.02f, -1.403f)
                curveToRelative(-0.058f, -0.324f, -0.116f, -0.647f, -0.174f, -0.971f)
                curveToRelative(-0.924f, -0.276f, -1.784f, -0.929f, -2.788f, -0.823f)
                curveToRelative(-0.826f, 0.161f, -1.657f, 0.301f, -2.496f, 0.379f)
                close()
            }
            path(fill = SolidColor(Color(0xFFD3AE7D))) {
                moveToRelative(16.293f, 9.451f)
                curveToRelative(0.678f, 0.277f, 1.429f, 0.121f, 2.134f, 0.213f)
                curveToRelative(0.489f, 0.329f, 0.975f, 0.732f, 1.018f, 1.363f)
                curveToRelative(0.301f, 0.597f, -0.378f, 1.48f, 0.317f, 1.861f)
                curveToRelative(0.562f, 0.041f, 1.02f, 0.384f, 1.498f, 0.649f)
                curveToRelative(0.55f, 0.191f, 1.092f, 1.017f, 0.423f, 1.39f)
                curveToRelative(-0.179f, -0.443f, -0.281f, -1.015f, -0.73f, -1.303f)
                curveToRelative(-0.554f, -0.041f, -1.128f, -0.094f, -1.536f, -0.514f)
                curveToRelative(-0.707f, -0.236f, -0.298f, -0.941f, -0.304f, -1.465f)
                curveToRelative(0.21f, -0.665f, -0.21f, -1.175f, -0.712f, -1.568f)
                curveToRelative(-0.676f, -0.531f, -1.558f, 0.001f, -2.302f, -0.297f)
                curveToRelative(-0.452f, -0.016f, -0.358f, -0.235f, 0.047f, -0.276f)
                lineToRelative(0.076f, -0.024f)
                lineToRelative(0.07f, -0.028f)
                close()
            }
        }
        path(fill = SolidColor(Color(0xFF4C291E))) {
            moveToRelative(25.322f, 6.087f)
            curveToRelative(0.226f, -0.333f, 0.377f, -0.737f, 0.737f, -0.956f)
            curveToRelative(0.533f, -0.43f, 1.017f, -0.926f, 1.62f, -1.26f)
            curveToRelative(0.607f, -0.367f, 1.208f, -0.749f, 1.755f, -1.203f)
            curveToRelative(0.457f, -0.317f, 0.964f, -0.597f, 1.281f, -1.071f)
            curveToRelative(0.293f, -0.365f, 0.657f, -0.684f, 0.921f, -1.064f)
            curveToRelative(0f, -0.178f, 0f, -0.356f, 0f, -0.534f)
            curveToRelative(0.129f, 0f, 0.258f, 0f, 0.387f, 0f)
            curveToRelative(0f, 0.18f, 0f, 0.359f, 0f, 0.539f)
            curveToRelative(-0.588f, 0.624f, -1.183f, 1.241f, -1.787f, 1.849f)
            curveToRelative(-1.11f, 0.756f, -2.257f, 1.462f, -3.321f, 2.284f)
            curveToRelative(-0.409f, 0.386f, -0.874f, 0.728f, -1.16f, 1.223f)
            curveToRelative(-0.119f, 0.146f, -0.245f, 0.421f, -0.434f, 0.192f)
            close()
        }
        path(fill = SolidColor(Color(0xFF4C291E))) {
            moveToRelative(24.291f, 6.087f)
            curveToRelative(-0.198f, -0.27f, -0.312f, -0.614f, -0.574f, -0.828f)
            curveToRelative(-0.44f, -0.338f, -0.841f, -0.723f, -1.277f, -1.064f)
            curveToRelative(-0.711f, -0.475f, -1.477f, -0.873f, -2.131f, -1.43f)
            curveToRelative(-0.459f, -0.354f, -1.015f, -0.609f, -1.354f, -1.096f)
            curveToRelative(-0.309f, -0.385f, -0.679f, -0.734f, -0.98f, -1.117f)
            curveToRelative(0f, -0.184f, 0f, -0.368f, 0f, -0.552f)
            curveToRelative(-0.129f, 0f, -0.258f, 0f, -0.387f, 0f)
            curveToRelative(0f, 0.18f, 0f, 0.359f, 0f, 0.539f)
            curveToRelative(0.588f, 0.624f, 1.183f, 1.241f, 1.787f, 1.849f)
            curveToRelative(1.092f, 0.739f, 2.209f, 1.443f, 3.265f, 2.234f)
            curveToRelative(0.295f, 0.267f, 0.592f, 0.532f, 0.876f, 0.81f)
            curveToRelative(0.225f, 0.223f, 0.388f, 0.654f, 0.628f, 0.751f)
            curveToRelative(0.049f, -0.032f, 0.097f, -0.063f, 0.146f, -0.095f)
            close()
        }
    }.build()
}