package pnemonic.bug_bash.drawable

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Touch: ImageVector
    get() {
        if (_Touch != null) {
            return _Touch!!
        }
        _Touch = ImageVector.Builder(
            name = "Touch",
            defaultWidth = 12.dp,
            defaultHeight = 23.dp,
            viewportWidth = 12f,
            viewportHeight = 23f
        ).apply {
            path(fill = SolidColor(Color(0xFF2E2E2E))) {
                moveToRelative(8.701f, -0f)
                lineToRelative(-8.007f, 0f)
                curveToRelative(-0.383f, 0f, -0.694f, 0.327f, -0.694f, 0.731f)
                lineToRelative(0f, 14.669f)
                curveToRelative(0f, 0.403f, 0.311f, 0.731f, 0.694f, 0.731f)
                lineToRelative(8.007f, 0f)
                curveToRelative(0.383f, 0f, 0.694f, -0.327f, 0.694f, -0.731f)
                lineToRelative(0f, -14.668f)
                curveToRelative(0f, -0.404f, -0.31f, -0.731f, -0.694f, -0.731f)
                close()
            }
            path(fill = SolidColor(Color(0xFF475059))) {
                moveTo(0.704f, 1.789f)
                lineToRelative(7.987f, 0f)
                lineToRelative(0f, 12.676f)
                lineToRelative(-7.987f, 0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF9BA4AB))) {
                moveToRelative(5.782f, 0.654f)
                lineToRelative(-2.169f, 0f)
                curveToRelative(-0.159f, 0f, -0.287f, 0.129f, -0.287f, 0.287f)
                curveToRelative(0f, 0.159f, 0.129f, 0.287f, 0.287f, 0.287f)
                lineToRelative(2.169f, 0f)
                curveToRelative(0.159f, 0f, 0.287f, -0.129f, 0.287f, -0.287f)
                curveToRelative(0f, -0.158f, -0.129f, -0.287f, -0.287f, -0.287f)
                close()
            }
            path(fill = SolidColor(Color(0xFF9BA4AB))) {
                moveToRelative(4.697f, 14.819f)
                curveToRelative(-0.248f, 0f, -0.45f, 0.201f, -0.45f, 0.449f)
                curveToRelative(0f, 0.248f, 0.201f, 0.449f, 0.45f, 0.449f)
                curveToRelative(0.248f, 0f, 0.45f, -0.201f, 0.45f, -0.449f)
                curveToRelative(0f, -0.248f, -0.201f, -0.449f, -0.45f, -0.449f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF24292E)),
                fillAlpha = 0.4f,
                strokeAlpha = 0.4f
            ) {
                moveToRelative(5.591f, 0.739f)
                lineToRelative(-1.817f, 0f)
                curveToRelative(-0.133f, 0f, -0.241f, 0.09f, -0.241f, 0.202f)
                curveToRelative(0f, 0.111f, 0.108f, 0.202f, 0.241f, 0.202f)
                lineToRelative(1.817f, 0f)
                curveToRelative(0.133f, 0f, 0.241f, -0.09f, 0.241f, -0.202f)
                curveToRelative(-0f, -0.111f, -0.108f, -0.202f, -0.241f, -0.202f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF6E6E6E),
                        0.261f to Color(0xFF777777),
                        0.692f to Color(0xFF909090),
                        1f to Color(0xFFA6A6A6)
                    ),
                    start = Offset(4.772f, 8.104f),
                    end = Offset(-0.871f, 4.9f)
                )
            ) {
                moveToRelative(0.694f, -0f)
                curveToRelative(-0.383f, 0f, -0.694f, 0.327f, -0.694f, 0.731f)
                lineToRelative(0f, 14.669f)
                curveToRelative(0f, 0.246f, 0.116f, 0.462f, 0.292f, 0.595f)
                lineTo(9.174f, 0.197f)
                curveToRelative(-0.124f, -0.122f, -0.29f, -0.197f, -0.473f, -0.197f)
                close()
            }
            path(fill = SolidColor(Color(0xFF79B3CC))) {
                moveToRelative(4.697f, 7.821f)
                curveToRelative(-0.834f, 0f, -1.512f, -0.678f, -1.512f, -1.512f)
                curveToRelative(0f, -0.834f, 0.678f, -1.512f, 1.512f, -1.512f)
                curveToRelative(0.834f, 0f, 1.512f, 0.678f, 1.512f, 1.512f)
                curveToRelative(0f, 0.834f, -0.678f, 1.512f, -1.512f, 1.512f)
                close()
                moveTo(4.697f, 5.114f)
                curveToRelative(-0.659f, 0f, -1.196f, 0.536f, -1.196f, 1.196f)
                curveToRelative(0f, 0.659f, 0.536f, 1.196f, 1.196f, 1.196f)
                curveToRelative(0.659f, 0f, 1.195f, -0.536f, 1.195f, -1.196f)
                curveToRelative(0f, -0.659f, -0.536f, -1.196f, -1.195f, -1.196f)
                close()
            }
            path(fill = SolidColor(Color(0xFF79B3CC))) {
                moveToRelative(4.697f, 8.487f)
                curveToRelative(-1.201f, 0f, -2.177f, -0.977f, -2.177f, -2.177f)
                curveToRelative(0f, -1.2f, 0.977f, -2.177f, 2.177f, -2.177f)
                curveToRelative(1.2f, 0f, 2.177f, 0.977f, 2.177f, 2.177f)
                curveToRelative(0f, 1.2f, -0.977f, 2.177f, -2.177f, 2.177f)
                close()
                moveTo(4.697f, 4.554f)
                curveToRelative(-0.968f, 0f, -1.755f, 0.787f, -1.755f, 1.755f)
                curveToRelative(0f, 0.968f, 0.787f, 1.755f, 1.755f, 1.755f)
                curveToRelative(0.968f, 0f, 1.755f, -0.787f, 1.755f, -1.755f)
                curveToRelative(0f, -0.968f, -0.787f, -1.755f, -1.755f, -1.755f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFBD95))) {
                moveToRelative(7.005f, 22.507f)
                curveToRelative(0f, 0f, -0.778f, -2.018f, -1.106f, -2.423f)
                curveToRelative(-0.329f, -0.405f, -0.808f, -1.053f, -1.031f, -1.331f)
                curveToRelative(-0.303f, -0.379f, -1.278f, -2.338f, -1.321f, -2.516f)
                curveToRelative(-0.291f, -1.195f, -0.904f, -2.595f, -1.069f, -2.851f)
                curveToRelative(-0.297f, -0.461f, -0.986f, -0.752f, -0.885f, -1.037f)
                curveToRelative(0.099f, -0.278f, 1.113f, -0.582f, 1.77f, 0.076f)
                curveToRelative(0.657f, 0.657f, 1.34f, 2.276f, 1.34f, 2.276f)
                curveToRelative(0f, 0f, 0.051f, -0.86f, 0f, -1.416f)
                curveToRelative(-0.051f, -0.556f, -0.348f, -3.101f, -0.398f, -3.632f)
                curveToRelative(-0.051f, -0.531f, -0.234f, -2.665f, -0.209f, -2.994f)
                curveToRelative(0.025f, -0.329f, -0.031f, -0.944f, 0.531f, -1.012f)
                curveToRelative(0.521f, -0.063f, 0.673f, 0.48f, 0.749f, 1.037f)
                curveToRelative(0.076f, 0.556f, 0.244f, 2.245f, 0.351f, 2.931f)
                curveToRelative(0.103f, 0.661f, 0.266f, 1.985f, 0.417f, 2.238f)
                curveToRelative(0.152f, 0.253f, 0.484f, 0.36f, 0.484f, 0.36f)
                curveToRelative(0f, 0f, 0.137f, -0.71f, 0.199f, -1.043f)
                curveToRelative(0.028f, -0.151f, 0.133f, -0.768f, 0.759f, -0.743f)
                curveToRelative(0.586f, 0.024f, 0.708f, 0.759f, 0.708f, 0.759f)
                curveToRelative(0f, 0f, 0.196f, -0.142f, 0.456f, -0.098f)
                curveToRelative(0.278f, 0.047f, 0.436f, 0.225f, 0.511f, 0.553f)
                curveToRelative(0.029f, 0.126f, 0.07f, 0.455f, 0.07f, 0.455f)
                curveToRelative(0f, 0f, 0.183f, -0.139f, 0.436f, -0.063f)
                curveToRelative(0.253f, 0.076f, 0.348f, 0.443f, 0.398f, 0.645f)
                curveToRelative(0.051f, 0.202f, 0.379f, 1.669f, 0.405f, 2.2f)
                curveToRelative(0.025f, 0.531f, -0.354f, 3.161f, -0.303f, 3.566f)
                curveToRelative(0.051f, 0.405f, 1.694f, 4.063f, 1.694f, 4.063f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFC8A7))) {
                moveToRelative(4.627f, 5.647f)
                curveToRelative(0.251f, -0.033f, 0.405f, 0.095f, 0.487f, 0.234f)
                curveToRelative(0.082f, 0.139f, 0.112f, 0.873f, 0.043f, 0.98f)
                curveToRelative(-0.07f, 0.107f, -0.669f, 0.206f, -0.783f, 0.12f)
                curveToRelative(-0.152f, -0.114f, -0.19f, -0.765f, -0.171f, -0.949f)
                curveToRelative(0.019f, -0.184f, 0.133f, -0.348f, 0.424f, -0.386f)
                close()
            }
            path(fill = SolidColor(Color(0xFFF9A983))) {
                moveToRelative(3.65f, 12.766f)
                curveToRelative(0f, 0f, 0.493f, 0.718f, 0.895f, 1.582f)
                curveToRelative(0.057f, 0.123f, 0.158f, 0.352f, 0.158f, 0.352f)
                curveToRelative(0f, 0f, -0.209f, 0.635f, -0.245f, 0.938f)
                curveToRelative(-0.036f, 0.303f, 0.088f, 0.918f, 0.088f, 0.918f)
                curveToRelative(0f, 0f, -0.358f, -0.504f, -0.297f, -1.187f)
                curveToRelative(0.047f, -0.527f, 0.075f, -0.804f, 0.066f, -0.989f)
                curveToRelative(-0.026f, -0.514f, -0.664f, -1.614f, -0.664f, -1.614f)
                close()
            }
            path(fill = SolidColor(Color(0xFFF9A983))) {
                moveToRelative(8.294f, 11.185f)
                curveToRelative(0f, 0f, -0.08f, 1.257f, -0.03f, 1.514f)
                curveToRelative(0.056f, 0.287f, 0.179f, 0.482f, 0.284f, 0.482f)
                curveToRelative(0.147f, 0f, 0.161f, -0.228f, 0.085f, -0.56f)
                curveToRelative(-0.076f, -0.332f, -0.339f, -1.436f, -0.339f, -1.436f)
                close()
            }
            path(fill = SolidColor(Color(0xFFF9A983))) {
                moveToRelative(9.331f, 12.096f)
                curveToRelative(0f, 0f, -0.001f, 0.839f, 0.07f, 1.104f)
                curveToRelative(0.071f, 0.266f, 0.123f, 0.408f, 0.237f, 0.432f)
                curveToRelative(0.114f, 0.024f, 0.147f, -0.104f, 0.104f, -0.303f)
                curveToRelative(-0.081f, -0.381f, -0.412f, -1.232f, -0.412f, -1.232f)
                close()
            }
            path(fill = SolidColor(Color(0xFFF9A983))) {
                moveToRelative(6.104f, 11.76f)
                curveToRelative(0f, 0f, 0.043f, 0.308f, 0.211f, 0.492f)
                curveToRelative(0.167f, 0.185f, 0.29f, 0.202f, 0.29f, 0.202f)
                lineToRelative(0.024f, -0.242f)
                curveToRelative(0f, 0f, -0.161f, -0.07f, -0.276f, -0.144f)
                curveToRelative(-0.185f, -0.118f, -0.248f, -0.308f, -0.248f, -0.308f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFD3B9))) {
                moveToRelative(4.374f, 6.981f)
                curveToRelative(0f, 0f, 0f, 0f, 0f, 0.001f)
                curveToRelative(0.11f, 0.083f, 0.678f, -0.007f, 0.774f, -0.111f)
                curveToRelative(-0.073f, -0.033f, -0.227f, -0.088f, -0.422f, -0.062f)
                curveToRelative(-0.211f, 0.028f, -0.316f, 0.128f, -0.352f, 0.172f)
                close()
            }
            path(fill = SolidColor(Color(0xFFF9A983))) {
                moveToRelative(7.018f, 20.373f)
                curveToRelative(-0.475f, -0.607f, -1.213f, -1.108f, -1.82f, -1.767f)
                curveToRelative(-0.607f, -0.659f, -1.305f, -2.092f, -1.398f, -2.433f)
                curveToRelative(-0.31f, -1.141f, -0.856f, -2.311f, -1.055f, -2.584f)
                curveToRelative(-0.402f, -0.554f, 0.145f, -0.699f, -0.518f, -0.493f)
                curveToRelative(0.094f, 0.089f, 0.182f, 0.185f, 0.25f, 0.29f)
                curveToRelative(0.165f, 0.256f, 0.778f, 1.657f, 1.069f, 2.851f)
                curveToRelative(0.043f, 0.179f, 1.018f, 2.137f, 1.321f, 2.516f)
                curveToRelative(0.223f, 0.278f, 0.702f, 0.926f, 1.031f, 1.331f)
                curveToRelative(0.329f, 0.405f, 1.106f, 2.423f, 1.106f, 2.423f)
                lineToRelative(0.949f, 0f)
                curveToRelative(-0.197f, -0.67f, -0.6f, -1.704f, -0.936f, -2.134f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFC8A7))) {
                moveToRelative(2.389f, 13.246f)
                curveToRelative(0.047f, -0.005f, 0.213f, -0.209f, 0.204f, -0.251f)
                curveToRelative(-0.01f, -0.043f, -0.493f, -0.579f, -0.706f, -0.621f)
                curveToRelative(-0.214f, -0.043f, -0.384f, 0.01f, -0.394f, 0.062f)
                curveToRelative(-0.01f, 0.052f, 0.849f, 0.816f, 0.896f, 0.811f)
                close()
            }
            path(fill = SolidColor(Color(0xFFF99C94))) {
                moveToRelative(10.571f, 14.878f)
                curveToRelative(-0.025f, -0.531f, -0.354f, -1.998f, -0.405f, -2.2f)
                curveToRelative(-0.051f, -0.202f, -0.146f, -0.569f, -0.398f, -0.645f)
                curveToRelative(-0.253f, -0.076f, -0.436f, 0.063f, -0.436f, 0.063f)
                curveToRelative(0f, 0f, -0.04f, -0.33f, -0.07f, -0.455f)
                curveToRelative(-0.076f, -0.329f, -0.233f, -0.506f, -0.511f, -0.553f)
                curveToRelative(-0.26f, -0.044f, -0.456f, 0.098f, -0.456f, 0.098f)
                curveToRelative(0f, 0f, -0.02f, -0.116f, -0.08f, -0.257f)
                curveToRelative(-0.911f, 1.382f, -1.443f, 3.037f, -1.443f, 4.816f)
                curveToRelative(0f, 2.723f, 1.241f, 5.155f, 3.189f, 6.763f)
                lineToRelative(2.001f, 0f)
                curveToRelative(0f, 0f, -1.644f, -3.659f, -1.694f, -4.063f)
                curveToRelative(-0.051f, -0.405f, 0.328f, -3.035f, 0.303f, -3.566f)
                close()
            }
        }.build()

        return _Touch!!
    }

@Suppress("ObjectPropertyName")
private var _Touch: ImageVector? = null
