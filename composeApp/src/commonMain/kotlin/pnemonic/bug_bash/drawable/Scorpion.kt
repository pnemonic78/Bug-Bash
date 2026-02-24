package pnemonic.bug_bash.drawable

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.StartOffset
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
import pnemonic.bug_bash.model.bug.Scorpion
import pnemonic.stateOf

private const val durationClaw = 700
private const val durationLeg = 1000
private const val offsetLeg = 200
private const val durationTail = 1500

@Composable
fun scorpion(bug: Scorpion): ImageVector = scorpion(bug.isSquashed)

@Composable
fun scorpion(squashed: Boolean = false): ImageVector {
    val rotateCL: State<Float>
    val rotateCR: State<Float>
    val rotateT: State<Float>
    val rotateL1: State<Float>
    val rotateL2: State<Float>
    val rotateL3: State<Float>
    val rotateL4: State<Float>
    val rotateR1: State<Float>
    val rotateR2: State<Float>
    val rotateR3: State<Float>
    val rotateR4: State<Float>

    if (squashed) {
        rotateCL = stateOf(0f)
        rotateCR = rotateCL
        rotateT = rotateCL
        rotateL1 = stateOf(0f)
        rotateL2 = rotateL1
        rotateL3 = rotateL1
        rotateL4 = rotateL1
        rotateR1 = rotateL1
        rotateR2 = rotateL1
        rotateR3 = rotateL1
        rotateR4 = rotateL1
    } else {
        val transition = rememberInfiniteTransition()
        rotateCL = transition.animateFloat(
            initialValue = 0f,
            targetValue = 30f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationClaw
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        rotateCR = transition.animateFloat(
            initialValue = 0f,
            targetValue = -30f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationClaw,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        rotateT = transition.animateFloat(
            initialValue = 30f,
            targetValue = -45f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationTail,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        rotateL1 = transition.animateFloat(
            initialValue = -15f,
            targetValue = 15f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationLeg,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse,
                initialStartOffset = StartOffset(offsetLeg * 0)
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
                repeatMode = RepeatMode.Reverse,
                initialStartOffset = StartOffset(offsetLeg * 1)
            )
        )
        rotateL3 = transition.animateFloat(
            initialValue = -15f,
            targetValue = 15f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationLeg,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse,
                initialStartOffset = StartOffset(offsetLeg * 2)
            )
        )
        rotateL4 = transition.animateFloat(
            initialValue = -5f,
            targetValue = 30f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationLeg,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse,
                initialStartOffset = StartOffset(offsetLeg * 3)
            )
        )
        rotateR1 = transition.animateFloat(
            initialValue = 15f,
            targetValue = -15f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationLeg,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse,
                initialStartOffset = StartOffset(offsetLeg * 2)
            )
        )
        rotateR2 = transition.animateFloat(
            initialValue = 15f,
            targetValue = -15f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationLeg,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse,
                initialStartOffset = StartOffset(offsetLeg * 3)
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
                repeatMode = RepeatMode.Reverse,
                initialStartOffset = StartOffset(offsetLeg * 4)
            )
        )
        rotateR4 = transition.animateFloat(
            initialValue = 5f,
            targetValue = -30f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationLeg,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse,
                initialStartOffset = StartOffset(offsetLeg * 0)
            )
        )
    }

    return ImageVector.Builder(
        name = "Scorpion",
        defaultWidth = 37.8.dp,
        defaultHeight = 50.dp,
        viewportWidth = 37.8f,
        viewportHeight = 50f
    ).apply {
        group("tail", rotate = rotateT.value, pivotX = 18.464f, pivotY = 34.467f) {
            path(fill = SolidColor(Color(0xFF4F3E26))) {
                moveToRelative(28.4f, 45.648f)
                curveToRelative(0.012f, 0.185f, -0.078f, 0.389f, 0.035f, 0.563f)
                curveToRelative(0.115f, 0.23f, 0.445f, 0.304f, 0.638f, 0.126f)
                curveToRelative(0.249f, -0.175f, 0.493f, -0.447f, 0.428f, -0.776f)
                curveToRelative(0.017f, -0.255f, 0.218f, -0.48f, 0.137f, -0.745f)
                curveToRelative(-0.046f, -0.578f, -0.413f, -1.069f, -0.842f, -1.432f)
                curveToRelative(-0.396f, -0.34f, -0.91f, -0.496f, -1.422f, -0.544f)
                curveToRelative(-0.574f, -0.067f, -1.182f, -0.123f, -1.67f, -0.466f)
                curveToRelative(-0.375f, -0.23f, -0.773f, -0.585f, -0.746f, -1.066f)
                curveToRelative(0.033f, -0.244f, -0.062f, 0.199f, -0.092f, 0.285f)
                curveToRelative(-0.156f, 0.635f, 0.167f, 1.277f, 0.58f, 1.743f)
                curveToRelative(0.622f, 0.704f, 1.551f, 1.027f, 2.187f, 1.715f)
                curveToRelative(0.173f, 0.186f, 0.376f, 0.342f, 0.612f, 0.44f)
                curveToRelative(0.064f, 0.037f, 0.131f, 0.083f, 0.156f, 0.155f)
                close()
            }
            path(fill = SolidColor(Color(0xFF443421))) {
                moveToRelative(28.688f, 46.336f)
                curveToRelative(-0.285f, -0.066f, -0.179f, -0.444f, -0.421f, -0.539f)
                curveToRelative(-0.307f, -0.107f, -0.641f, -0.073f, -0.959f, -0.122f)
                curveToRelative(-0.43f, -0.048f, -0.863f, -0.063f, -1.294f, -0.083f)
                curveToRelative(-0.864f, -0.163f, -1.756f, -0.095f, -2.611f, 0.091f)
                curveToRelative(-0.379f, 0.102f, -0.765f, 0.196f, -1.131f, 0.338f)
                curveToRelative(-0.273f, 0.199f, -0.486f, 0.508f, -0.544f, 0.844f)
                curveToRelative(-0.028f, 0.315f, 0.308f, 0.478f, 0.562f, 0.555f)
                curveToRelative(0.887f, 0.25f, 1.824f, 0.226f, 2.735f, 0.163f)
                curveToRelative(1.164f, -0.129f, 2.361f, -0.239f, 3.438f, -0.735f)
                curveToRelative(0.162f, -0.078f, 0.587f, -0.273f, 0.331f, -0.465f)
                curveToRelative(-0.034f, -0.019f, -0.07f, -0.034f, -0.107f, -0.046f)
                close()
            }
            path(fill = SolidColor(Color(0xFF4F3E26))) {
                moveToRelative(20.215f, 43.174f)
                curveToRelative(0.19f, -0.027f, 0.365f, 0.058f, 0.467f, 0.22f)
                curveToRelative(0.537f, 0.518f, 0.842f, 1.209f, 1.235f, 1.83f)
                curveToRelative(0.134f, 0.234f, 0.292f, 0.458f, 0.397f, 0.707f)
                curveToRelative(-0.013f, 0.183f, -0.241f, 0.251f, -0.286f, 0.429f)
                curveToRelative(-0.134f, 0.235f, -0.244f, 0.484f, -0.377f, 0.719f)
                curveToRelative(-0.125f, 0.188f, -0.351f, 0.049f, -0.492f, -0.04f)
                curveToRelative(-0.171f, -0.136f, -0.301f, -0.317f, -0.455f, -0.472f)
                curveToRelative(-0.462f, -0.531f, -0.854f, -1.118f, -1.255f, -1.695f)
                curveToRelative(-0.137f, -0.239f, -0.27f, -0.479f, -0.423f, -0.707f)
                curveToRelative(-0.072f, -0.157f, -0.097f, -0.348f, -0.056f, -0.515f)
                curveToRelative(0.121f, -0.199f, 0.373f, -0.249f, 0.58f, -0.316f)
                curveToRelative(0.22f, -0.061f, 0.444f, -0.107f, 0.666f, -0.16f)
                close()
            }
            path(fill = SolidColor(Color(0xFF443421))) {
                moveToRelative(19.692f, 40.095f)
                curveToRelative(0.19f, -0.01f, 0.944f, 2.854f, 0.824f, 2.982f)
                curveToRelative(-0.285f, 0.305f, -0.596f, 0.697f, -1.081f, 0.566f)
                curveToRelative(-0.262f, -0.071f, -0.556f, -0.078f, -0.748f, -0.253f)
                curveToRelative(-0.102f, -0.092f, -0.246f, -0.321f, -0.299f, -0.44f)
                curveToRelative(-0.102f, -0.23f, -0.19f, -0.469f, -0.271f, -0.706f)
                curveToRelative(-0.149f, -0.437f, -0.364f, -0.97f, -0.35f, -1.437f)
                curveToRelative(0.003f, -0.103f, 0.029f, -0.303f, 0.082f, -0.395f)
                curveToRelative(0.043f, -0.076f, 0.079f, -0.087f, 0.173f, -0.108f)
                curveToRelative(0.303f, -0.069f, 0.818f, -0.112f, 1.67f, -0.208f)
                close()
            }
            path(fill = SolidColor(Color(0xFF4F3E26))) {
                moveToRelative(18.967f, 37.12f)
                curveToRelative(0.185f, 0.033f, 0.384f, 0.03f, 0.554f, 0.117f)
                curveToRelative(0.115f, 0.117f, 0.089f, 0.301f, 0.131f, 0.45f)
                curveToRelative(0.079f, 0.373f, 0.187f, 0.741f, 0.212f, 1.123f)
                curveToRelative(0.009f, 0.312f, 0.185f, 0.629f, 0.06f, 0.936f)
                curveToRelative(-0.131f, 0.288f, -0.361f, 0.518f, -0.59f, 0.731f)
                curveToRelative(-0.172f, 0.158f, -0.419f, 0.116f, -0.629f, 0.092f)
                curveToRelative(-0.324f, -0.032f, -0.675f, -0.087f, -0.925f, -0.313f)
                curveToRelative(-0.161f, -0.175f, -0.16f, -0.428f, -0.227f, -0.644f)
                curveToRelative(-0.14f, -0.582f, -0.269f, -1.168f, -0.358f, -1.76f)
                curveToRelative(-0.018f, -0.18f, -0.006f, -0.407f, 0.174f, -0.505f)
                curveToRelative(0.276f, -0.148f, 0.6f, -0.159f, 0.906f, -0.191f)
                curveToRelative(0.231f, -0.018f, 0.462f, -0.029f, 0.694f, -0.038f)
                close()
            }
            path(fill = SolidColor(Color(0xFF382A1B))) {
                moveToRelative(19.663f, 34.577f)
                curveToRelative(0.214f, 0.188f, 0.275f, 0.489f, 0.235f, 0.76f)
                curveToRelative(-0.057f, 0.505f, -0.102f, 1.011f, -0.156f, 1.516f)
                curveToRelative(-0.025f, 0.206f, -0.1f, 0.419f, -0.277f, 0.543f)
                curveToRelative(-0.188f, 0.144f, -0.394f, 0.266f, -0.608f, 0.365f)
                curveToRelative(-0.34f, 0.12f, -0.693f, -0.035f, -0.999f, -0.179f)
                curveToRelative(-0.189f, -0.109f, -0.419f, -0.136f, -0.59f, -0.276f)
                curveToRelative(-0.137f, -0.122f, -0.068f, -0.32f, -0.113f, -0.477f)
                curveToRelative(-0.119f, -0.62f, -0.211f, -1.245f, -0.261f, -1.874f)
                curveToRelative(-0.046f, -0.165f, -0.001f, -0.373f, 0.185f, -0.423f)
                curveToRelative(0.447f, -0.144f, 0.924f, -0.094f, 1.385f, -0.067f)
                curveToRelative(0.4f, 0.03f, 0.799f, 0.069f, 1.198f, 0.11f)
                close()
            }
        }
        group("leg-l2", rotate = rotateL2.value, pivotX = 15.802f, pivotY = 16.644f) {
            path(fill = SolidColor(Color(0xFF332919))) {
                moveToRelative(6.226f, 16.27f)
                curveToRelative(-0.363f, -0.297f, -1.702f, -1.129f, -1.338f, -1.223f)
                curveToRelative(0.56f, 0.171f, 1.371f, 0.74f, 1.847f, 1.117f)
                curveToRelative(-0.135f, 0.134f, -0.172f, 0.091f, -0.509f, 0.106f)
                close()
            }
            path(fill = SolidColor(Color(0xFF4F3E26))) {
                moveToRelative(6.732f, 16.125f)
                curveToRelative(-0.322f, 0.024f, -0.5f, 0.095f, -0.495f, 0.154f)
                curveToRelative(0.019f, 0.227f, 0.025f, 0.69f, 0.056f, 0.919f)
                curveToRelative(0.078f, 0.571f, 0.248f, 2.685f, 0.354f, 3.152f)
                curveToRelative(0.029f, 0.128f, 0.168f, 0.239f, 0.329f, 0.193f)
                curveToRelative(0.136f, -0.039f, 0.197f, -0.249f, 0.234f, -0.356f)
                curveToRelative(0.093f, -0.271f, 0.085f, -0.405f, 0.17f, -0.676f)
                curveToRelative(0.089f, -0.284f, 0.092f, -0.825f, -0.114f, -1.09f)
                curveToRelative(-0.114f, -0.147f, -0.454f, -2.105f, -0.534f, -2.295f)
                close()
            }
            path(fill = SolidColor(Color(0xFF443421))) {
                moveToRelative(6.879f, 20.587f)
                curveToRelative(0.221f, -0.374f, 0.327f, -0.632f, 0.478f, -0.604f)
                curveToRelative(0.428f, 0.08f, 2.324f, 0.296f, 2.633f, 0.356f)
                curveToRelative(0.35f, 0.069f, 0.68f, 0.09f, 1.027f, 0.141f)
                curveToRelative(0.358f, 0.053f, 0.496f, 0.577f, 0.478f, 0.887f)
                curveToRelative(-1.218f, 0.109f, -4.642f, -0.602f, -4.615f, -0.781f)
                close()
            }
            path(fill = SolidColor(Color(0xFF4F3E26))) {
                moveToRelative(11.106f, 20.533f)
                curveToRelative(0.288f, -0.728f, 2.249f, -3.125f, 2.509f, -3.087f)
                curveToRelative(0.151f, 0.022f, 0.488f, 0.292f, 0.501f, 0.415f)
                curveToRelative(0.018f, 0.168f, -2.008f, 2.844f, -2.21f, 3.123f)
                curveToRelative(-0.084f, 0.116f, -0.13f, 0.233f, -0.269f, 0.31f)
                curveToRelative(-0.251f, 0.138f, -0.247f, -0.045f, -0.53f, -0.761f)
                close()
            }
            path(fill = SolidColor(Color(0xFF382A1B))) {
                moveToRelative(13.511f, 17.473f)
                curveToRelative(0.084f, -0.261f, 0.437f, -0.669f, 0.688f, -0.962f)
                curveToRelative(0.25f, -0.291f, 0.971f, -0.425f, 1.36f, -0.326f)
                curveToRelative(0.361f, 0.092f, 0.254f, 0.502f, 0.154f, 0.813f)
                curveToRelative(-0.05f, 0.156f, -0.595f, 0.213f, -0.858f, 0.357f)
                curveToRelative(-0.176f, 0.097f, -0.616f, 0.515f, -0.652f, 0.538f)
                curveToRelative(-0.127f, 0.08f, -0.245f, -0.139f, -0.692f, -0.42f)
                close()
            }
        }
        group("leg-l3", rotate = rotateL3.value, pivotX = 15.520f, pivotY = 18.664f) {
            path(fill = SolidColor(Color(0xFF332919))) {
                moveToRelative(3.228f, 19.939f)
                curveToRelative(-0.198f, -0.14f, -0.557f, -0.207f, -0.801f, -0.285f)
                curveToRelative(-0.29f, -0.092f, -0.534f, -0.162f, -0.845f, -0.162f)
                curveToRelative(-0.115f, 0.314f, 1.512f, 0.822f, 1.775f, 0.922f)
                curveToRelative(0.056f, -0.115f, 0.053f, -0.245f, -0.13f, -0.475f)
                close()
            }
            path(fill = SolidColor(Color(0xFF4F3E26))) {
                moveToRelative(3.125f, 20.385f)
                curveToRelative(0.033f, -0.197f, 0.068f, -0.386f, 0.163f, -0.417f)
                curveToRelative(0.019f, -0.067f, 0.275f, 0.259f, 0.36f, 0.405f)
                curveToRelative(0.108f, 0.186f, 0.231f, 0.336f, 0.364f, 0.508f)
                curveToRelative(0.272f, 0.351f, 0.517f, 0.723f, 0.779f, 1.08f)
                curveToRelative(0.418f, 0.57f, 0.702f, 1.262f, 0.94f, 1.92f)
                curveToRelative(0.05f, 0.139f, 0.152f, 0.33f, 0.146f, 0.475f)
                curveToRelative(-0.005f, 0.138f, -0.119f, 0.345f, -0.171f, 0.476f)
                curveToRelative(-0.278f, 0.066f, -0.849f, -0.646f, -0.964f, -0.857f)
                curveToRelative(-0.143f, -0.261f, -0.236f, -0.536f, -0.343f, -0.811f)
                curveToRelative(-0.271f, -0.692f, -0.583f, -1.349f, -1.274f, -2.78f)
                close()
            }
            path(fill = SolidColor(Color(0xFF443421))) {
                moveToRelative(5.627f, 24.837f)
                curveToRelative(0.174f, -0.266f, 0.058f, -0.851f, 0.226f, -0.936f)
                curveToRelative(0.242f, -0.124f, 1.378f, 0.065f, 1.735f, 0.149f)
                curveToRelative(0.615f, 0.144f, 0.862f, 0.157f, 1.491f, 0.255f)
                curveToRelative(0.281f, 0.044f, 0.566f, 0.085f, 0.849f, 0.121f)
                curveToRelative(0.162f, 0.02f, 0.406f, -0.004f, 0.53f, 0.106f)
                curveToRelative(0.154f, 0.136f, 0.179f, 0.483f, 0.202f, 0.664f)
                curveToRelative(0.017f, 0.129f, 0.018f, 0.171f, -0.122f, 0.23f)
                curveToRelative(-0.132f, 0.055f, -0.307f, 0.032f, -0.444f, 0.036f)
                curveToRelative(-0.391f, 0.013f, -4.479f, -0.525f, -4.466f, -0.626f)
                close()
            }
            path(fill = SolidColor(Color(0xFF4F3E26))) {
                moveToRelative(10.503f, 24.753f)
                curveToRelative(-0.036f, -0.301f, -0.139f, -0.162f, 0.018f, -0.43f)
                curveToRelative(0.236f, -0.404f, 1.832f, -2.758f, 2.353f, -3.348f)
                curveToRelative(0.21f, -0.237f, 0.316f, -0.419f, 0.624f, -0.188f)
                curveToRelative(0.079f, 0.06f, 0.327f, 0.194f, 0.372f, 0.278f)
                curveToRelative(0.067f, 0.124f, -0.03f, 0.237f, -0.085f, 0.355f)
                curveToRelative(-0.331f, 0.707f, -0.687f, 1.472f, -1.162f, 2.105f)
                curveToRelative(-0.349f, 0.466f, -1.359f, 1.731f, -1.574f, 1.845f)
                curveToRelative(-0.316f, 0.167f, -0.49f, 0.128f, -0.544f, -0.617f)
                close()
            }
            path(fill = SolidColor(Color(0xFF382A1B))) {
                moveToRelative(13.838f, 21.132f)
                curveToRelative(-0.102f, -0.231f, -0.933f, -0.411f, -0.754f, -0.709f)
                curveToRelative(0.131f, -0.219f, 0.283f, -0.439f, 0.429f, -0.648f)
                curveToRelative(0.143f, -0.204f, 0.25f, -0.403f, 0.368f, -0.622f)
                curveToRelative(0.053f, -0.098f, 0.115f, -0.236f, 0.191f, -0.317f)
                curveToRelative(0.141f, -0.149f, 0.186f, -0.073f, 0.362f, -0.11f)
                curveToRelative(0.352f, -0.075f, 0.455f, -0.517f, 0.82f, -0.617f)
                curveToRelative(0.318f, -0.087f, 0.261f, 0.329f, 0.266f, 0.556f)
                curveToRelative(0.013f, 0.578f, 0.183f, 1.249f, -0.503f, 1.497f)
                curveToRelative(-0.506f, 0.183f, -0.955f, 1.174f, -1.179f, 0.971f)
                close()
            }
        }
        group("leg-l4", rotate = rotateL4.value, pivotX = 15.570f, pivotY = 21.506f) {
            path(fill = SolidColor(Color(0xFF332919))) {
                moveToRelative(2.153f, 32.05f)
                curveToRelative(-0.264f, -0.145f, -0.699f, -0.096f, -0.992f, -0.077f)
                curveToRelative(-0.325f, 0.021f, -0.749f, 0.043f, -1.043f, 0.187f)
                curveToRelative(-0.381f, 0.187f, 0.265f, 0.188f, 0.438f, 0.179f)
                curveToRelative(0.339f, -0.018f, 0.657f, 0.043f, 0.992f, 0.068f)
                curveToRelative(0.264f, 0.019f, 0.525f, 0.076f, 0.79f, 0.109f)
                curveToRelative(0.015f, -0.064f, 0.066f, -0.191f, 0.052f, -0.256f)
                curveToRelative(-0.029f, -0.131f, -0.095f, -0.097f, -0.238f, -0.21f)
                close()
            }
            path(fill = SolidColor(Color(0xFF4F3E26))) {
                moveToRelative(2.119f, 32.005f)
                curveToRelative(-0.052f, 0.066f, 0.044f, 0.384f, 0.12f, 0.474f)
                curveToRelative(0.069f, 0.082f, 0.454f, 0.133f, 0.566f, 0.163f)
                curveToRelative(0.385f, 0.104f, 0.782f, 0.177f, 1.17f, 0.27f)
                curveToRelative(0.737f, 0.177f, 1.49f, 0.315f, 2.19f, 0.597f)
                curveToRelative(0.379f, 0.152f, 0.778f, 0.316f, 1.203f, 0.328f)
                curveToRelative(0.323f, 0.009f, 0.456f, -0.048f, 0.365f, -0.336f)
                curveToRelative(-0.073f, -0.23f, -0.208f, -0.679f, -0.44f, -0.816f)
                curveToRelative(-0.235f, -0.138f, -0.696f, -0.118f, -0.963f, -0.188f)
                curveToRelative(-0.522f, -0.135f, -1.008f, -0.156f, -1.543f, -0.184f)
                curveToRelative(-0.233f, -0.012f, -1.641f, -0.146f, -2.668f, -0.309f)
                close()
            }
            path(fill = SolidColor(Color(0xFF443421))) {
                moveToRelative(7.541f, 33.113f)
                curveToRelative(-0.081f, -0.245f, -0.255f, -0.408f, 0.018f, -0.534f)
                curveToRelative(0.824f, -0.378f, 3.242f, -1.765f, 3.626f, -1.943f)
                curveToRelative(0.318f, -0.147f, 0.649f, -0.396f, 1.023f, -0.358f)
                curveToRelative(0.191f, 0.02f, 0.747f, 0.193f, 0.811f, 0.357f)
                curveToRelative(0.14f, 0.361f, -0.562f, 0.789f, -0.806f, 0.92f)
                curveToRelative(-0.646f, 0.348f, -2.794f, 1.627f, -3.282f, 1.871f)
                curveToRelative(-0.238f, 0.119f, -0.731f, 0.347f, -1.013f, 0.385f)
                curveToRelative(-0.174f, 0.024f, -0.135f, 0.037f, -0.378f, -0.699f)
                close()
            }
            path(fill = SolidColor(Color(0xFF4F3E26))) {
                moveToRelative(11.969f, 30.298f)
                curveToRelative(0.119f, -1.63f, 0.216f, -2.865f, 0.455f, -4.871f)
                curveToRelative(0.04f, -0.331f, 0.086f, -0.446f, 0.478f, -0.398f)
                curveToRelative(0.366f, 0.044f, 0.522f, 0.056f, 0.558f, 0.372f)
                curveToRelative(0.114f, 0.997f, -0.109f, 2.227f, -0.232f, 3.222f)
                curveToRelative(-0.065f, 0.523f, -0.127f, 1.498f, -0.168f, 2.017f)
                curveToRelative(-0.026f, 0.325f, -0.098f, 0.063f, -1.091f, -0.342f)
                close()
            }
            path(fill = SolidColor(Color(0xFF382A1B))) {
                moveToRelative(12.549f, 25.129f)
                curveToRelative(-0.233f, -0.14f, 0.367f, -0.979f, 0.529f, -1.283f)
                curveToRelative(0.164f, -0.308f, 0.906f, -1.508f, 1.055f, -1.772f)
                curveToRelative(0.182f, -0.323f, 0.495f, -0.525f, 0.843f, -0.673f)
                curveToRelative(0.284f, -0.121f, 0.624f, -0.315f, 0.595f, 0.105f)
                curveToRelative(-0.021f, 0.302f, -0.113f, 0.598f, -0.133f, 0.899f)
                curveToRelative(-0.016f, 0.255f, -0.006f, 0.498f, -0.187f, 0.713f)
                curveToRelative(-0.13f, 0.154f, -0.271f, 0.246f, -0.394f, 0.41f)
                curveToRelative(-0.21f, 0.278f, -0.434f, 0.389f, -0.588f, 0.698f)
                curveToRelative(-0.143f, 0.287f, -0.469f, 0.905f, -0.676f, 1.159f)
                curveToRelative(-0.223f, 0.273f, -0.448f, 0.103f, -1.043f, -0.255f)
                close()
            }
        }
        group("leg-l1", rotate = rotateL1.value, pivotX = 16.135f, pivotY = 14.636f) {
            path(fill = SolidColor(Color(0xFF332919))) {
                moveToRelative(8.278f, 14.32f)
                curveToRelative(-0.237f, -0.115f, -1.737f, -0.618f, -1.806f, -0.341f)
                curveToRelative(0.216f, 0.236f, 0.651f, 0.319f, 0.946f, 0.427f)
                curveToRelative(0.245f, 0.09f, 0.493f, 0.186f, 0.732f, 0.291f)
                curveToRelative(0.064f, -0.068f, 0.103f, -0.163f, 0.128f, -0.377f)
                close()
            }
            path(fill = SolidColor(Color(0xFF443421))) {
                moveToRelative(10.231f, 17.79f)
                curveToRelative(0.103f, -0.013f, 0.275f, -0.585f, 0.247f, -0.714f)
                curveToRelative(-0.05f, -0.235f, -0.291f, -0.345f, -0.421f, -0.545f)
                curveToRelative(-0.076f, -0.116f, -0.158f, -0.218f, -0.22f, -0.342f)
                curveToRelative(-0.055f, -0.11f, -0.086f, -0.297f, -0.176f, -0.383f)
                curveToRelative(-0.115f, -0.11f, -0.173f, -0.077f, -0.276f, -0.224f)
                curveToRelative(-0.082f, -0.116f, -0.151f, -0.232f, -0.24f, -0.347f)
                curveToRelative(-0.184f, -0.237f, -0.406f, -0.445f, -0.597f, -0.679f)
                curveToRelative(-0.116f, -0.142f, -0.327f, -0.415f, -0.459f, -0.118f)
                curveToRelative(-0.096f, 0.217f, 0.119f, 0.591f, 0.218f, 0.791f)
                curveToRelative(0.196f, 0.394f, 0.463f, 0.757f, 0.696f, 1.132f)
                curveToRelative(0.216f, 0.347f, 0.463f, 0.691f, 0.697f, 1.025f)
                curveToRelative(0.078f, 0.111f, 0.337f, 0.705f, 0.53f, 0.402f)
                close()
            }
            path(fill = SolidColor(Color(0xFF4F3E26))) {
                moveToRelative(12.995f, 16.15f)
                curveToRelative(-0.553f, 0.074f, -1.026f, 0.274f, -1.564f, 0.392f)
                curveToRelative(-0.359f, 0.079f, -1.142f, 0.226f, -1.209f, 0.414f)
                curveToRelative(-0.074f, 0.208f, -0.104f, 0.429f, -0.084f, 0.881f)
                curveToRelative(0.006f, 0.132f, 2.942f, -0.857f, 3.246f, -0.968f)
                curveToRelative(0.444f, -0.162f, 0.252f, -0.205f, -0.389f, -0.718f)
                close()
            }
            path(fill = SolidColor(Color(0xFF382A1B))) {
                moveToRelative(16.119f, 14.174f)
                curveToRelative(-0.177f, -0.118f, -0.313f, -0.226f, -0.535f, -0.278f)
                curveToRelative(-0.351f, -0.083f, -0.5f, -0.049f, -0.661f, 0.226f)
                curveToRelative(-0.139f, 0.239f, -0.27f, 0.314f, -0.495f, 0.486f)
                curveToRelative(-0.231f, 0.177f, -0.397f, 0.426f, -0.606f, 0.624f)
                curveToRelative(-0.246f, 0.234f, -0.731f, 0.673f, -0.849f, 0.996f)
                curveToRelative(-0.039f, 0.108f, 0.286f, 0.574f, 0.414f, 0.575f)
                curveToRelative(0.34f, 0.002f, 0.82f, -0.61f, 1.006f, -0.815f)
                curveToRelative(0.261f, -0.288f, 0.562f, -0.528f, 0.83f, -0.811f)
                curveToRelative(0.158f, -0.167f, 0.154f, -0.268f, 0.41f, -0.281f)
                curveToRelative(0.078f, -0.004f, 0.249f, 0.047f, 0.321f, 0.015f)
                curveToRelative(0.169f, -0.075f, 0.252f, -0.392f, 0.164f, -0.737f)
                close()
            }
        }
        group("claw-l", rotate = rotateCL.value, pivotX = 17.393f, pivotY = 12.709f) {
            path(fill = SolidColor(Color(0xFF382A1B))) {
                moveToRelative(10.046f, 6.756f)
                curveToRelative(0.227f, -0.275f, 0.271f, -0.669f, 0.539f, -0.914f)
                curveToRelative(0.316f, -0.215f, 0.772f, -0.067f, 1.051f, -0.358f)
                curveToRelative(0.221f, -0.206f, 0.266f, -0.536f, 0.482f, -0.743f)
                curveToRelative(0.207f, -0.148f, 0.531f, 0.062f, 0.694f, -0.174f)
                curveToRelative(0.028f, -0.244f, 0.177f, -0.429f, 0.359f, -0.585f)
                curveToRelative(0.119f, -0.095f, 0.342f, -0.374f, 0.395f, -0.349f)
                curveToRelative(-0.141f, 0.779f, -0.507f, 1.509f, -1.016f, 2.112f)
                curveToRelative(-0.311f, 0.42f, -0.626f, 0.854f, -1.074f, 1.14f)
                curveToRelative(-0.45f, 0.309f, -0.908f, 0.613f, -1.399f, 0.852f)
                curveToRelative(-0.299f, 0.101f, -0.605f, 0.206f, -0.923f, 0.225f)
                curveToRelative(-0.224f, -0.073f, 0.031f, -0.343f, 0.111f, -0.459f)
                curveToRelative(0.23f, -0.277f, 0.488f, -0.537f, 0.781f, -0.747f)
                close()
            }
            path(fill = SolidColor(Color(0xFF4F3E26))) {
                moveToRelative(8.649f, 8.858f)
                curveToRelative(-0.079f, -0.169f, -0.14f, -0.526f, -0.044f, -0.616f)
                curveToRelative(0.401f, 0.096f, 0.76f, -0.198f, 1.063f, -0.421f)
                curveToRelative(0.3f, -0.223f, 0.607f, -0.517f, 0.609f, -0.919f)
                curveToRelative(0.028f, -0.608f, -0.049f, -1.298f, 0.359f, -1.804f)
                curveToRelative(0.173f, -0.25f, 0.578f, -0.258f, 0.668f, -0.574f)
                curveToRelative(-0.061f, -0.257f, -0.087f, -0.629f, 0.292f, -0.612f)
                curveToRelative(0.32f, -0.016f, 0.474f, -0.273f, 0.59f, -0.526f)
                curveToRelative(0.313f, -0.145f, 0.519f, -0.423f, 0.743f, -0.673f)
                curveToRelative(0.079f, -0.163f, 0.488f, -0.255f, 0.44f, -0.303f)
                curveToRelative(-0.731f, -0.126f, -1.461f, 0.112f, -2.158f, 0.306f)
                curveToRelative(-0.729f, 0.216f, -1.397f, 0.597f, -1.976f, 1.087f)
                curveToRelative(-0.714f, 0.572f, -1.365f, 1.35f, -1.437f, 2.299f)
                curveToRelative(-0.058f, 0.624f, -0.024f, 1.252f, 0.047f, 1.873f)
                curveToRelative(0.007f, 0.306f, -0.022f, 0.737f, 0.321f, 0.874f)
                curveToRelative(0.154f, 0.056f, 0.324f, 0.038f, 0.481f, 0.007f)
                close()
            }
            path(fill = SolidColor(Color(0xFF443421))) {
                moveToRelative(7.8f, 8.296f)
                curveToRelative(0.104f, -0.065f, 0.62f, 0.061f, 0.743f, 0.074f)
                curveToRelative(0.115f, 0.012f, 0.331f, 0.03f, 0.428f, 0.105f)
                curveToRelative(0.243f, 0.187f, 0.199f, 0.634f, 0.313f, 0.883f)
                curveToRelative(0.092f, 0.201f, 0.193f, 0.411f, 0.326f, 0.591f)
                curveToRelative(0.156f, 0.211f, 0.349f, 0.389f, 0.478f, 0.618f)
                curveToRelative(0.216f, 0.387f, 0.441f, 0.863f, 0.474f, 1.3f)
                curveToRelative(0.059f, 0.777f, 0.283f, 1.549f, -0.007f, 2.307f)
                curveToRelative(-0.451f, 1.179f, -1.979f, -0.945f, -2.196f, -1.35f)
                curveToRelative(-0.19f, -0.356f, -0.425f, -0.756f, -0.563f, -1.131f)
                curveToRelative(-0.118f, -0.319f, -0.194f, -0.657f, -0.286f, -0.984f)
                curveToRelative(-0.174f, -0.619f, -0.026f, -2.419f, 0.291f, -2.414f)
                close()
            }
            path(fill = SolidColor(Color(0xFF4F3E26))) {
                moveToRelative(10.806f, 12.96f)
                curveToRelative(-0.271f, 0.098f, -0.593f, 1.557f, -0.524f, 1.663f)
                curveToRelative(0.123f, 0.189f, 0.354f, 0.078f, 0.54f, 0.026f)
                curveToRelative(0.468f, -0.132f, 2.162f, -0.914f, 2.559f, -1.11f)
                curveToRelative(0.378f, -0.187f, 0.754f, -0.398f, 1.106f, -0.625f)
                curveToRelative(0.268f, -0.173f, 0.526f, -0.361f, 0.805f, -0.52f)
                curveToRelative(0.248f, -0.141f, 0.401f, -0.266f, 0.32f, -0.548f)
                curveToRelative(-0.068f, -0.235f, -0.186f, -0.685f, -0.5f, -0.704f)
                curveToRelative(-0.218f, -0.013f, -0.544f, 0.067f, -0.748f, 0.131f)
                curveToRelative(-0.949f, 0.299f, -1.865f, 0.927f, -3.557f, 1.687f)
                close()
            }
            path(fill = SolidColor(Color(0xFF382A1B))) {
                moveToRelative(17.393f, 12.709f)
                curveToRelative(-0.379f, -0.032f, -0.397f, -0.676f, -0.461f, -0.927f)
                curveToRelative(-0.106f, -0.417f, -0.437f, -0.732f, -0.912f, -0.779f)
                curveToRelative(-0.433f, -0.043f, -0.821f, -0.006f, -0.838f, 0.455f)
                curveToRelative(-0.016f, 0.462f, 0.058f, 0.982f, 0.463f, 1.279f)
                curveToRelative(0.515f, 0.378f, 1.035f, 0.478f, 1.748f, -0.028f)
                close()
            }
        }
        group("leg-r2", rotate = rotateR2.value, pivotX = 21.927f, pivotY = 16.828f) {
            path(fill = SolidColor(Color(0xFF332919))) {
                moveToRelative(31.503f, 16.454f)
                curveToRelative(0.363f, -0.297f, 1.702f, -1.129f, 1.338f, -1.223f)
                curveToRelative(-0.56f, 0.171f, -1.371f, 0.74f, -1.847f, 1.117f)
                curveToRelative(0.135f, 0.134f, 0.172f, 0.091f, 0.509f, 0.106f)
                close()
            }
            path(fill = SolidColor(Color(0xFF4F3E26))) {
                moveToRelative(30.997f, 16.309f)
                curveToRelative(0.322f, 0.024f, 0.5f, 0.095f, 0.495f, 0.154f)
                curveToRelative(-0.019f, 0.227f, -0.025f, 0.69f, -0.056f, 0.919f)
                curveToRelative(-0.078f, 0.571f, -0.248f, 2.685f, -0.354f, 3.152f)
                curveToRelative(-0.029f, 0.128f, -0.168f, 0.239f, -0.329f, 0.193f)
                curveToRelative(-0.136f, -0.039f, -0.197f, -0.249f, -0.234f, -0.356f)
                curveToRelative(-0.093f, -0.271f, -0.085f, -0.405f, -0.17f, -0.676f)
                curveToRelative(-0.089f, -0.284f, -0.092f, -0.825f, 0.114f, -1.09f)
                curveToRelative(0.114f, -0.147f, 0.454f, -2.105f, 0.534f, -2.295f)
                close()
            }
            path(fill = SolidColor(Color(0xFF443421))) {
                moveToRelative(30.85f, 20.771f)
                curveToRelative(-0.221f, -0.374f, -0.327f, -0.632f, -0.478f, -0.604f)
                curveToRelative(-0.428f, 0.08f, -2.324f, 0.296f, -2.633f, 0.356f)
                curveToRelative(-0.35f, 0.069f, -0.68f, 0.09f, -1.027f, 0.141f)
                curveToRelative(-0.358f, 0.053f, -0.496f, 0.577f, -0.478f, 0.887f)
                curveToRelative(1.218f, 0.109f, 4.642f, -0.602f, 4.615f, -0.781f)
                close()
            }
            path(fill = SolidColor(Color(0xFF4F3E26))) {
                moveToRelative(26.623f, 20.717f)
                curveToRelative(-0.288f, -0.728f, -2.249f, -3.125f, -2.509f, -3.087f)
                curveToRelative(-0.151f, 0.022f, -0.488f, 0.292f, -0.501f, 0.415f)
                curveToRelative(-0.018f, 0.168f, 2.008f, 2.844f, 2.21f, 3.123f)
                curveToRelative(0.084f, 0.116f, 0.13f, 0.233f, 0.269f, 0.31f)
                curveToRelative(0.25f, 0.138f, 0.247f, -0.045f, 0.53f, -0.761f)
                close()
            }
            path(fill = SolidColor(Color(0xFF382A1B))) {
                moveToRelative(24.217f, 17.657f)
                curveToRelative(-0.084f, -0.261f, -0.437f, -0.669f, -0.688f, -0.962f)
                curveToRelative(-0.25f, -0.291f, -0.971f, -0.425f, -1.36f, -0.326f)
                curveToRelative(-0.361f, 0.092f, -0.254f, 0.502f, -0.154f, 0.813f)
                curveToRelative(0.05f, 0.156f, 0.595f, 0.213f, 0.858f, 0.357f)
                curveToRelative(0.176f, 0.096f, 0.616f, 0.515f, 0.652f, 0.538f)
                curveToRelative(0.127f, 0.08f, 0.245f, -0.139f, 0.692f, -0.42f)
                close()
            }
        }
        group("leg-r3", rotate = rotateR3.value, pivotX = 22.209f, pivotY = 18.848f) {
            path(fill = SolidColor(Color(0xFF332919))) {
                moveToRelative(34.501f, 20.123f)
                curveToRelative(0.198f, -0.14f, 0.557f, -0.207f, 0.801f, -0.285f)
                curveToRelative(0.29f, -0.092f, 0.534f, -0.162f, 0.845f, -0.162f)
                curveToRelative(0.115f, 0.314f, -1.512f, 0.822f, -1.775f, 0.922f)
                curveToRelative(-0.056f, -0.115f, -0.053f, -0.245f, 0.13f, -0.475f)
                close()
            }
            path(fill = SolidColor(Color(0xFF4F3E26))) {
                moveToRelative(34.604f, 20.569f)
                curveToRelative(-0.033f, -0.197f, -0.068f, -0.386f, -0.163f, -0.417f)
                curveToRelative(-0.019f, -0.067f, -0.275f, 0.259f, -0.36f, 0.405f)
                curveToRelative(-0.108f, 0.186f, -0.231f, 0.336f, -0.364f, 0.508f)
                curveToRelative(-0.272f, 0.351f, -0.517f, 0.723f, -0.779f, 1.08f)
                curveToRelative(-0.418f, 0.57f, -0.702f, 1.262f, -0.941f, 1.92f)
                curveToRelative(-0.05f, 0.139f, -0.152f, 0.33f, -0.146f, 0.475f)
                curveToRelative(0.005f, 0.138f, 0.119f, 0.345f, 0.171f, 0.476f)
                curveToRelative(0.278f, 0.066f, 0.849f, -0.646f, 0.964f, -0.857f)
                curveToRelative(0.143f, -0.261f, 0.236f, -0.536f, 0.343f, -0.811f)
                curveToRelative(0.272f, -0.692f, 0.584f, -1.349f, 1.275f, -2.78f)
                close()
            }
            path(fill = SolidColor(Color(0xFF443421))) {
                moveToRelative(32.102f, 25.021f)
                curveToRelative(-0.174f, -0.266f, -0.058f, -0.851f, -0.226f, -0.936f)
                curveToRelative(-0.243f, -0.124f, -1.378f, 0.065f, -1.735f, 0.149f)
                curveToRelative(-0.615f, 0.144f, -0.862f, 0.157f, -1.491f, 0.255f)
                curveToRelative(-0.281f, 0.044f, -0.566f, 0.085f, -0.849f, 0.121f)
                curveToRelative(-0.162f, 0.02f, -0.406f, -0.004f, -0.53f, 0.106f)
                curveToRelative(-0.154f, 0.136f, -0.179f, 0.483f, -0.202f, 0.664f)
                curveToRelative(-0.017f, 0.129f, -0.018f, 0.171f, 0.122f, 0.23f)
                curveToRelative(0.132f, 0.055f, 0.307f, 0.032f, 0.444f, 0.036f)
                curveToRelative(0.391f, 0.013f, 4.479f, -0.525f, 4.466f, -0.625f)
                close()
            }
            path(fill = SolidColor(Color(0xFF4F3E26))) {
                moveToRelative(27.225f, 24.937f)
                curveToRelative(0.036f, -0.301f, 0.139f, -0.162f, -0.018f, -0.43f)
                curveToRelative(-0.236f, -0.404f, -1.832f, -2.758f, -2.353f, -3.348f)
                curveToRelative(-0.21f, -0.237f, -0.316f, -0.419f, -0.624f, -0.188f)
                curveToRelative(-0.079f, 0.06f, -0.327f, 0.194f, -0.372f, 0.278f)
                curveToRelative(-0.067f, 0.124f, 0.03f, 0.237f, 0.085f, 0.355f)
                curveToRelative(0.331f, 0.707f, 0.687f, 1.472f, 1.162f, 2.105f)
                curveToRelative(0.349f, 0.466f, 1.359f, 1.731f, 1.574f, 1.845f)
                curveToRelative(0.316f, 0.168f, 0.49f, 0.128f, 0.544f, -0.617f)
                close()
            }
            path(fill = SolidColor(Color(0xFF382A1B))) {
                moveToRelative(23.891f, 21.316f)
                curveToRelative(0.102f, -0.231f, 0.933f, -0.411f, 0.754f, -0.709f)
                curveToRelative(-0.131f, -0.219f, -0.283f, -0.439f, -0.429f, -0.648f)
                curveToRelative(-0.143f, -0.204f, -0.25f, -0.403f, -0.368f, -0.623f)
                curveToRelative(-0.053f, -0.098f, -0.115f, -0.236f, -0.191f, -0.317f)
                curveToRelative(-0.141f, -0.149f, -0.186f, -0.073f, -0.362f, -0.11f)
                curveToRelative(-0.352f, -0.075f, -0.455f, -0.517f, -0.82f, -0.617f)
                curveToRelative(-0.318f, -0.087f, -0.261f, 0.329f, -0.266f, 0.556f)
                curveToRelative(-0.013f, 0.578f, -0.183f, 1.249f, 0.503f, 1.497f)
                curveToRelative(0.506f, 0.183f, 0.955f, 1.175f, 1.179f, 0.971f)
                close()
            }
        }
        group("leg-r4", rotate = rotateR4.value, pivotX = 22.194f, pivotY = 21.958f) {
            path(fill = SolidColor(Color(0xFF332919))) {
                moveToRelative(35.575f, 32.235f)
                curveToRelative(0.264f, -0.145f, 0.699f, -0.096f, 0.992f, -0.077f)
                curveToRelative(0.325f, 0.021f, 0.749f, 0.043f, 1.043f, 0.187f)
                curveToRelative(0.381f, 0.187f, -0.265f, 0.188f, -0.438f, 0.179f)
                curveToRelative(-0.339f, -0.018f, -0.657f, 0.043f, -0.992f, 0.068f)
                curveToRelative(-0.264f, 0.019f, -0.525f, 0.076f, -0.79f, 0.109f)
                curveToRelative(-0.015f, -0.064f, -0.066f, -0.191f, -0.052f, -0.256f)
                curveToRelative(0.029f, -0.131f, 0.095f, -0.097f, 0.238f, -0.21f)
                close()
            }
            path(fill = SolidColor(Color(0xFF4F3E26))) {
                moveToRelative(35.609f, 32.189f)
                curveToRelative(0.052f, 0.066f, -0.044f, 0.384f, -0.12f, 0.474f)
                curveToRelative(-0.069f, 0.082f, -0.454f, 0.133f, -0.566f, 0.163f)
                curveToRelative(-0.385f, 0.104f, -0.782f, 0.177f, -1.17f, 0.27f)
                curveToRelative(-0.737f, 0.177f, -1.49f, 0.315f, -2.19f, 0.597f)
                curveToRelative(-0.379f, 0.152f, -0.778f, 0.316f, -1.203f, 0.328f)
                curveToRelative(-0.323f, 0.009f, -0.456f, -0.048f, -0.365f, -0.336f)
                curveToRelative(0.073f, -0.23f, 0.208f, -0.679f, 0.44f, -0.816f)
                curveToRelative(0.235f, -0.138f, 0.696f, -0.118f, 0.963f, -0.188f)
                curveToRelative(0.522f, -0.135f, 1.008f, -0.156f, 1.543f, -0.184f)
                curveToRelative(0.233f, -0.012f, 1.641f, -0.146f, 2.668f, -0.309f)
                close()
            }
            path(fill = SolidColor(Color(0xFF443421))) {
                moveToRelative(30.188f, 33.297f)
                curveToRelative(0.081f, -0.245f, 0.255f, -0.408f, -0.018f, -0.534f)
                curveToRelative(-0.824f, -0.378f, -3.242f, -1.765f, -3.626f, -1.943f)
                curveToRelative(-0.318f, -0.147f, -0.649f, -0.396f, -1.023f, -0.357f)
                curveToRelative(-0.191f, 0.02f, -0.747f, 0.193f, -0.811f, 0.357f)
                curveToRelative(-0.14f, 0.361f, 0.562f, 0.789f, 0.806f, 0.92f)
                curveToRelative(0.646f, 0.348f, 2.794f, 1.627f, 3.282f, 1.871f)
                curveToRelative(0.238f, 0.119f, 0.731f, 0.347f, 1.013f, 0.385f)
                curveToRelative(0.174f, 0.023f, 0.135f, 0.037f, 0.378f, -0.699f)
                close()
            }
            path(fill = SolidColor(Color(0xFF4F3E26))) {
                moveToRelative(25.76f, 30.482f)
                curveToRelative(-0.119f, -1.63f, -0.216f, -2.865f, -0.455f, -4.871f)
                curveToRelative(-0.04f, -0.331f, -0.086f, -0.446f, -0.478f, -0.398f)
                curveToRelative(-0.366f, 0.044f, -0.522f, 0.056f, -0.558f, 0.372f)
                curveToRelative(-0.114f, 0.997f, 0.109f, 2.227f, 0.232f, 3.222f)
                curveToRelative(0.065f, 0.523f, 0.127f, 1.498f, 0.168f, 2.017f)
                curveToRelative(0.026f, 0.325f, 0.098f, 0.063f, 1.091f, -0.342f)
                close()
            }
            path(fill = SolidColor(Color(0xFF382A1B))) {
                moveToRelative(25.18f, 25.313f)
                curveToRelative(0.139f, -0.187f, -0.048f, -0.406f, -0.119f, -0.583f)
                curveToRelative(-0.235f, -0.415f, -0.483f, -0.823f, -0.723f, -1.236f)
                curveToRelative(-0.28f, -0.462f, -0.552f, -0.929f, -0.84f, -1.385f)
                curveToRelative(-0.285f, -0.357f, -0.727f, -0.536f, -1.146f, -0.68f)
                curveToRelative(-0.27f, 0.012f, -0.198f, 0.352f, -0.157f, 0.529f)
                curveToRelative(0.057f, 0.308f, 0.11f, 0.618f, 0.116f, 0.933f)
                curveToRelative(0.025f, 0.238f, 0.163f, 0.451f, 0.352f, 0.594f)
                curveToRelative(0.207f, 0.203f, 0.376f, 0.441f, 0.595f, 0.632f)
                curveToRelative(0.243f, 0.275f, 0.354f, 0.635f, 0.552f, 0.94f)
                curveToRelative(0.123f, 0.211f, 0.239f, 0.436f, 0.424f, 0.601f)
                curveToRelative(0.216f, 0.123f, 0.445f, -0.053f, 0.632f, -0.154f)
                curveToRelative(0.106f, -0.062f, 0.21f, -0.127f, 0.316f, -0.19f)
                close()
            }
        }
        group("leg-r1", rotate = rotateR1.value, pivotX = 21.594f, pivotY = 14.821f) {
            path(fill = SolidColor(Color(0xFF332919))) {
                moveToRelative(29.451f, 14.504f)
                curveToRelative(0.237f, -0.115f, 1.737f, -0.618f, 1.806f, -0.341f)
                curveToRelative(-0.216f, 0.236f, -0.651f, 0.319f, -0.946f, 0.427f)
                curveToRelative(-0.245f, 0.09f, -0.493f, 0.186f, -0.732f, 0.291f)
                curveToRelative(-0.064f, -0.068f, -0.103f, -0.163f, -0.128f, -0.377f)
                close()
            }
            path(fill = SolidColor(Color(0xFF443421))) {
                moveToRelative(27.498f, 17.974f)
                curveToRelative(-0.103f, -0.013f, -0.275f, -0.585f, -0.247f, -0.714f)
                curveToRelative(0.05f, -0.235f, 0.291f, -0.345f, 0.421f, -0.545f)
                curveToRelative(0.076f, -0.116f, 0.158f, -0.218f, 0.22f, -0.342f)
                curveToRelative(0.055f, -0.11f, 0.086f, -0.297f, 0.176f, -0.383f)
                curveToRelative(0.115f, -0.11f, 0.173f, -0.077f, 0.276f, -0.224f)
                curveToRelative(0.082f, -0.116f, 0.152f, -0.232f, 0.24f, -0.347f)
                curveToRelative(0.184f, -0.237f, 0.406f, -0.445f, 0.597f, -0.679f)
                curveToRelative(0.116f, -0.142f, 0.327f, -0.415f, 0.459f, -0.118f)
                curveToRelative(0.096f, 0.217f, -0.119f, 0.591f, -0.218f, 0.791f)
                curveToRelative(-0.196f, 0.394f, -0.463f, 0.757f, -0.696f, 1.132f)
                curveToRelative(-0.216f, 0.347f, -0.463f, 0.691f, -0.697f, 1.025f)
                curveToRelative(-0.078f, 0.111f, -0.337f, 0.705f, -0.53f, 0.402f)
                close()
            }
            path(fill = SolidColor(Color(0xFF4F3E26))) {
                moveToRelative(24.734f, 16.334f)
                curveToRelative(0.553f, 0.074f, 1.026f, 0.274f, 1.564f, 0.392f)
                curveToRelative(0.359f, 0.079f, 1.142f, 0.227f, 1.209f, 0.414f)
                curveToRelative(0.074f, 0.208f, 0.104f, 0.429f, 0.084f, 0.881f)
                curveToRelative(-0.006f, 0.132f, -2.942f, -0.857f, -3.246f, -0.968f)
                curveToRelative(-0.444f, -0.162f, -0.252f, -0.205f, 0.389f, -0.719f)
                close()
            }
            path(fill = SolidColor(Color(0xFF382A1B))) {
                moveToRelative(21.61f, 14.359f)
                curveToRelative(0.177f, -0.118f, 0.313f, -0.226f, 0.535f, -0.278f)
                curveToRelative(0.351f, -0.083f, 0.5f, -0.049f, 0.661f, 0.226f)
                curveToRelative(0.139f, 0.239f, 0.27f, 0.314f, 0.495f, 0.486f)
                curveToRelative(0.231f, 0.177f, 0.397f, 0.426f, 0.606f, 0.624f)
                curveToRelative(0.246f, 0.234f, 0.731f, 0.673f, 0.849f, 0.996f)
                curveToRelative(0.039f, 0.107f, -0.286f, 0.574f, -0.414f, 0.575f)
                curveToRelative(-0.34f, 0.002f, -0.82f, -0.61f, -1.006f, -0.815f)
                curveToRelative(-0.261f, -0.288f, -0.562f, -0.528f, -0.83f, -0.811f)
                curveToRelative(-0.158f, -0.167f, -0.154f, -0.268f, -0.41f, -0.281f)
                curveToRelative(-0.078f, -0.004f, -0.249f, 0.047f, -0.321f, 0.015f)
                curveToRelative(-0.169f, -0.075f, -0.252f, -0.392f, -0.164f, -0.737f)
                close()
            }
        }
        group("claw-r", rotate = rotateCR.value, pivotX = 20.336f, pivotY = 12.709f) {
            path(fill = SolidColor(Color(0xFF382A1B))) {
                moveToRelative(27.682f, 6.94f)
                curveToRelative(-0.227f, -0.275f, -0.271f, -0.669f, -0.539f, -0.914f)
                curveToRelative(-0.316f, -0.215f, -0.772f, -0.067f, -1.051f, -0.358f)
                curveToRelative(-0.221f, -0.206f, -0.266f, -0.536f, -0.482f, -0.743f)
                curveToRelative(-0.207f, -0.148f, -0.531f, 0.062f, -0.694f, -0.174f)
                curveToRelative(-0.028f, -0.244f, -0.177f, -0.429f, -0.359f, -0.585f)
                curveToRelative(-0.119f, -0.095f, -0.342f, -0.374f, -0.395f, -0.349f)
                curveToRelative(0.141f, 0.779f, 0.507f, 1.509f, 1.016f, 2.112f)
                curveToRelative(0.311f, 0.42f, 0.626f, 0.854f, 1.074f, 1.14f)
                curveToRelative(0.45f, 0.309f, 0.908f, 0.613f, 1.399f, 0.852f)
                curveToRelative(0.299f, 0.101f, 0.605f, 0.206f, 0.923f, 0.225f)
                curveToRelative(0.224f, -0.073f, -0.031f, -0.343f, -0.111f, -0.459f)
                curveToRelative(-0.23f, -0.277f, -0.488f, -0.537f, -0.781f, -0.747f)
                close()
            }
            path(fill = SolidColor(Color(0xFF4F3E26))) {
                moveToRelative(29.08f, 9.042f)
                curveToRelative(0.079f, -0.169f, 0.14f, -0.526f, 0.044f, -0.616f)
                curveToRelative(-0.401f, 0.096f, -0.76f, -0.198f, -1.063f, -0.421f)
                curveToRelative(-0.3f, -0.223f, -0.607f, -0.517f, -0.609f, -0.919f)
                curveToRelative(-0.028f, -0.608f, 0.049f, -1.298f, -0.359f, -1.804f)
                curveToRelative(-0.173f, -0.25f, -0.578f, -0.258f, -0.668f, -0.574f)
                curveToRelative(0.061f, -0.257f, 0.087f, -0.629f, -0.292f, -0.612f)
                curveToRelative(-0.32f, -0.016f, -0.474f, -0.273f, -0.59f, -0.526f)
                curveToRelative(-0.313f, -0.145f, -0.519f, -0.423f, -0.743f, -0.673f)
                curveToRelative(-0.079f, -0.163f, -0.488f, -0.255f, -0.44f, -0.303f)
                curveToRelative(0.731f, -0.126f, 1.461f, 0.112f, 2.158f, 0.306f)
                curveToRelative(0.729f, 0.216f, 1.397f, 0.597f, 1.976f, 1.087f)
                curveToRelative(0.714f, 0.572f, 1.365f, 1.35f, 1.437f, 2.298f)
                curveToRelative(0.058f, 0.624f, 0.024f, 1.252f, -0.047f, 1.873f)
                curveToRelative(-0.007f, 0.306f, 0.022f, 0.737f, -0.321f, 0.874f)
                curveToRelative(-0.154f, 0.056f, -0.324f, 0.038f, -0.481f, 0.007f)
                close()
            }
            path(fill = SolidColor(Color(0xFF443421))) {
                moveToRelative(29.929f, 8.48f)
                curveToRelative(-0.291f, -0.056f, -0.582f, 0.075f, -0.873f, 0.089f)
                curveToRelative(-0.203f, 0.007f, -0.405f, 0.119f, -0.455f, 0.328f)
                curveToRelative(-0.086f, 0.278f, -0.084f, 0.583f, -0.245f, 0.836f)
                curveToRelative(-0.161f, 0.392f, -0.499f, 0.664f, -0.715f, 1.02f)
                curveToRelative(-0.257f, 0.455f, -0.475f, 0.951f, -0.49f, 1.482f)
                curveToRelative(-0.077f, 0.72f, -0.251f, 1.484f, 0.045f, 2.178f)
                curveToRelative(0.083f, 0.269f, 0.406f, 0.379f, 0.644f, 0.238f)
                curveToRelative(0.497f, -0.255f, 0.855f, -0.705f, 1.193f, -1.138f)
                curveToRelative(0.333f, -0.435f, 0.575f, -0.931f, 0.814f, -1.421f)
                curveToRelative(0.188f, -0.436f, 0.298f, -0.902f, 0.408f, -1.362f)
                curveToRelative(0.076f, -0.629f, 0.041f, -1.274f, -0.102f, -1.891f)
                curveToRelative(-0.045f, -0.125f, -0.073f, -0.323f, -0.224f, -0.357f)
                close()
            }
            path(fill = SolidColor(Color(0xFF4F3E26))) {
                moveToRelative(26.923f, 13.144f)
                curveToRelative(0.271f, 0.098f, 0.593f, 1.557f, 0.524f, 1.663f)
                curveToRelative(-0.122f, 0.189f, -0.354f, 0.078f, -0.54f, 0.026f)
                curveToRelative(-0.468f, -0.132f, -2.162f, -0.914f, -2.559f, -1.11f)
                curveToRelative(-0.378f, -0.187f, -0.754f, -0.398f, -1.106f, -0.625f)
                curveToRelative(-0.268f, -0.173f, -0.526f, -0.361f, -0.805f, -0.52f)
                curveToRelative(-0.248f, -0.141f, -0.401f, -0.266f, -0.32f, -0.548f)
                curveToRelative(0.068f, -0.235f, 0.186f, -0.685f, 0.5f, -0.704f)
                curveToRelative(0.218f, -0.013f, 0.544f, 0.067f, 0.748f, 0.131f)
                curveToRelative(0.948f, 0.299f, 1.865f, 0.927f, 3.557f, 1.687f)
                close()
            }
            path(fill = SolidColor(Color(0xFF382A1B))) {
                moveToRelative(20.336f, 12.893f)
                curveToRelative(0.379f, -0.032f, 0.397f, -0.676f, 0.461f, -0.927f)
                curveToRelative(0.106f, -0.417f, 0.437f, -0.732f, 0.912f, -0.779f)
                curveToRelative(0.433f, -0.043f, 0.821f, -0.006f, 0.838f, 0.455f)
                curveToRelative(0.016f, 0.462f, -0.058f, 0.982f, -0.463f, 1.279f)
                curveToRelative(-0.515f, 0.378f, -1.036f, 0.478f, -1.748f, -0.028f)
                close()
            }
        }
        path(fill = SolidColor(Color(0xFF4F3E26))) {
            moveToRelative(15.219f, 19.324f)
            curveToRelative(0.302f, -0.829f, 0.086f, -1.788f, 0.336f, -2.689f)
            curveToRelative(0.182f, -1.115f, 0.26f, -2.251f, 0.474f, -3.356f)
            curveToRelative(0.14f, -0.891f, 0.95f, -1.405f, 1.752f, -1.589f)
            curveToRelative(0.661f, 0.308f, 1.613f, 0.318f, 2.29f, 0.077f)
            curveToRelative(0.757f, 0.041f, 1.616f, 0.631f, 1.745f, 1.456f)
            curveToRelative(-0.749f, 1.362f, -0.246f, 3.006f, -0.773f, 4.422f)
            curveToRelative(-0.041f, 0.563f, -1.327f, 0.801f, -0.435f, 1.016f)
            curveToRelative(0.723f, 0.562f, 0.59f, 1.927f, -0.275f, 2.281f)
            curveToRelative(0.646f, 0.471f, 0.666f, 1.641f, -0.149f, 1.949f)
            curveToRelative(1.13f, 0.496f, 0.574f, 1.888f, -0.358f, 2.229f)
            curveToRelative(0.794f, 0.521f, 1.025f, 1.586f, 0.556f, 2.405f)
            curveToRelative(-0.315f, 0.267f, -0.624f, 0.208f, -0.203f, 0.545f)
            curveToRelative(0.472f, 0.826f, 0.582f, 2.011f, -0.032f, 2.792f)
            curveToRelative(-0.908f, 0.284f, 0.066f, 1.312f, -0.261f, 2.052f)
            curveToRelative(0.034f, 0.689f, -0.755f, 1.892f, -0.467f, 2.151f)
            curveToRelative(0.526f, -0.19f, 0.658f, -0.07f, 0.122f, 0.204f)
            curveToRelative(-0.943f, 0.547f, -2.212f, 0.179f, -2.804f, -0.714f)
            curveToRelative(-0.639f, -0.613f, -1.34f, -1.262f, -1.624f, -2.122f)
            curveToRelative(-0.347f, -2.666f, -0.172f, -5.36f, -0.144f, -8.039f)
            curveToRelative(0.063f, -1.689f, 0.06f, -3.388f, 0.252f, -5.067f)
            close()
        }
        path(fill = SolidColor(Color(0xFF443421))) {
            moveToRelative(19.666f, 31.109f)
            curveToRelative(1.234f, -0.189f, 1.071f, -2.798f, 0.229f, -3.329f)
            curveToRelative(0.623f, -0.099f, 0.664f, -0.586f, 0.703f, -1.115f)
            curveToRelative(0.065f, -0.887f, -0.227f, -0.982f, -0.773f, -1.547f)
            curveToRelative(0.351f, -0.403f, 0.832f, -0.394f, 0.975f, -0.992f)
            curveToRelative(0.121f, -0.505f, -0.136f, -1.056f, -0.616f, -1.237f)
            curveToRelative(0.865f, -0.391f, 0.77f, -1.434f, 0.149f, -1.949f)
            curveToRelative(0.718f, -0.267f, 0.933f, -1.316f, 0.559f, -1.96f)
            curveToRelative(-0.145f, -0.25f, -0.376f, -0.44f, -0.704f, -0.497f)
            curveToRelative(0.042f, -0.019f, 0.08f, -0.041f, 0.119f, -0.062f)
            curveToRelative(0.976f, -0.525f, 0.968f, -1.562f, 1.012f, -2.551f)
            curveToRelative(0.026f, -0.586f, 0.077f, -1.996f, 0.499f, -2.649f)
            curveToRelative(0.078f, 0.228f, 0.138f, 0.45f, 0.135f, 0.718f)
            curveToRelative(-0.003f, 0.356f, 0.401f, 4.102f, 0.388f, 4.512f)
            curveToRelative(-0.006f, 0.188f, -0.023f, 0.346f, -0.105f, 0.45f)
            curveToRelative(0.078f, 0.14f, 0.14f, 0.318f, 0.196f, 0.548f)
            curveToRelative(0.159f, 0.659f, 0.017f, 10.259f, -0.239f, 11.832f)
            curveToRelative(-0.088f, 0.537f, -0.106f, 0.732f, -0.189f, 1.27f)
            curveToRelative(-0.062f, 0.403f, -0.838f, 1.346f, -1.71f, 2.063f)
            curveToRelative(-0.098f, 0.115f, -0.202f, 0.228f, -0.317f, 0.333f)
            curveToRelative(-0.429f, 0.339f, -1.049f, 0.713f, -0.74f, 0.17f)
            curveToRelative(0.49f, -1.421f, 0.998f, -2.49f, 0.431f, -4.01f)
            close()
        }
        path(fill = SolidColor(Color(0xFF2D2316))) {
            moveToRelative(21.879f, 20.915f)
            curveToRelative(-0.523f, -0.078f, -1.05f, -0.126f, -1.578f, -0.161f)
            curveToRelative(-0.528f, -0.037f, -1.056f, -0.049f, -1.585f, -0.053f)
            curveToRelative(-0.529f, 0.001f, -1.057f, 0.01f, -1.584f, 0.039f)
            lineToRelative(-0.791f, 0.047f)
            curveToRelative(-0.263f, 0.024f, -0.527f, 0.041f, -0.79f, 0.072f)
            curveToRelative(0.264f, 0.016f, 0.528f, 0.018f, 0.792f, 0.029f)
            lineToRelative(0.791f, 0.011f)
            lineToRelative(1.581f, 0.008f)
            lineToRelative(1.58f, 0.004f)
            curveToRelative(0.527f, 0.002f, 1.054f, 0.01f, 1.583f, 0.003f)
            close()
        }
        path(fill = SolidColor(Color(0xFF2D2316))) {
            moveToRelative(21.904f, 22.763f)
            curveToRelative(-0.527f, -0.052f, -1.053f, -0.086f, -1.58f, -0.116f)
            curveToRelative(-0.527f, -0.033f, -1.055f, -0.047f, -1.583f, -0.055f)
            curveToRelative(-0.528f, -0.004f, -1.056f, -0.002f, -1.584f, 0.019f)
            curveToRelative(-0.528f, 0.019f, -1.055f, 0.046f, -1.582f, 0.097f)
            curveToRelative(0.264f, 0.02f, 0.528f, 0.025f, 0.792f, 0.04f)
            lineToRelative(0.791f, 0.022f)
            curveToRelative(0.527f, 0.016f, 1.054f, 0.02f, 1.581f, 0.028f)
            curveToRelative(0.527f, 0.004f, 1.053f, 0.012f, 1.581f, 0.007f)
            curveToRelative(0.528f, -0.003f, 1.056f, -0.009f, 1.584f, -0.042f)
            close()
        }
        path(fill = SolidColor(Color(0xFF2D2316))) {
            moveToRelative(21.725f, 25.335f)
            curveToRelative(-0.499f, -0.063f, -0.999f, -0.103f, -1.5f, -0.137f)
            curveToRelative(-0.501f, -0.036f, -1.002f, -0.052f, -1.504f, -0.063f)
            curveToRelative(-0.502f, -0.006f, -1.004f, -0.005f, -1.506f, 0.021f)
            lineToRelative(-0.752f, 0.046f)
            curveToRelative(-0.25f, 0.025f, -0.5f, 0.046f, -0.749f, 0.082f)
            curveToRelative(0.251f, 0.011f, 0.502f, 0.01f, 0.753f, 0.019f)
            lineToRelative(0.751f, 0.011f)
            lineToRelative(1.501f, 0.026f)
            curveToRelative(0.5f, 0.005f, 1.001f, 0.016f, 1.502f, 0.014f)
            curveToRelative(0.501f, 0.001f, 1.003f, 0.001f, 1.505f, -0.021f)
            close()
        }
        path(fill = SolidColor(Color(0xFF2D2316))) {
            moveToRelative(21.672f, 27.966f)
            curveToRelative(-0.511f, -0.052f, -1.022f, -0.092f, -1.532f, -0.132f)
            curveToRelative(-0.51f, -0.042f, -1.022f, -0.072f, -1.536f, -0.09f)
            curveToRelative(-0.513f, -0.014f, -1.029f, -0.014f, -1.542f, 0.023f)
            curveToRelative(-0.257f, 0.019f, -0.513f, 0.043f, -0.768f, 0.074f)
            curveToRelative(-0.255f, 0.038f, -0.509f, 0.076f, -0.76f, 0.13f)
            curveToRelative(0.257f, -0.008f, 0.512f, -0.025f, 0.768f, -0.029f)
            curveToRelative(0.255f, -0.01f, 0.511f, -0.016f, 0.766f, -0.016f)
            curveToRelative(0.51f, 0f, 1.02f, 0.006f, 1.531f, 0.024f)
            curveToRelative(0.511f, 0.013f, 1.022f, 0.037f, 1.535f, 0.042f)
            curveToRelative(0.513f, 0.007f, 1.026f, 0.008f, 1.54f, -0.025f)
            close()
        }
        path(fill = SolidColor(Color(0xFF2D2316))) {
            moveToRelative(21.353f, 31.152f)
            curveToRelative(-0.49f, -0.05f, -0.978f, -0.092f, -1.467f, -0.134f)
            curveToRelative(-0.489f, -0.043f, -0.982f, -0.07f, -1.473f, -0.073f)
            curveToRelative(-0.491f, 0.012f, -0.983f, 0.024f, -1.474f, 0.052f)
            lineToRelative(-0.736f, 0.043f)
            curveToRelative(-0.245f, 0.022f, -0.49f, 0.037f, -0.735f, 0.065f)
            curveToRelative(0.246f, 0.019f, 0.491f, 0.024f, 0.736f, 0.036f)
            lineToRelative(0.735f, 0.015f)
            curveToRelative(0.49f, 0.009f, 0.98f, 0.002f, 1.47f, -0.005f)
            curveToRelative(0.49f, -0.002f, 0.978f, 0.019f, 1.469f, 0.025f)
            lineToRelative(0.737f, 0.006f)
            curveToRelative(0.246f, -0.007f, 0.492f, -0.01f, 0.738f, -0.029f)
            close()
        }
        path(fill = SolidColor(Color(0xFF2D2316))) {
            moveToRelative(21.732f, 18.547f)
            curveToRelative(-0.242f, -0.05f, -0.487f, -0.087f, -0.731f, -0.129f)
            curveToRelative(-0.245f, -0.034f, -0.49f, -0.065f, -0.736f, -0.092f)
            curveToRelative(-0.492f, -0.055f, -0.987f, -0.08f, -1.483f, -0.086f)
            curveToRelative(-0.496f, -0.002f, -0.992f, 0.018f, -1.485f, 0.079f)
            curveToRelative(-0.246f, 0.028f, -0.492f, 0.067f, -0.735f, 0.112f)
            curveToRelative(-0.243f, 0.05f, -0.484f, 0.107f, -0.721f, 0.178f)
            curveToRelative(0.247f, -0.025f, 0.49f, -0.062f, 0.736f, -0.078f)
            curveToRelative(0.244f, -0.024f, 0.489f, -0.045f, 0.734f, -0.054f)
            curveToRelative(0.49f, -0.022f, 0.98f, -0.037f, 1.47f, -0.031f)
            curveToRelative(0.491f, 0.001f, 0.981f, 0.021f, 1.473f, 0.038f)
            curveToRelative(0.492f, 0.019f, 0.984f, 0.051f, 1.479f, 0.064f)
            close()
        }
    }.build()
}