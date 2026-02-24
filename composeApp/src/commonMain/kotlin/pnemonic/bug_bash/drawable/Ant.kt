package pnemonic.bug_bash.drawable

import androidx.compose.animation.core.LinearEasing
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
import pnemonic.bug_bash.model.bug.Ant
import pnemonic.stateOf

private const val durationLeg = 500

@Composable
fun ant(bug: Ant): ImageVector = ant(bug.isSquashed)

@Composable
fun ant(squashed: Boolean = false): ImageVector {
    val rotateL1: State<Float>
    val rotateL2: State<Float>
    val rotateL3: State<Float>
    val rotateR1: State<Float>
    val rotateR2: State<Float>
    val rotateR3: State<Float>

    if (squashed) {
        rotateL1 = stateOf(0f)
        rotateL2 = rotateL1
        rotateL3 = rotateL2
        rotateR1 = stateOf(0f)
        rotateR2 = rotateR1
        rotateR3 = rotateR1
    } else {
        val transition = rememberInfiniteTransition()
        rotateL1 = transition.animateFloat(
            initialValue = 0f,
            targetValue = -30f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationLeg,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        rotateL2 = transition.animateFloat(
            initialValue = -15f,
            targetValue = 15f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationLeg,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        rotateL3 = transition.animateFloat(
            initialValue = 15f,
            targetValue = -15f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationLeg,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        rotateR1 = transition.animateFloat(
            initialValue = 30f,
            targetValue = 0f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationLeg,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        rotateR2 = transition.animateFloat(
            initialValue = -15f,
            targetValue = 15f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationLeg,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        rotateR3 = transition.animateFloat(
            initialValue = 15f,
            targetValue = -15f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationLeg,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
    }

    return ImageVector.Builder(
        name = "Ant",
        defaultWidth = 18.22.dp,
        defaultHeight = 21.dp,
        viewportWidth = 18.22f,
        viewportHeight = 21f
    ).apply {
        path(fill = SolidColor(Color(0xFF542E18))) {
            moveToRelative(8.469f, 5.343f)
            curveToRelative(-0.032f, 0f, -0.064f, -0.008f, -0.092f, -0.027f)
            lineToRelative(-2.009f, -1.282f)
            curveToRelative(-0.066f, -0.043f, -0.096f, -0.125f, -0.069f, -0.2f)
            lineToRelative(1.282f, -3.718f)
            curveToRelative(0.031f, -0.089f, 0.128f, -0.137f, 0.218f, -0.106f)
            curveToRelative(0.089f, 0.031f, 0.136f, 0.128f, 0.106f, 0.217f)
            lineToRelative(-1.238f, 3.591f)
            lineToRelative(1.895f, 1.21f)
            curveToRelative(0.08f, 0.051f, 0.103f, 0.156f, 0.052f, 0.236f)
            curveToRelative(-0.032f, 0.051f, -0.088f, 0.079f, -0.144f, 0.079f)
            close()
        }
        group(name = "left leg 1", rotate = rotateL1.value, pivotX = 8.508f, 9.501f) {
            path(fill = SolidColor(Color(0xFF6D3C1F))) {
                moveToRelative(6.142f, 7.464f)
                curveToRelative(-0.112f, 0f, -0.202f, -0.09f, -0.202f, -0.202f)
                lineToRelative(0f, -1.992f)
                lineToRelative(-2.017f, -2.263f)
                curveToRelative(-0.074f, -0.083f, -0.067f, -0.21f, 0.017f, -0.284f)
                curveToRelative(0.083f, -0.074f, 0.21f, -0.067f, 0.284f, 0.016f)
                lineToRelative(2.068f, 2.321f)
                curveToRelative(0.033f, 0.036f, 0.052f, 0.085f, 0.052f, 0.134f)
                lineToRelative(0f, 2.069f)
                curveToRelative(0f, 0.112f, -0.09f, 0.202f, -0.202f, 0.202f)
                close()
            }
            path(fill = SolidColor(Color(0xFF5D2C10))) {
                moveToRelative(8.206f, 9.804f)
                lineToRelative(-0.858f, 0f)
                curveToRelative(-0.116f, 0f, -0.221f, -0.066f, -0.272f, -0.17f)
                lineToRelative(-1.11f, -2.27f)
                curveToRelative(-0.073f, -0.15f, -0.012f, -0.331f, 0.139f, -0.405f)
                curveToRelative(0.15f, -0.073f, 0.332f, -0.012f, 0.405f, 0.139f)
                lineToRelative(1.027f, 2.1f)
                lineToRelative(0.669f, 0f)
                curveToRelative(0.167f, 0f, 0.302f, 0.135f, 0.302f, 0.303f)
                curveToRelative(0f, 0.168f, -0.135f, 0.303f, -0.302f, 0.303f)
                close()
            }
        }
        group(name = "left leg 2", rotate = rotateL2.value, pivotX = 8.701f, 10.606f) {
            path(fill = SolidColor(Color(0xFF6D3C1F))) {
                moveToRelative(0.201f, 13.442f)
                curveToRelative(-0.096f, 0f, -0.181f, -0.068f, -0.198f, -0.166f)
                curveToRelative(-0.02f, -0.11f, 0.054f, -0.215f, 0.163f, -0.234f)
                lineToRelative(2.757f, -0.492f)
                lineToRelative(2.401f, -2.678f)
                curveToRelative(0.074f, -0.083f, 0.202f, -0.09f, 0.284f, -0.016f)
                curveToRelative(0.083f, 0.075f, 0.09f, 0.202f, 0.016f, 0.285f)
                lineToRelative(-2.447f, 2.73f)
                curveToRelative(-0.03f, 0.034f, -0.07f, 0.056f, -0.115f, 0.064f)
                lineToRelative(-2.825f, 0.505f)
                curveToRelative(-0.012f, 0.002f, -0.024f, 0.003f, -0.036f, 0.003f)
                close()
            }
            path(fill = SolidColor(Color(0xFF5D2C10))) {
                moveToRelative(7.291f, 12.335f)
                curveToRelative(-0.003f, 0f, -0.006f, 0f, -0.008f, 0f)
                curveToRelative(-0.083f, -0.002f, -0.163f, -0.039f, -0.218f, -0.102f)
                lineToRelative(-1.881f, -2.119f)
                curveToRelative(-0.111f, -0.125f, -0.099f, -0.316f, 0.025f, -0.427f)
                curveToRelative(0.125f, -0.111f, 0.317f, -0.099f, 0.427f, 0.025f)
                lineToRelative(1.666f, 1.877f)
                lineToRelative(0.97f, -0.981f)
                curveToRelative(0.117f, -0.119f, 0.31f, -0.12f, 0.429f, -0.002f)
                curveToRelative(0.118f, 0.118f, 0.12f, 0.309f, 0.002f, 0.428f)
                lineToRelative(-1.198f, 1.211f)
                curveToRelative(-0.056f, 0.057f, -0.134f, 0.09f, -0.214f, 0.09f)
                close()
            }
        }
        group(name = "left leg 3", rotate = rotateL3.value, pivotX = 8.684f, 11.801f) {
            path(fill = SolidColor(Color(0xFF6D3C1F))) {
                moveToRelative(3.04f, 20.866f)
                curveToRelative(-0.033f, 0f, -0.066f, -0.008f, -0.097f, -0.025f)
                curveToRelative(-0.098f, -0.054f, -0.133f, -0.177f, -0.079f, -0.275f)
                lineToRelative(2.109f, -3.821f)
                lineToRelative(-0.618f, -3.246f)
                curveToRelative(-0.021f, -0.11f, 0.051f, -0.215f, 0.161f, -0.236f)
                curveToRelative(0.11f, -0.02f, 0.216f, 0.051f, 0.236f, 0.161f)
                lineToRelative(0.631f, 3.318f)
                curveToRelative(0.008f, 0.046f, 0.001f, 0.094f, -0.022f, 0.135f)
                lineToRelative(-2.144f, 3.884f)
                curveToRelative(-0.037f, 0.067f, -0.106f, 0.105f, -0.177f, 0.105f)
                close()
            }
            path(fill = SolidColor(Color(0xFF5D2C10))) {
                moveToRelative(7.291f, 13.742f)
                lineToRelative(-2.739f, 0f)
                curveToRelative(-0.167f, 0f, -0.303f, -0.136f, -0.303f, -0.303f)
                curveToRelative(0f, -0.167f, 0.136f, -0.303f, 0.303f, -0.303f)
                lineToRelative(2.598f, 0f)
                lineToRelative(1.106f, -1.301f)
                curveToRelative(0.109f, -0.127f, 0.299f, -0.143f, 0.426f, -0.035f)
                curveToRelative(0.127f, 0.109f, 0.143f, 0.299f, 0.035f, 0.427f)
                lineToRelative(-1.197f, 1.407f)
                curveToRelative(-0.057f, 0.067f, -0.142f, 0.106f, -0.23f, 0.106f)
                close()
            }
        }
        path(fill = SolidColor(Color(0xFF5D2C10))) {
            moveTo(9.026f, 4.526f)
            curveTo(8.412f, 4.526f, 7.469f, 5.413f, 7.469f, 6.027f)
            lineTo(7.469f, 6.555f)
            curveTo(7.469f, 7.169f, 7.967f, 7.667f, 8.581f, 7.667f)
            lineTo(9.035f, 7.667f)
            lineTo(9.048f, 7.667f)
            lineTo(9.503f, 7.667f)
            curveTo(10.117f, 7.667f, 10.614f, 7.169f, 10.614f, 6.555f)
            lineTo(10.614f, 6.027f)
            curveTo(10.614f, 5.413f, 9.672f, 4.526f, 9.058f, 4.526f)
            lineTo(9.048f, 4.526f)
            lineTo(9.035f, 4.526f)
            lineTo(9.026f, 4.526f)
            close()
        }
        path(fill = SolidColor(Color(0xFF5D2C10))) {
            moveTo(9.035f, 7.595f)
            curveTo(8.57f, 7.595f, 8.194f, 7.973f, 8.194f, 8.438f)
            lineTo(8.194f, 9.318f)
            curveTo(8.194f, 9.783f, 8.57f, 10.159f, 9.035f, 10.159f)
            curveTo(9.038f, 10.159f, 9.04f, 10.159f, 9.042f, 10.159f)
            curveTo(9.044f, 10.159f, 9.046f, 10.159f, 9.048f, 10.159f)
            curveTo(9.514f, 10.159f, 9.89f, 9.783f, 9.89f, 9.318f)
            lineTo(9.89f, 8.438f)
            curveTo(9.89f, 7.973f, 9.514f, 7.595f, 9.048f, 7.595f)
            curveTo(9.046f, 7.595f, 9.044f, 7.596f, 9.042f, 7.596f)
            curveTo(9.04f, 7.596f, 9.038f, 7.595f, 9.035f, 7.595f)
            close()
        }
        path(fill = SolidColor(Color(0xFF5D2C10))) {
            moveTo(9.035f, 10.01f)
            curveTo(8.671f, 10.01f, 8.375f, 10.305f, 8.375f, 10.67f)
            lineTo(8.375f, 13.061f)
            curveTo(8.375f, 13.425f, 8.671f, 13.721f, 9.035f, 13.721f)
            curveTo(9.038f, 13.721f, 9.04f, 13.72f, 9.042f, 13.72f)
            curveTo(9.044f, 13.72f, 9.046f, 13.721f, 9.048f, 13.721f)
            curveTo(9.413f, 13.721f, 9.709f, 13.425f, 9.709f, 13.061f)
            lineTo(9.709f, 10.67f)
            curveTo(9.709f, 10.305f, 9.413f, 10.01f, 9.048f, 10.01f)
            curveTo(9.046f, 10.01f, 9.044f, 10.01f, 9.042f, 10.01f)
            curveTo(9.04f, 10.01f, 9.038f, 10.01f, 9.035f, 10.01f)
            close()
        }
        path(fill = SolidColor(Color(0xFF5D2C10))) {
            moveTo(9.035f, 13.527f)
            curveTo(8.168f, 13.527f, 7.465f, 14.23f, 7.465f, 15.097f)
            lineTo(7.465f, 16.561f)
            curveTo(7.465f, 17.428f, 8.168f, 18.132f, 9.035f, 18.132f)
            lineTo(9.048f, 18.132f)
            curveTo(9.916f, 18.132f, 10.62f, 17.428f, 10.62f, 16.561f)
            lineTo(10.62f, 15.097f)
            curveTo(10.62f, 14.23f, 9.916f, 13.527f, 9.048f, 13.527f)
            lineTo(9.035f, 13.527f)
            close()
        }
        path(fill = SolidColor(Color(0xFF2E1A0D))) {
            moveToRelative(8.81f, 5.588f)
            curveToRelative(0f, 0.304f, -0.172f, 0.55f, -0.384f, 0.55f)
            lineToRelative(-0.074f, 0f)
            curveToRelative(-0.211f, 0f, -0.384f, -0.246f, -0.384f, -0.55f)
            lineToRelative(0f, 0f)
            curveToRelative(0f, -0.304f, 0.172f, -0.55f, 0.384f, -0.55f)
            lineToRelative(0.074f, 0f)
            curveToRelative(0.213f, 0f, 0.384f, 0.246f, 0.384f, 0.55f)
            close()
        }
        path(fill = SolidColor(Color(0xFF542E18))) {
            moveToRelative(9.615f, 5.343f)
            curveToRelative(0.031f, 0f, 0.064f, -0.008f, 0.092f, -0.027f)
            lineToRelative(2.009f, -1.282f)
            curveToRelative(0.067f, -0.043f, 0.095f, -0.125f, 0.07f, -0.2f)
            lineToRelative(-1.282f, -3.718f)
            curveToRelative(-0.031f, -0.089f, -0.128f, -0.137f, -0.217f, -0.106f)
            curveToRelative(-0.089f, 0.031f, -0.136f, 0.128f, -0.106f, 0.217f)
            lineToRelative(1.239f, 3.591f)
            lineToRelative(-1.895f, 1.21f)
            curveToRelative(-0.08f, 0.051f, -0.103f, 0.156f, -0.053f, 0.236f)
            curveToRelative(0.032f, 0.051f, 0.088f, 0.079f, 0.144f, 0.079f)
            close()
        }
        group(name = "right leg 1", rotate = rotateR1.value, pivotX = 9.575f, 9.501f) {
            path(fill = SolidColor(Color(0xFF6D3C1F))) {
                moveToRelative(11.942f, 7.464f)
                curveToRelative(0.111f, 0f, 0.201f, -0.09f, 0.201f, -0.202f)
                lineToRelative(0f, -1.992f)
                lineToRelative(2.017f, -2.263f)
                curveToRelative(0.074f, -0.083f, 0.066f, -0.21f, -0.016f, -0.284f)
                curveToRelative(-0.083f, -0.074f, -0.21f, -0.067f, -0.285f, 0.016f)
                lineToRelative(-2.068f, 2.321f)
                curveToRelative(-0.034f, 0.036f, -0.052f, 0.085f, -0.052f, 0.134f)
                lineToRelative(0f, 2.069f)
                curveToRelative(-0f, 0.112f, 0.09f, 0.202f, 0.202f, 0.202f)
                close()
            }
            path(fill = SolidColor(Color(0xFF5D2C10))) {
                moveToRelative(9.877f, 9.804f)
                lineToRelative(0.858f, 0f)
                curveToRelative(0.116f, 0f, 0.221f, -0.066f, 0.272f, -0.17f)
                lineToRelative(1.11f, -2.27f)
                curveToRelative(0.073f, -0.15f, 0.011f, -0.331f, -0.139f, -0.405f)
                curveToRelative(-0.15f, -0.073f, -0.332f, -0.012f, -0.404f, 0.139f)
                lineToRelative(-1.027f, 2.1f)
                lineToRelative(-0.669f, 0f)
                curveToRelative(-0.167f, 0f, -0.302f, 0.135f, -0.302f, 0.303f)
                curveToRelative(-0.001f, 0.168f, 0.135f, 0.303f, 0.302f, 0.303f)
                close()
            }
        }
        group(name = "right leg 2", rotate = rotateR2.value, pivotX = 9.383f, 10.606f) {
            path(fill = SolidColor(Color(0xFF6D3C1F))) {
                moveToRelative(17.881f, 13.442f)
                curveToRelative(0.096f, 0f, 0.181f, -0.068f, 0.199f, -0.166f)
                curveToRelative(0.02f, -0.11f, -0.054f, -0.215f, -0.164f, -0.234f)
                lineToRelative(-2.757f, -0.492f)
                lineToRelative(-2.401f, -2.678f)
                curveToRelative(-0.074f, -0.083f, -0.201f, -0.09f, -0.285f, -0.016f)
                curveToRelative(-0.082f, 0.075f, -0.09f, 0.202f, -0.016f, 0.285f)
                lineToRelative(2.447f, 2.73f)
                curveToRelative(0.03f, 0.034f, 0.07f, 0.056f, 0.115f, 0.064f)
                lineToRelative(2.826f, 0.505f)
                curveToRelative(0.012f, 0.002f, 0.023f, 0.003f, 0.035f, 0.003f)
                close()
            }
            path(fill = SolidColor(Color(0xFF5D2C10))) {
                moveToRelative(10.792f, 12.335f)
                curveToRelative(0.003f, 0f, 0.006f, 0f, 0.008f, 0f)
                curveToRelative(0.084f, -0.002f, 0.163f, -0.039f, 0.218f, -0.102f)
                lineToRelative(1.881f, -2.119f)
                curveToRelative(0.111f, -0.125f, 0.099f, -0.316f, -0.026f, -0.427f)
                curveToRelative(-0.125f, -0.111f, -0.316f, -0.099f, -0.427f, 0.025f)
                lineToRelative(-1.666f, 1.877f)
                lineToRelative(-0.969f, -0.981f)
                curveToRelative(-0.118f, -0.119f, -0.31f, -0.12f, -0.429f, -0.002f)
                curveToRelative(-0.119f, 0.118f, -0.12f, 0.309f, -0.003f, 0.428f)
                lineToRelative(1.197f, 1.211f)
                curveToRelative(0.057f, 0.057f, 0.134f, 0.09f, 0.215f, 0.09f)
                close()
            }
        }
        group(name = "right leg 3", rotate = rotateR3.value, pivotX = 9.400f, 11.801f) {
            path(fill = SolidColor(Color(0xFF6D3C1F))) {
                moveToRelative(15.044f, 20.866f)
                curveToRelative(0.033f, 0f, 0.066f, -0.008f, 0.098f, -0.025f)
                curveToRelative(0.097f, -0.054f, 0.133f, -0.177f, 0.079f, -0.275f)
                lineToRelative(-2.109f, -3.821f)
                lineToRelative(0.618f, -3.246f)
                curveToRelative(0.021f, -0.11f, -0.051f, -0.215f, -0.161f, -0.236f)
                curveToRelative(-0.11f, -0.02f, -0.215f, 0.051f, -0.236f, 0.161f)
                lineToRelative(-0.631f, 3.318f)
                curveToRelative(-0.008f, 0.046f, -0.001f, 0.094f, 0.022f, 0.135f)
                lineToRelative(2.144f, 3.884f)
                curveToRelative(0.037f, 0.067f, 0.106f, 0.105f, 0.176f, 0.105f)
                close()
            }
            path(fill = SolidColor(Color(0xFF5D2C10))) {
                moveToRelative(10.792f, 13.742f)
                lineToRelative(2.739f, 0f)
                curveToRelative(0.167f, 0f, 0.302f, -0.136f, 0.302f, -0.303f)
                curveToRelative(0f, -0.167f, -0.136f, -0.303f, -0.302f, -0.303f)
                lineToRelative(-2.598f, 0f)
                lineToRelative(-1.106f, -1.301f)
                curveToRelative(-0.109f, -0.127f, -0.299f, -0.143f, -0.426f, -0.035f)
                curveToRelative(-0.128f, 0.109f, -0.143f, 0.299f, -0.035f, 0.427f)
                lineToRelative(1.197f, 1.407f)
                curveToRelative(0.057f, 0.067f, 0.142f, 0.106f, 0.23f, 0.106f)
                close()
            }
        }
        path(fill = SolidColor(Color(0xFF6D3C1F))) {
            moveToRelative(9.829f, 14.919f)
            curveToRelative(0.163f, 0.076f, 0.324f, 0.073f, 0.324f, 0.162f)
            curveToRelative(0f, 0.089f, -0.144f, 0.162f, -0.324f, 0.162f)
            close()
        }
        path(fill = SolidColor(Color(0xFF2E1A0D))) {
            moveToRelative(9.318f, 5.588f)
            curveToRelative(0f, 0.304f, 0.172f, 0.55f, 0.384f, 0.55f)
            lineToRelative(0.074f, 0f)
            curveToRelative(0.212f, 0f, 0.384f, -0.246f, 0.384f, -0.55f)
            lineToRelative(0f, 0f)
            curveToRelative(0f, -0.304f, -0.172f, -0.55f, -0.384f, -0.55f)
            lineToRelative(-0.074f, 0f)
            curveToRelative(-0.212f, 0f, -0.384f, 0.246f, -0.384f, 0.55f)
            close()
        }
        path(fill = SolidColor(Color(0xFF6D3C1F))) {
            moveToRelative(9.829f, 14.919f)
            curveToRelative(0.18f, -0.003f, 0.324f, 0.073f, 0.324f, 0.162f)
            curveToRelative(0f, 0.089f, -0.144f, 0.162f, -0.324f, 0.162f)
            curveToRelative(-0.636f, -0.036f, -1.278f, 0.06f, -1.886f, -0.142f)
            curveToRelative(0.563f, -0.307f, 1.261f, -0.172f, 1.886f, -0.181f)
            close()
        }
        path(fill = SolidColor(Color(0xFF6D3C1F))) {
            moveToRelative(9.829f, 14.919f)
            curveToRelative(0.18f, -0.003f, 0.324f, 0.073f, 0.324f, 0.162f)
            curveToRelative(0f, 0.089f, -0.145f, 0.172f, -0.324f, 0.162f)
            curveToRelative(-0.318f, -0.018f, -1.246f, -0.003f, -1.562f, -0.009f)
            curveToRelative(-0.191f, -0.003f, -0.332f, -0.086f, -0.324f, -0.168f)
            curveToRelative(0.008f, -0.082f, 0.166f, -0.165f, 0.324f, -0.167f)
            curveToRelative(0.323f, -0.006f, 1.25f, 0.025f, 1.562f, 0.021f)
            close()
        }
        path(fill = SolidColor(Color(0xFF6D3C1F))) {
            moveToRelative(10.031f, 15.851f)
            curveToRelative(0.228f, -0.003f, 0.41f, 0.073f, 0.41f, 0.162f)
            curveToRelative(0f, 0.089f, -0.183f, 0.172f, -0.411f, 0.162f)
            curveToRelative(-0.402f, -0.018f, -1.577f, -0.003f, -1.977f, -0.009f)
            curveToRelative(-0.242f, -0.003f, -0.421f, -0.086f, -0.41f, -0.168f)
            curveToRelative(0.011f, -0.082f, 0.21f, -0.165f, 0.41f, -0.167f)
            curveToRelative(0.409f, -0.006f, 1.582f, 0.025f, 1.977f, 0.021f)
            close()
        }
        path(fill = SolidColor(Color(0xFF6D3C1F))) {
            moveToRelative(9.829f, 16.762f)
            curveToRelative(0.18f, -0.003f, 0.324f, 0.073f, 0.324f, 0.162f)
            curveToRelative(0f, 0.089f, -0.145f, 0.172f, -0.324f, 0.162f)
            curveToRelative(-0.318f, -0.018f, -1.246f, -0.003f, -1.562f, -0.009f)
            curveToRelative(-0.191f, -0.003f, -0.332f, -0.086f, -0.324f, -0.168f)
            curveToRelative(0.008f, -0.082f, 0.166f, -0.165f, 0.324f, -0.167f)
            curveToRelative(0.323f, -0.006f, 1.25f, 0.025f, 1.562f, 0.021f)
            close()
        }
    }.build()
}