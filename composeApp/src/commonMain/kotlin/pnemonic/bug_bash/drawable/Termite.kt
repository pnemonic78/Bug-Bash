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
import pnemonic.bug_bash.model.bug.Termite
import pnemonic.stateOf

private const val durationLeg = 500

@Composable
fun termite(bug: Termite): ImageVector = termite(bug.isSquashed)

@Composable
fun termite(squashed: Boolean = false): ImageVector {
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
            initialValue = -30f,
            targetValue = 0f,
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
            initialValue = 0f,
            targetValue = 30f,
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
        name = "Termite",
        defaultWidth = 24.5.dp,
        defaultHeight = 30.3.dp,
        viewportWidth = 24.5f,
        viewportHeight = 30.3f
    ).apply {
        group("leg-l3", rotate = rotateL3.value, pivotX = 10.631f, 16.911f) {
            path(fill = SolidColor(Color(0xFF7D4C2E))) {
                moveToRelative(5.699f, 17.8f)
                lineToRelative(-0.062f, 0.487f)
                lineToRelative(-0.518f, 4.055f)
                curveToRelative(-0.004f, 0.039f, -0.015f, 0.081f, -0.035f, 0.116f)
                lineToRelative(-1.16f, 2.416f)
                curveToRelative(-0.066f, 0.14f, -0.205f, 0.221f, -0.348f, 0.221f)
                curveToRelative(-0.057f, 0f, -0.112f, -0.011f, -0.167f, -0.038f)
                curveToRelative(-0.193f, -0.093f, -0.274f, -0.321f, -0.181f, -0.514f)
                lineToRelative(1.132f, -2.362f)
                lineToRelative(0.518f, -4.048f)
                lineToRelative(0.054f, -0.433f)
                curveToRelative(0.027f, -0.209f, 0.22f, -0.356f, 0.433f, -0.332f)
                curveToRelative(0.208f, 0.026f, 0.36f, 0.219f, 0.333f, 0.432f)
                close()
            }
            path(fill = SolidColor(Color(0xFF7D4C2E))) {
                moveToRelative(10.147f, 17.576f)
                lineToRelative(-1.515f, 0.239f)
                lineToRelative(-2.996f, 0.472f)
                lineToRelative(-0.232f, 0.034f)
                curveToRelative(-0.031f, 0.004f, -0.057f, 0.008f, -0.089f, 0.008f)
                curveToRelative(-0.17f, 0f, -0.329f, -0.074f, -0.437f, -0.197f)
                curveToRelative(-0.07f, -0.081f, -0.12f, -0.181f, -0.135f, -0.293f)
                curveToRelative(-0.05f, -0.313f, 0.166f, -0.61f, 0.483f, -0.662f)
                lineToRelative(3.731f, -0.587f)
                lineToRelative(1.013f, -0.159f)
                curveToRelative(0.293f, -0.046f, 0.568f, 0.14f, 0.645f, 0.418f)
                curveToRelative(0.008f, 0.019f, 0.012f, 0.038f, 0.015f, 0.062f)
                curveToRelative(0.05f, 0.317f, -0.166f, 0.615f, -0.484f, 0.665f)
                close()
            }
        }
        group("leg-l2", rotate = rotateL2.value, pivotX = 11.122f, 15.852f) {
            path(fill = SolidColor(Color(0xFF7D4C2E))) {
                moveToRelative(7.206f, 11.275f)
                curveToRelative(0f, 0.213f, -0.174f, 0.387f, -0.386f, 0.387f)
                lineToRelative(-5.273f, 0f)
                curveToRelative(-0.085f, 0f, -0.166f, -0.027f, -0.232f, -0.078f)
                lineToRelative(-1.16f, -0.87f)
                curveToRelative(-0.169f, -0.128f, -0.205f, -0.372f, -0.077f, -0.541f)
                curveToRelative(0.127f, -0.17f, 0.372f, -0.205f, 0.541f, -0.078f)
                lineToRelative(1.056f, 0.792f)
                lineToRelative(5.145f, 0f)
                curveToRelative(0.212f, 0.001f, 0.386f, 0.174f, 0.386f, 0.387f)
                close()
            }
            path(fill = SolidColor(Color(0xFF7D4C2E))) {
                moveToRelative(11.122f, 15.852f)
                curveToRelative(-0.112f, 0.108f, -0.255f, 0.158f, -0.398f, 0.158f)
                curveToRelative(-0.155f, 0f, -0.309f, -0.062f, -0.421f, -0.181f)
                lineToRelative(-0.842f, -0.897f)
                lineToRelative(-3.066f, -3.259f)
                curveToRelative(-0.004f, -0.004f, -0.008f, -0.008f, -0.008f, -0.011f)
                curveToRelative(-0.197f, -0.225f, -0.197f, -0.557f, 0.004f, -0.773f)
                curveToRelative(0.008f, -0.012f, 0.02f, -0.023f, 0.032f, -0.036f)
                curveToRelative(0.232f, -0.22f, 0.599f, -0.208f, 0.819f, 0.023f)
                lineToRelative(2.652f, 2.822f)
                lineToRelative(0.116f, 0.124f)
                lineToRelative(0.657f, 0.699f)
                lineToRelative(0.479f, 0.511f)
                curveToRelative(0.219f, 0.235f, 0.208f, 0.603f, -0.024f, 0.819f)
                close()
            }
        }
        group("leg-l1", rotate = rotateL1.value, pivotX = 12.251f, 13.269f) {
            path(fill = SolidColor(Color(0xFF7D4C2E))) {
                moveToRelative(7.547f, 10.262f)
                curveToRelative(-0.035f, 0.012f, -0.07f, 0.015f, -0.104f, 0.015f)
                curveToRelative(-0.17f, 0f, -0.325f, -0.112f, -0.372f, -0.282f)
                lineToRelative(-0.115f, -0.414f)
                lineToRelative(-0.457f, -1.611f)
                lineToRelative(-1.998f, -0.781f)
                curveToRelative(-0.202f, -0.078f, -0.298f, -0.301f, -0.221f, -0.499f)
                curveToRelative(0.078f, -0.201f, 0.302f, -0.297f, 0.498f, -0.22f)
                lineToRelative(2.18f, 0.85f)
                curveToRelative(0.112f, 0.043f, 0.197f, 0.136f, 0.232f, 0.255f)
                lineToRelative(0.507f, 1.794f)
                lineToRelative(0.116f, 0.417f)
                curveToRelative(0.057f, 0.205f, -0.062f, 0.417f, -0.267f, 0.475f)
                close()
            }
            path(fill = SolidColor(Color(0xFF7D4C2E))) {
                moveToRelative(12.274f, 12.597f)
                lineToRelative(0f, 0.638f)
                curveToRelative(-0.004f, 0.004f, -0.004f, 0.011f, -0.008f, 0.015f)
                curveToRelative(-0.003f, 0.008f, -0.008f, 0.011f, -0.015f, 0.019f)
                curveToRelative(-0.112f, 0.15f, -0.286f, 0.228f, -0.46f, 0.228f)
                curveToRelative(-0.116f, 0f, -0.233f, -0.035f, -0.333f, -0.104f)
                lineToRelative(-0.692f, -0.479f)
                lineToRelative(-0.417f, -0.294f)
                lineToRelative(-0.65f, -0.452f)
                lineToRelative(-2.59f, -1.801f)
                curveToRelative(-0.255f, -0.178f, -0.321f, -0.526f, -0.154f, -0.785f)
                curveToRelative(0.003f, -0.008f, 0.008f, -0.011f, 0.011f, -0.019f)
                curveToRelative(0.167f, -0.24f, 0.476f, -0.314f, 0.731f, -0.193f)
                curveToRelative(0.027f, 0.015f, 0.05f, 0.027f, 0.077f, 0.046f)
                lineToRelative(2.096f, 1.457f)
                lineToRelative(1.036f, 0.723f)
                lineToRelative(1.218f, 0.846f)
                curveToRelative(0.051f, 0.036f, 0.093f, 0.078f, 0.128f, 0.124f)
                curveToRelative(0.008f, 0.01f, 0.015f, 0.019f, 0.023f, 0.031f)
                close()
            }
        }
        group("leg-r3", rotate = rotateR3.value, pivotX = 13.870f, 16.911f) {
            path(fill = SolidColor(Color(0xFF7D4C2E))) {
                moveToRelative(20.927f, 25.094f)
                curveToRelative(0.056f, 0f, 0.113f, -0.012f, 0.167f, -0.038f)
                curveToRelative(0.192f, -0.093f, 0.274f, -0.323f, 0.181f, -0.516f)
                lineToRelative(-1.133f, -2.36f)
                lineToRelative(-0.572f, -4.48f)
                curveToRelative(-0.027f, -0.212f, -0.221f, -0.358f, -0.433f, -0.334f)
                curveToRelative(-0.212f, 0.027f, -0.361f, 0.221f, -0.334f, 0.433f)
                lineToRelative(0.579f, 4.543f)
                curveToRelative(0.005f, 0.04f, 0.017f, 0.08f, 0.036f, 0.118f)
                lineToRelative(1.16f, 2.416f)
                curveToRelative(0.066f, 0.138f, 0.204f, 0.218f, 0.348f, 0.218f)
                close()
            }
            path(fill = SolidColor(Color(0xFF7D4C2E))) {
                moveToRelative(19.187f, 18.33f)
                curveToRelative(0.281f, 0f, 0.527f, -0.204f, 0.572f, -0.49f)
                curveToRelative(0.05f, -0.316f, -0.167f, -0.613f, -0.483f, -0.663f)
                lineToRelative(-4.744f, -0.746f)
                curveToRelative(-0.316f, -0.051f, -0.613f, 0.166f, -0.663f, 0.482f)
                curveToRelative(-0.05f, 0.316f, 0.167f, 0.614f, 0.483f, 0.663f)
                lineToRelative(4.744f, 0.746f)
                curveToRelative(0.031f, 0.004f, 0.061f, 0.007f, 0.091f, 0.007f)
                close()
            }
        }
        group("leg-r2", rotate = rotateR2.value, pivotX = 13.3f, 15.852f) {
            path(fill = SolidColor(Color(0xFF7D4C2E))) {
                moveToRelative(13.778f, 16.01f)
                curveToRelative(0.154f, 0f, 0.309f, -0.061f, 0.422f, -0.183f)
                lineToRelative(3.907f, -4.156f)
                curveToRelative(0.219f, -0.233f, 0.208f, -0.6f, -0.026f, -0.819f)
                curveToRelative(-0.234f, -0.22f, -0.601f, -0.209f, -0.82f, 0.025f)
                lineToRelative(-3.907f, 4.155f)
                curveToRelative(-0.219f, 0.234f, -0.208f, 0.601f, 0.025f, 0.82f)
                curveToRelative(0.113f, 0.106f, 0.255f, 0.157f, 0.398f, 0.157f)
                close()
            }
            path(fill = SolidColor(Color(0xFF7D4C2E))) {
                moveToRelative(17.685f, 11.662f)
                lineToRelative(5.272f, 0f)
                curveToRelative(0.083f, 0f, 0.164f, -0.027f, 0.232f, -0.078f)
                lineToRelative(1.16f, -0.87f)
                curveToRelative(0.171f, -0.128f, 0.205f, -0.37f, 0.077f, -0.541f)
                curveToRelative(-0.128f, -0.172f, -0.37f, -0.205f, -0.541f, -0.078f)
                lineToRelative(-1.057f, 0.792f)
                lineToRelative(-5.142f, 0f)
                curveToRelative(-0.214f, 0f, -0.386f, 0.173f, -0.386f, 0.386f)
                curveToRelative(-0.001f, 0.214f, 0.173f, 0.387f, 0.386f, 0.387f)
                close()
            }
        }
        group("leg-r1", rotate = rotateR1.value,  pivotX = 12.228f, 13.223f) {
            path(fill = SolidColor(Color(0xFF7D4C2E))) {
                moveToRelative(17.061f, 10.278f)
                curveToRelative(0.169f, 0f, 0.324f, -0.111f, 0.372f, -0.282f)
                lineToRelative(0.572f, -2.028f)
                lineToRelative(1.999f, -0.78f)
                curveToRelative(0.198f, -0.078f, 0.297f, -0.302f, 0.22f, -0.501f)
                curveToRelative(-0.078f, -0.198f, -0.303f, -0.297f, -0.501f, -0.219f)
                lineToRelative(-2.178f, 0.849f)
                curveToRelative(-0.113f, 0.044f, -0.199f, 0.139f, -0.232f, 0.256f)
                lineToRelative(-0.625f, 2.213f)
                curveToRelative(-0.058f, 0.205f, 0.062f, 0.42f, 0.267f, 0.477f)
                curveToRelative(0.036f, 0.01f, 0.07f, 0.015f, 0.105f, 0.015f)
                close()
            }
            path(fill = SolidColor(Color(0xFF7D4C2E))) {
                moveToRelative(12.228f, 12.598f)
                curveToRelative(0.039f, -0.06f, 0.09f, -0.114f, 0.152f, -0.157f)
                lineToRelative(4.349f, -3.026f)
                curveToRelative(0.264f, -0.183f, 0.625f, -0.117f, 0.807f, 0.145f)
                curveToRelative(0.184f, 0.262f, 0.119f, 0.624f, -0.144f, 0.807f)
                lineToRelative(-4.349f, 3.026f)
                curveToRelative(-0.102f, 0.07f, -0.216f, 0.104f, -0.331f, 0.104f)
                curveToRelative(-0.184f, 0f, -0.364f, -0.087f, -0.477f, -0.249f)
                curveToRelative(-0.003f, -0.004f, -0.005f, -0.009f, -0.008f, -0.012f)
                close()
            }
        }
        // antenna-l
        path(fill = SolidColor(Color(0xFF7D4C2E))) {
            moveToRelative(9.421f, 6.33f)
            curveToRelative(-0.038f, 0.011f, -0.077f, 0.015f, -0.115f, 0.015f)
            curveToRelative(-0.074f, 0f, -0.143f, -0.019f, -0.202f, -0.058f)
            curveToRelative(-0.077f, -0.05f, -0.139f, -0.123f, -0.166f, -0.216f)
            lineToRelative(-1.063f, -3.475f)
            lineToRelative(-2.049f, -1.929f)
            curveToRelative(-0.158f, -0.146f, -0.167f, -0.39f, -0.019f, -0.545f)
            curveToRelative(0.146f, -0.155f, 0.39f, -0.162f, 0.545f, -0.015f)
            lineToRelative(2.126f, 1.994f)
            curveToRelative(0.051f, 0.046f, 0.089f, 0.104f, 0.108f, 0.17f)
            lineToRelative(1.013f, 3.324f)
            lineToRelative(0.078f, 0.251f)
            curveToRelative(0.062f, 0.204f, -0.051f, 0.417f, -0.256f, 0.483f)
            close()
        }
        // antenna-r
        path(fill = SolidColor(Color(0xFF7D4C2E))) {
            moveToRelative(15.196f, 6.346f)
            curveToRelative(0.166f, 0f, 0.319f, -0.107f, 0.369f, -0.274f)
            lineToRelative(1.062f, -3.477f)
            lineToRelative(2.051f, -1.927f)
            curveToRelative(0.156f, -0.146f, 0.163f, -0.391f, 0.017f, -0.546f)
            curveToRelative(-0.146f, -0.156f, -0.392f, -0.163f, -0.546f, -0.016f)
            lineToRelative(-2.126f, 1.997f)
            curveToRelative(-0.049f, 0.046f, -0.085f, 0.104f, -0.105f, 0.169f)
            lineToRelative(-1.092f, 3.576f)
            curveToRelative(-0.062f, 0.204f, 0.054f, 0.42f, 0.257f, 0.483f)
            curveToRelative(0.037f, 0.011f, 0.075f, 0.016f, 0.113f, 0.016f)
            close()
        }
        path(fill = SolidColor(Color(0xFFAD7C5E))) {
            moveToRelative(17.226f, 25.45f)
            curveToRelative(-0.038f, 0.244f, -0.1f, 0.476f, -0.181f, 0.7f)
            curveToRelative(-0.205f, 0.61f, -0.53f, 1.151f, -0.913f, 1.624f)
            curveToRelative(-0.205f, 0.255f, -0.429f, 0.491f, -0.657f, 0.704f)
            curveToRelative(-1.164f, 1.078f, -2.559f, 1.666f, -3.201f, 1.801f)
            lineToRelative(0f, 0.011f)
            curveToRelative(-0.008f, 0f, -0.015f, -0.004f, -0.023f, -0.004f)
            curveToRelative(-0.008f, 0f, -0.016f, 0.004f, -0.023f, 0.004f)
            lineToRelative(0f, -0.011f)
            curveToRelative(-0.642f, -0.136f, -2.038f, -0.723f, -3.197f, -1.801f)
            curveToRelative(-0.232f, -0.213f, -0.452f, -0.449f, -0.657f, -0.704f)
            curveToRelative(-0.383f, -0.472f, -0.708f, -1.013f, -0.913f, -1.624f)
            curveToRelative(-0.081f, -0.224f, -0.143f, -0.456f, -0.181f, -0.7f)
            curveToRelative(-0.097f, -0.498f, -0.112f, -1.044f, -0.023f, -1.627f)
            curveToRelative(0.015f, -0.151f, 0.047f, -0.309f, 0.081f, -0.468f)
            curveToRelative(0.015f, -0.078f, 0.035f, -0.155f, 0.05f, -0.232f)
            curveToRelative(0.116f, -0.506f, 0.236f, -1.055f, 0.364f, -1.624f)
            curveToRelative(0.054f, -0.232f, 0.103f, -0.464f, 0.162f, -0.704f)
            curveToRelative(0.12f, -0.53f, 0.243f, -1.075f, 0.379f, -1.624f)
            curveToRelative(0.054f, -0.232f, 0.112f, -0.467f, 0.17f, -0.699f)
            curveToRelative(0.055f, -0.221f, 0.112f, -0.441f, 0.17f, -0.657f)
            curveToRelative(0.081f, -0.325f, 0.166f, -0.649f, 0.256f, -0.967f)
            curveToRelative(0.022f, -0.085f, 0.046f, -0.174f, 0.069f, -0.259f)
            curveToRelative(0.042f, -0.15f, 0.089f, -0.297f, 0.131f, -0.445f)
            curveToRelative(0.116f, -0.418f, 0.24f, -0.824f, 0.372f, -1.214f)
            curveToRelative(0.042f, -0.139f, 0.089f, -0.274f, 0.134f, -0.41f)
            curveToRelative(0.081f, -0.24f, 0.167f, -0.475f, 0.252f, -0.699f)
            curveToRelative(0.015f, -0.042f, 0.031f, -0.085f, 0.046f, -0.124f)
            curveToRelative(0.124f, -0.325f, 0.252f, -0.634f, 0.383f, -0.92f)
            curveToRelative(0.023f, -0.054f, 0.046f, -0.108f, 0.074f, -0.158f)
            curveToRelative(0.174f, -0.383f, 0.36f, -0.727f, 0.556f, -1.024f)
            curveToRelative(0.097f, -0.159f, 0.201f, -0.305f, 0.309f, -0.437f)
            curveToRelative(0.321f, -0.398f, 0.657f, -0.661f, 1.013f, -0.742f)
            lineToRelative(0f, -0.015f)
            curveToRelative(0.004f, 0f, 0.008f, 0.004f, 0.011f, 0.004f)
            curveToRelative(0.004f, 0f, 0.008f, 0.003f, 0.012f, 0.003f)
            curveToRelative(0.004f, 0f, 0.008f, -0.003f, 0.011f, -0.003f)
            curveToRelative(0.003f, 0f, 0.008f, -0.004f, 0.011f, -0.004f)
            lineToRelative(0f, 0.015f)
            curveToRelative(0.356f, 0.081f, 0.692f, 0.344f, 1.013f, 0.742f)
            curveToRelative(0.108f, 0.131f, 0.213f, 0.278f, 0.309f, 0.437f)
            curveToRelative(0.197f, 0.297f, 0.383f, 0.642f, 0.557f, 1.024f)
            curveToRelative(0.027f, 0.051f, 0.054f, 0.104f, 0.077f, 0.158f)
            curveToRelative(0.131f, 0.286f, 0.255f, 0.596f, 0.379f, 0.92f)
            curveToRelative(0.019f, 0.039f, 0.035f, 0.081f, 0.05f, 0.124f)
            curveToRelative(0.085f, 0.224f, 0.17f, 0.46f, 0.251f, 0.699f)
            curveToRelative(0.046f, 0.136f, 0.093f, 0.27f, 0.135f, 0.406f)
            curveToRelative(0.132f, 0.394f, 0.256f, 0.8f, 0.372f, 1.217f)
            curveToRelative(0.043f, 0.148f, 0.089f, 0.294f, 0.131f, 0.445f)
            curveToRelative(0.023f, 0.085f, 0.047f, 0.174f, 0.07f, 0.259f)
            curveToRelative(0.089f, 0.317f, 0.174f, 0.642f, 0.255f, 0.967f)
            curveToRelative(0.058f, 0.216f, 0.116f, 0.437f, 0.17f, 0.657f)
            curveToRelative(0.058f, 0.232f, 0.116f, 0.467f, 0.17f, 0.699f)
            curveToRelative(0.136f, 0.549f, 0.26f, 1.095f, 0.379f, 1.624f)
            curveToRelative(0.058f, 0.239f, 0.109f, 0.472f, 0.163f, 0.704f)
            curveToRelative(0.127f, 0.568f, 0.247f, 1.117f, 0.363f, 1.624f)
            curveToRelative(0.015f, 0.078f, 0.035f, 0.155f, 0.05f, 0.232f)
            curveToRelative(0.035f, 0.158f, 0.066f, 0.317f, 0.081f, 0.468f)
            curveToRelative(0.089f, 0.584f, 0.073f, 1.13f, -0.024f, 1.628f)
            close()
        }
        group("mandible-l") {
            path(fill = SolidColor(Color.LightGray)) {
                moveToRelative(11.613f, 1.823f)
                lineToRelative(0f, 5.872f)
                curveToRelative(-0.866f, -0.097f, -1.578f, -1.079f, -1.743f, -2.362f)
                curveToRelative(-0.023f, -0.185f, -0.034f, -0.379f, -0.034f, -0.577f)
                curveToRelative(-0.001f, -1.55f, 0.784f, -2.822f, 1.778f, -2.934f)
                close()
            }
        }
        group("mandible-r") {
            path(fill = SolidColor(Color.LightGray)) {
                moveToRelative(12.89f, 1.822f)
                curveToRelative(0.993f, 0.114f, 1.778f, 1.384f, 1.778f, 2.937f)
                curveToRelative(0f, 1.554f, -0.785f, 2.824f, -1.778f, 2.938f)
                close()
            }
        }
        path(fill = SolidColor(Color(0xFF9D6C4E))) {
            moveToRelative(15.804f, 7.892f)
            curveToRelative(0f, 1.132f, -0.557f, 2.138f, -1.415f, 2.752f)
            curveToRelative(-0.329f, 0.232f, -0.7f, 0.409f, -1.102f, 0.514f)
            curveToRelative(-0.275f, 0.078f, -0.568f, 0.116f, -0.866f, 0.116f)
            lineToRelative(-0.34f, 0f)
            curveToRelative(-0.297f, 0f, -0.591f, -0.038f, -0.866f, -0.116f)
            curveToRelative(-0.402f, -0.101f, -0.773f, -0.279f, -1.098f, -0.514f)
            curveToRelative(-0.858f, -0.615f, -1.419f, -1.62f, -1.419f, -2.752f)
            curveToRelative(0f, -0.58f, 0.147f, -1.125f, 0.405f, -1.605f)
            curveToRelative(0.136f, -0.251f, 0.302f, -0.483f, 0.495f, -0.692f)
            curveToRelative(0.085f, -0.092f, 0.174f, -0.181f, 0.27f, -0.262f)
            curveToRelative(0.209f, -0.181f, 0.44f, -0.337f, 0.692f, -0.464f)
            curveToRelative(0.325f, -0.162f, 0.677f, -0.275f, 1.051f, -0.325f)
            curveToRelative(0.151f, -0.023f, 0.309f, -0.035f, 0.467f, -0.035f)
            lineToRelative(0.34f, 0f)
            curveToRelative(0.159f, 0f, 0.317f, 0.012f, 0.467f, 0.035f)
            curveToRelative(0.376f, 0.05f, 0.727f, 0.163f, 1.052f, 0.325f)
            curveToRelative(0.251f, 0.127f, 0.483f, 0.283f, 0.692f, 0.464f)
            curveToRelative(0.097f, 0.081f, 0.186f, 0.17f, 0.27f, 0.262f)
            curveToRelative(0.193f, 0.209f, 0.359f, 0.441f, 0.495f, 0.692f)
            curveToRelative(0.26f, 0.48f, 0.407f, 1.025f, 0.407f, 1.605f)
            close()
        }
        path(fill = SolidColor(Color(0xFF5D2C10))) {
            moveToRelative(13.949f, 4.761f)
            curveToRelative(0f, 0.034f, -0.004f, 0.073f, -0.008f, 0.108f)
            curveToRelative(-0.05f, 0.402f, -0.395f, 0.711f, -0.815f, 0.711f)
            lineToRelative(-1.748f, 0f)
            curveToRelative(-0.417f, 0f, -0.761f, -0.309f, -0.815f, -0.711f)
            curveToRelative(-0.004f, -0.036f, -0.008f, -0.074f, -0.008f, -0.108f)
            curveToRelative(0f, -0.456f, 0.37f, -0.824f, 0.823f, -0.824f)
            lineToRelative(1.748f, 0f)
            curveToRelative(0.456f, 0f, 0.824f, 0.368f, 0.824f, 0.824f)
            close()
        }
        path(fill = SolidColor(Color(0xFF9D6C4E))) {
            moveToRelative(14.657f, 13.824f)
            lineToRelative(-2.383f, 0f)
            lineToRelative(-0.046f, 0f)
            lineToRelative(-2.383f, 0f)
            curveToRelative(-0.085f, 0.224f, -0.171f, 0.46f, -0.252f, 0.699f)
            lineToRelative(2.634f, 0f)
            lineToRelative(0.046f, 0f)
            lineToRelative(2.634f, 0f)
            curveToRelative(-0.081f, -0.24f, -0.166f, -0.475f, -0.251f, -0.699f)
            close()
        }
        path(fill = SolidColor(Color(0xFF9D6C4E))) {
            moveToRelative(15.618f, 16.849f)
            lineToRelative(-6.73f, 0f)
            curveToRelative(0.022f, -0.085f, 0.046f, -0.174f, 0.069f, -0.259f)
            curveToRelative(0.042f, -0.15f, 0.089f, -0.297f, 0.131f, -0.445f)
            lineToRelative(6.328f, 0f)
            curveToRelative(0.043f, 0.148f, 0.089f, 0.294f, 0.131f, 0.445f)
            curveToRelative(0.023f, 0.085f, 0.047f, 0.174f, 0.07f, 0.259f)
            close()
        }
        path(fill = SolidColor(Color(0xFF9D6C4E))) {
            moveToRelative(16.213f, 19.172f)
            lineToRelative(-7.92f, 0f)
            curveToRelative(0.054f, -0.232f, 0.112f, -0.467f, 0.17f, -0.699f)
            lineToRelative(7.581f, 0f)
            curveToRelative(0.057f, 0.231f, 0.115f, 0.467f, 0.169f, 0.699f)
            close()
        }
        path(fill = SolidColor(Color(0xFF9D6C4E))) {
            moveToRelative(16.755f, 21.499f)
            lineToRelative(-9.003f, 0f)
            curveToRelative(0.054f, -0.232f, 0.103f, -0.464f, 0.162f, -0.704f)
            lineToRelative(8.678f, 0f)
            curveToRelative(0.058f, 0.24f, 0.109f, 0.472f, 0.162f, 0.704f)
            close()
        }
        path(fill = SolidColor(Color(0xFF9D6C4E))) {
            moveToRelative(17.249f, 23.823f)
            lineToRelative(-9.993f, 0f)
            curveToRelative(0.015f, -0.151f, 0.047f, -0.309f, 0.081f, -0.468f)
            curveToRelative(0.015f, -0.078f, 0.035f, -0.155f, 0.05f, -0.232f)
            lineToRelative(9.731f, 0f)
            curveToRelative(0.015f, 0.078f, 0.035f, 0.155f, 0.05f, 0.232f)
            curveToRelative(0.035f, 0.158f, 0.066f, 0.317f, 0.081f, 0.468f)
            close()
        }
        path(fill = SolidColor(Color(0xFF9D6C4E))) {
            moveToRelative(17.226f, 25.45f)
            curveToRelative(-0.038f, 0.244f, -0.1f, 0.476f, -0.181f, 0.7f)
            lineToRelative(-9.583f, 0f)
            curveToRelative(-0.081f, -0.224f, -0.143f, -0.456f, -0.181f, -0.7f)
            close()
        }
        path(fill = SolidColor(Color(0xFF9D6C4E))) {
            moveToRelative(16.132f, 27.774f)
            curveToRelative(-0.205f, 0.255f, -0.429f, 0.491f, -0.657f, 0.704f)
            lineToRelative(-6.444f, 0f)
            curveToRelative(-0.232f, -0.213f, -0.452f, -0.449f, -0.657f, -0.704f)
            close()
        }
        path(fill = SolidColor(Color(0xFF7D4C2E))) {
            moveToRelative(14.91f, 11.662f)
            curveToRelative(0f, 0.181f, -0.038f, 0.352f, -0.108f, 0.506f)
            curveToRelative(-0.112f, 0.263f, -0.317f, 0.479f, -0.572f, 0.611f)
            curveToRelative(-0.15f, 0.078f, -0.317f, 0.123f, -0.495f, 0.136f)
            curveToRelative(-0.027f, 0.004f, -0.054f, 0.004f, -0.081f, 0.004f)
            lineToRelative(-2.803f, 0f)
            curveToRelative(-0.027f, 0f, -0.058f, 0f, -0.085f, -0.004f)
            curveToRelative(-0.178f, -0.012f, -0.344f, -0.058f, -0.491f, -0.136f)
            curveToRelative(-0.255f, -0.132f, -0.46f, -0.348f, -0.577f, -0.611f)
            curveToRelative(-0.066f, -0.154f, -0.104f, -0.325f, -0.104f, -0.506f)
            curveToRelative(0f, -0.298f, 0.104f, -0.573f, 0.275f, -0.789f)
            curveToRelative(0.073f, -0.085f, 0.155f, -0.167f, 0.247f, -0.228f)
            curveToRelative(0.205f, -0.151f, 0.46f, -0.239f, 0.735f, -0.239f)
            lineToRelative(2.803f, 0f)
            curveToRelative(0.274f, 0f, 0.53f, 0.089f, 0.735f, 0.239f)
            curveToRelative(0.089f, 0.061f, 0.174f, 0.143f, 0.243f, 0.228f)
            curveToRelative(0.173f, 0.216f, 0.277f, 0.491f, 0.277f, 0.789f)
            close()
        }
    }.build()
}