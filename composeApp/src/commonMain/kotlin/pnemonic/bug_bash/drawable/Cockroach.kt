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
import pnemonic.bug_bash.model.bug.Cockroach
import pnemonic.stateOf

private const val durationLeg = 300

@Composable
fun cockroach(bug: Cockroach): ImageVector = cockroach(bug.isStopped)

@Composable
fun cockroach(stopped: Boolean = false): ImageVector {
    val rotateL1: State<Float>
    val rotateL2: State<Float>
    val rotateL3: State<Float>
    val rotateR1: State<Float>
    val rotateR2: State<Float>
    val rotateR3: State<Float>

    if (stopped) {
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
        name = "Cockroach",
        defaultWidth = 24.dp,
        defaultHeight = 35.dp,
        viewportWidth = 24f,
        viewportHeight = 35f
    ).apply {
        group(name = "leg-r2", rotate = rotateR2.value, pivotX = 15.884f, pivotY = 16.481f) {
            path(fill = SolidColor(Color(0xFF8B5E3C))) {
                moveToRelative(20.941f, 18.669f)
                curveToRelative(-0.103f, 0.104f, -0.27f, 0.104f, -0.373f, -0f)
                lineToRelative(-3.449f, -3.447f)
                curveToRelative(-0.103f, -0.104f, -0.103f, -0.27f, 0f, -0.373f)
                lineToRelative(0f, -0f)
                curveToRelative(0.103f, -0.103f, 0.27f, -0.103f, 0.373f, -0f)
                lineToRelative(3.448f, 3.448f)
                curveToRelative(0.102f, 0.103f, 0.102f, 0.27f, -0f, 0.373f)
                lineToRelative(0f, -0f)
            }
            path(fill = SolidColor(Color(0xFF8B5E3C))) {
                moveToRelative(17.707f, 14.659f)
                curveToRelative(0.203f, 0.203f, 0.203f, 0.532f, 0f, 0.736f)
                lineToRelative(-1.087f, 1.086f)
                curveToRelative(-0.203f, 0.203f, -0.533f, 0.203f, -0.736f, -0f)
                lineToRelative(0f, -0f)
                curveToRelative(-0.203f, -0.203f, -0.203f, -0.533f, 0f, -0.736f)
                lineToRelative(1.087f, -1.086f)
                curveToRelative(0.203f, -0.203f, 0.533f, -0.203f, 0.736f, -0f)
                lineToRelative(0f, -0f)
            }
            path(fill = SolidColor(Color(0xFF8B5E3C))) {
                moveToRelative(23.965f, 18.508f)
                curveToRelative(0f, 0.088f, -0.071f, 0.158f, -0.159f, 0.158f)
                lineToRelative(-2.942f, -0f)
                curveToRelative(-0.088f, -0f, -0.159f, -0.07f, -0.159f, -0.158f)
                lineToRelative(0f, -0f)
                curveToRelative(0f, -0.089f, 0.071f, -0.159f, 0.159f, -0.159f)
                lineToRelative(2.942f, -0f)
                curveToRelative(0.088f, -0f, 0.159f, 0.07f, 0.159f, 0.159f)
                lineToRelative(0f, -0f)
            }
        }
        group("leg-l2", rotate = rotateL2.value, pivotX = 8.080f, pivotY = 16.481f) {
            path(fill = SolidColor(Color(0xFF8B5E3C))) {
                moveToRelative(3.024f, 18.669f)
                curveToRelative(0.103f, 0.104f, 0.269f, 0.104f, 0.373f, -0f)
                lineToRelative(3.448f, -3.447f)
                curveToRelative(0.103f, -0.104f, 0.103f, -0.27f, 0f, -0.373f)
                lineToRelative(0f, -0f)
                curveToRelative(-0.103f, -0.103f, -0.27f, -0.103f, -0.373f, -0f)
                lineToRelative(-3.449f, 3.448f)
                curveToRelative(-0.103f, 0.103f, -0.103f, 0.27f, 0.001f, 0.373f)
                lineToRelative(0f, -0f)
            }
            path(fill = SolidColor(Color(0xFF8B5E3C))) {
                moveToRelative(6.257f, 14.659f)
                curveToRelative(-0.203f, 0.203f, -0.203f, 0.532f, 0f, 0.736f)
                lineToRelative(1.087f, 1.086f)
                curveToRelative(0.203f, 0.203f, 0.532f, 0.203f, 0.736f, -0f)
                lineToRelative(0f, -0f)
                curveToRelative(0.203f, -0.203f, 0.203f, -0.533f, 0f, -0.736f)
                lineToRelative(-1.087f, -1.086f)
                curveToRelative(-0.203f, -0.203f, -0.533f, -0.203f, -0.736f, -0f)
                lineToRelative(0f, -0f)
            }
            path(fill = SolidColor(Color(0xFF8B5E3C))) {
                moveToRelative(3.26f, 18.508f)
                curveToRelative(0f, 0.088f, -0.071f, 0.158f, -0.159f, 0.158f)
                lineTo(0.159f, 18.666f)
                curveToRelative(-0.088f, -0f, -0.159f, -0.07f, -0.159f, -0.158f)
                lineToRelative(0f, -0f)
                curveToRelative(0f, -0.089f, 0.071f, -0.159f, 0.159f, -0.159f)
                lineToRelative(2.942f, -0f)
                curveToRelative(0.088f, -0f, 0.159f, 0.07f, 0.159f, 0.159f)
                lineToRelative(0f, -0f)
            }
        }
        group("leg-r3", rotate = rotateR3.value, pivotX = 16.102f, pivotY = 22.122f) {
            path(fill = SolidColor(Color(0xFF8B5E3C))) {
                moveToRelative(18.847f, 28.957f)
                curveToRelative(-0.17f, -0f, -0.308f, -0.138f, -0.308f, -0.306f)
                lineToRelative(0f, -6.529f)
                curveToRelative(0f, -0.17f, 0.138f, -0.309f, 0.308f, -0.309f)
                lineToRelative(0f, -0f)
                curveToRelative(0.171f, -0f, 0.308f, 0.139f, 0.308f, 0.309f)
                lineToRelative(0f, 6.529f)
                curveToRelative(0f, 0.168f, -0.138f, 0.306f, -0.308f, 0.306f)
                lineToRelative(0f, -0f)
            }
            path(fill = SolidColor(Color(0xFF8B5E3C))) {
                moveToRelative(19.155f, 22.122f)
                curveToRelative(0f, 0.341f, -0.276f, 0.616f, -0.616f, 0.616f)
                lineToRelative(-1.821f, -0f)
                curveToRelative(-0.341f, -0f, -0.617f, -0.276f, -0.617f, -0.616f)
                lineToRelative(0f, -0f)
                curveToRelative(0f, -0.341f, 0.276f, -0.616f, 0.617f, -0.616f)
                lineToRelative(1.821f, -0f)
                curveToRelative(0.34f, -0f, 0.616f, 0.275f, 0.616f, 0.616f)
                lineToRelative(0f, -0f)
            }
            path(fill = SolidColor(Color(0xFF8B5E3C))) {
                moveToRelative(22.437f, 32.22f)
                curveToRelative(-0.103f, 0.102f, -0.269f, 0.102f, -0.373f, -0f)
                lineToRelative(-3.448f, -3.449f)
                curveToRelative(-0.103f, -0.102f, -0.103f, -0.269f, 0f, -0.372f)
                lineToRelative(0f, -0f)
                curveToRelative(0.103f, -0.102f, 0.27f, -0.102f, 0.373f, -0f)
                lineToRelative(3.448f, 3.449f)
                curveToRelative(0.103f, 0.103f, 0.103f, 0.269f, -0f, 0.373f)
                lineToRelative(0f, -0f)
            }
        }
        group("leg-l3", rotate = rotateL3.value, pivotX = 7.864f, pivotY = 22.122f) {
            path(fill = SolidColor(Color(0xFF8B5E3C))) {
                moveToRelative(5.118f, 28.957f)
                curveToRelative(-0.17f, -0f, -0.308f, -0.138f, -0.308f, -0.306f)
                lineToRelative(0f, -6.529f)
                curveToRelative(0f, -0.17f, 0.138f, -0.309f, 0.308f, -0.309f)
                lineToRelative(0f, -0f)
                curveToRelative(0.171f, -0f, 0.309f, 0.139f, 0.309f, 0.309f)
                lineToRelative(0f, 6.529f)
                curveToRelative(0f, 0.168f, -0.138f, 0.306f, -0.309f, 0.306f)
                lineToRelative(0f, -0f)
            }
            path(fill = SolidColor(Color(0xFF8B5E3C))) {
                moveToRelative(7.864f, 22.122f)
                curveToRelative(0f, 0.341f, -0.276f, 0.616f, -0.617f, 0.616f)
                lineToRelative(-1.82f, -0f)
                curveToRelative(-0.34f, -0f, -0.617f, -0.276f, -0.617f, -0.616f)
                lineToRelative(0f, -0f)
                curveToRelative(0f, -0.341f, 0.276f, -0.616f, 0.617f, -0.616f)
                lineToRelative(1.82f, -0f)
                curveToRelative(0.341f, -0f, 0.617f, 0.275f, 0.617f, 0.616f)
                lineToRelative(0f, -0f)
            }
            path(fill = SolidColor(Color(0xFF8B5E3C))) {
                moveToRelative(1.528f, 32.219f)
                curveToRelative(0.103f, 0.103f, 0.269f, 0.103f, 0.373f, -0f)
                lineToRelative(3.448f, -3.448f)
                curveToRelative(0.103f, -0.103f, 0.103f, -0.27f, 0f, -0.372f)
                lineToRelative(0f, -0f)
                curveToRelative(-0.103f, -0.104f, -0.27f, -0.104f, -0.373f, -0.002f)
                lineToRelative(-3.448f, 3.449f)
                curveToRelative(-0.103f, 0.103f, -0.103f, 0.27f, 0f, 0.373f)
                lineToRelative(0f, -0f)
            }
        }
        group("leg-l1", rotate = rotateL1.value, pivotX = 9.582f, pivotY = 11.424f) {
            path(fill = SolidColor(Color(0xFF8B5E3C))) {
                moveToRelative(2.736f, 7.684f)
                curveToRelative(0f, -0.087f, 0.072f, -0.158f, 0.159f, -0.158f)
                lineToRelative(2.942f, -0f)
                curveToRelative(0.088f, -0f, 0.159f, 0.071f, 0.159f, 0.158f)
                lineToRelative(0f, -0f)
                curveToRelative(0f, 0.089f, -0.071f, 0.161f, -0.159f, 0.161f)
                lineToRelative(-2.942f, -0.002f)
                curveToRelative(-0.088f, 0.002f, -0.159f, -0.07f, -0.159f, -0.159f)
                lineToRelative(0f, -0f)
            }
            path(fill = SolidColor(Color(0xFF8B5E3C))) {
                moveToRelative(5.761f, 7.604f)
                curveToRelative(0.103f, -0.103f, 0.27f, -0.103f, 0.373f, -0f)
                lineToRelative(3.448f, 3.447f)
                curveToRelative(0.103f, 0.104f, 0.103f, 0.27f, 0f, 0.373f)
                lineToRelative(0f, -0f)
                curveToRelative(-0.103f, 0.104f, -0.27f, 0.104f, -0.373f, -0f)
                lineToRelative(-3.448f, -3.448f)
                curveToRelative(-0.102f, -0.103f, -0.102f, -0.27f, 0f, -0.372f)
                lineToRelative(0f, -0f)
            }
        }
        group("leg-r1", rotate = rotateR1.value, pivotX = 14.384f, pivotY = 11.424f) {
            path(fill = SolidColor(Color(0xFF8B5E3C))) {
                moveToRelative(17.968f, 7.684f)
                curveToRelative(0f, -0.087f, 0.071f, -0.158f, 0.159f, -0.158f)
                lineToRelative(2.942f, -0f)
                curveToRelative(0.087f, -0f, 0.159f, 0.071f, 0.159f, 0.158f)
                lineToRelative(0f, -0f)
                curveToRelative(0f, 0.089f, -0.072f, 0.161f, -0.159f, 0.161f)
                lineToRelative(-2.942f, -0.002f)
                curveToRelative(-0.088f, 0.002f, -0.159f, -0.07f, -0.159f, -0.159f)
                lineToRelative(0f, -0f)
            }
            path(fill = SolidColor(Color(0xFF8B5E3C))) {
                moveToRelative(18.204f, 7.604f)
                curveToRelative(-0.103f, -0.103f, -0.269f, -0.103f, -0.372f, -0f)
                lineToRelative(-3.448f, 3.447f)
                curveToRelative(-0.103f, 0.104f, -0.103f, 0.27f, 0f, 0.373f)
                lineToRelative(0f, -0f)
                curveToRelative(0.103f, 0.104f, 0.27f, 0.104f, 0.373f, -0f)
                lineToRelative(3.449f, -3.448f)
                curveToRelative(0.103f, -0.103f, 0.103f, -0.27f, -0.001f, -0.372f)
                lineToRelative(0f, -0f)
            }
        }
        path(fill = SolidColor(Color(0xFF8B5E3C))) {
            moveToRelative(10.598f, 10.171f)
            curveToRelative(-0.138f, -0f, -0.248f, -0.112f, -0.248f, -0.248f)
            curveToRelative(0f, -5.197f, -4.228f, -9.425f, -9.425f, -9.425f)
            curveToRelative(-0.137f, -0f, -0.249f, -0.111f, -0.249f, -0.249f)
            curveToRelative(0f, -0.138f, 0.111f, -0.249f, 0.249f, -0.249f)
            curveToRelative(5.471f, -0f, 9.922f, 4.451f, 9.922f, 9.922f)
            curveToRelative(0f, 0.137f, -0.111f, 0.248f, -0.249f, 0.248f)
        }
        path(fill = SolidColor(Color(0xFF8B5E3C))) {
            moveToRelative(13.367f, 10.171f)
            curveToRelative(-0.138f, -0f, -0.249f, -0.112f, -0.249f, -0.248f)
            curveToRelative(0f, -5.472f, 4.451f, -9.922f, 9.922f, -9.922f)
            curveToRelative(0.137f, -0f, 0.249f, 0.111f, 0.249f, 0.249f)
            curveToRelative(0f, 0.138f, -0.112f, 0.249f, -0.249f, 0.249f)
            curveToRelative(-5.197f, -0f, -9.424f, 4.228f, -9.424f, 9.425f)
            curveToRelative(0f, 0.137f, -0.111f, 0.248f, -0.249f, 0.248f)
        }
        path(fill = SolidColor(Color(0xFFA97C50))) {
            moveToRelative(14.988f, 33.069f)
            curveToRelative(0.828f, -2.563f, 1.834f, -6.53f, 1.834f, -10.353f)
            curveToRelative(0f, -3.293f, -0.378f, -6.327f, -1.012f, -8.744f)
            curveToRelative(-0.885f, -3.372f, -2.27f, -4.547f, -3.827f, -4.547f)
            curveToRelative(-1.589f, -0f, -3f, 1.267f, -3.882f, 4.759f)
            curveToRelative(-0.602f, 2.38f, -0.957f, 5.334f, -0.957f, 8.532f)
            curveToRelative(0f, 3.823f, 1.006f, 7.789f, 1.834f, 10.353f)
            curveToRelative(0.422f, 1.307f, 1.573f, 1.796f, 2.946f, 1.796f)
            lineToRelative(0.118f, -0f)
            curveToRelative(1.374f, -0f, 2.524f, -0.489f, 2.946f, -1.796f)
        }
        path(fill = SolidColor(Color(0xFFC67F3E))) {
            moveToRelative(14.764f, 31.309f)
            curveToRelative(0.766f, -2.372f, 1.697f, -6.044f, 1.697f, -9.582f)
            curveToRelative(0f, -3.048f, -0.349f, -5.856f, -0.937f, -8.093f)
            curveToRelative(-0.819f, -3.121f, -2.101f, -4.208f, -3.542f, -4.208f)
            curveToRelative(-1.471f, -0f, -2.777f, 1.172f, -3.593f, 4.405f)
            curveToRelative(-0.557f, 2.203f, -0.886f, 4.937f, -0.886f, 7.897f)
            curveToRelative(0f, 3.538f, 0.931f, 7.21f, 1.697f, 9.582f)
            curveToRelative(0.391f, 1.21f, 1.456f, 1.663f, 2.727f, 1.663f)
            lineToRelative(0.109f, -0f)
            curveToRelative(1.272f, -0f, 2.336f, -0.453f, 2.727f, -1.663f)
        }
        path(fill = SolidColor(Color(0xFF8B5E3C))) {
            moveToRelative(11.983f, 9.425f)
            lineToRelative(-0f, -0f)
            lineToRelative(0f, 25.44f)
            lineToRelative(0.059f, -0f)
            curveToRelative(1.374f, -0f, 2.524f, -0.489f, 2.946f, -1.796f)
            curveToRelative(0.828f, -2.563f, 1.834f, -6.53f, 1.834f, -10.353f)
            curveToRelative(0f, -3.293f, -0.378f, -6.327f, -1.012f, -8.744f)
            curveToRelative(-0.885f, -3.372f, -2.27f, -4.547f, -3.827f, -4.547f)
        }
        path(fill = SolidColor(Color(0xFFB26A2F))) {
            moveToRelative(11.982f, 32.972f)
            lineToRelative(0.055f, -0f)
            curveToRelative(1.272f, -0f, 2.336f, -0.453f, 2.727f, -1.663f)
            curveToRelative(0.766f, -2.372f, 1.697f, -6.044f, 1.697f, -9.582f)
            curveToRelative(0f, -3.048f, -0.349f, -5.856f, -0.937f, -8.093f)
            curveToRelative(-0.768f, -2.926f, -1.943f, -4.065f, -3.274f, -4.196f)
            curveToRelative(-0.089f, -0.008f, -0.178f, -0.013f, -0.268f, -0.013f)
            curveToRelative(-0f, -0f, -0f, -0f, -0f, -0f)
            lineToRelative(-0f, 23.547f)
        }
        path(fill = SolidColor(Color(0xFF513118))) {
            moveToRelative(8.101f, 14.184f)
            curveToRelative(-0.06f, 0.236f, -0.115f, 0.482f, -0.17f, 0.729f)
            curveToRelative(1.205f, 0.656f, 2.582f, 1.036f, 4.052f, 1.036f)
            curveToRelative(1.47f, -0f, 2.848f, -0.381f, 4.054f, -1.038f)
            curveToRelative(-0.071f, -0.323f, -0.147f, -0.636f, -0.227f, -0.94f)
            curveToRelative(-0.885f, -3.372f, -2.27f, -4.547f, -3.827f, -4.547f)
            curveToRelative(-0.099f, -0f, -0.198f, 0.005f, -0.296f, 0.015f)
            curveToRelative(-1.468f, 0.152f, -2.759f, 1.47f, -3.586f, 4.745f)
        }
        path(fill = SolidColor(Color(0xFF8B5E3C))) {
            moveToRelative(11.983f, 15.569f)
            curveToRelative(1.441f, -0f, 2.79f, -0.386f, 3.959f, -1.052f)
            curveToRelative(-0.043f, -0.183f, -0.085f, -0.369f, -0.132f, -0.545f)
            curveToRelative(-0.885f, -3.372f, -2.27f, -4.547f, -3.827f, -4.547f)
            curveToRelative(-1.589f, -0f, -3f, 1.267f, -3.882f, 4.759f)
            curveToRelative(-0.027f, 0.108f, -0.051f, 0.222f, -0.077f, 0.333f)
            curveToRelative(1.168f, 0.666f, 2.518f, 1.052f, 3.959f, 1.052f)
        }
        path(fill = SolidColor(Color(0xFF754C29))) {
            moveToRelative(11.983f, 9.425f)
            lineToRelative(-0f, -0f)
            lineToRelative(0f, 6.144f)
            lineToRelative(0f, -0f)
            curveToRelative(1.441f, -0f, 2.79f, -0.386f, 3.959f, -1.052f)
            curveToRelative(-0.043f, -0.183f, -0.085f, -0.369f, -0.132f, -0.545f)
            curveToRelative(-0.885f, -3.372f, -2.27f, -4.547f, -3.827f, -4.547f)
        }
        path(fill = SolidColor(Color(0xFF8B5E3C))) {
            moveToRelative(8.946f, 32.972f)
            curveToRelative(0.01f, 0.032f, 0.02f, 0.066f, 0.031f, 0.097f)
            curveToRelative(0.422f, 1.307f, 1.573f, 1.796f, 2.946f, 1.796f)
            lineToRelative(0.118f, -0f)
            curveToRelative(1.374f, -0f, 2.524f, -0.489f, 2.946f, -1.796f)
            curveToRelative(0.011f, -0.031f, 0.02f, -0.065f, 0.031f, -0.097f)
            lineTo(8.946f, 32.972f)
        }
        path(fill = SolidColor(Color(0xFF754C29))) {
            moveToRelative(11.982f, 32.972f)
            lineToRelative(0f, 1.893f)
            lineToRelative(0.059f, -0f)
            curveToRelative(1.374f, -0f, 2.524f, -0.489f, 2.946f, -1.796f)
            curveToRelative(0.011f, -0.031f, 0.02f, -0.065f, 0.031f, -0.097f)
            lineTo(11.982f, 32.972f)
        }
        path(fill = SolidColor(Color(0xFF754C29))) {
            moveToRelative(10.919f, 14.579f)
            curveToRelative(0f, 0.291f, -0.235f, 0.526f, -0.526f, 0.526f)
            lineToRelative(0f, -0f)
            curveToRelative(-0.29f, -0f, -0.526f, -0.235f, -0.526f, -0.526f)
            lineToRelative(0f, -3.579f)
            curveToRelative(0f, -0.29f, 0.236f, -0.526f, 0.526f, -0.526f)
            lineToRelative(0f, -0f)
            curveToRelative(0.291f, -0f, 0.526f, 0.236f, 0.526f, 0.526f)
            lineTo(10.919f, 14.579f)
        }
        path(fill = SolidColor(Color(0xFF513118))) {
            moveToRelative(14.098f, 14.579f)
            curveToRelative(0f, 0.291f, -0.236f, 0.526f, -0.526f, 0.526f)
            lineToRelative(0f, -0f)
            curveToRelative(-0.29f, -0f, -0.526f, -0.235f, -0.526f, -0.526f)
            lineToRelative(0f, -3.579f)
            curveToRelative(0f, -0.29f, 0.236f, -0.526f, 0.526f, -0.526f)
            lineToRelative(0f, -0f)
            curveToRelative(0.291f, -0f, 0.526f, 0.236f, 0.526f, 0.526f)
            lineTo(14.098f, 14.579f)
        }
    }.build()
}
