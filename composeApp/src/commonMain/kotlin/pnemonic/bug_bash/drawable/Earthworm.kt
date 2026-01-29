package pnemonic.bug_bash.drawable

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Earthworm: ImageVector
    get() {
        if (_Earthworm != null) {
            return _Earthworm!!
        }
        _Earthworm = ImageVector.Builder(
            name = "Earthworm",
            defaultWidth = 10.dp,
            defaultHeight = 42.4.dp,
            viewportWidth = 10f,
            viewportHeight = 42.4f,
            tintColor = Color.Magenta
        ).apply {
            path(
                fill = SolidColor(Color(0xFF1D262D)),
                strokeLineWidth = 0.264583f
            ) {
                moveToRelative(4.661f, 41.051f)
                curveToRelative(2.084f, -2.502f, 2.515f, -5.955f, 3.349f, -8.992f)
                curveToRelative(0.822f, -2.994f, 2.095f, -5.983f, 1.805f, -9.074f)
                curveToRelative(-0.14f, -1.488f, -0.637f, -2.899f, -1.288f, -4.252f)
                curveToRelative(0.007f, -0.004f, 0.014f, -0.009f, 0.021f, -0.014f)
                curveToRelative(0.102f, -0.071f, 0.164f, -0.168f, 0.205f, -0.279f)
                curveToRelative(0.039f, -0.104f, 0.023f, -0.222f, -0.032f, -0.32f)
                curveToRelative(-0.712f, -1.268f, -1.368f, -2.52f, -2.074f, -3.786f)
                curveToRelative(-0.111f, -0.199f, -0.378f, -0.256f, -0.564f, -0.105f)
                curveToRelative(-0.046f, 0.037f, -0.107f, 0.028f, -0.137f, -0.023f)
                curveToRelative(-0.935f, -1.598f, -1.787f, -3.242f, -2.198f, -5.038f)
                curveToRelative(-0.565f, -2.469f, -0.124f, -5.344f, 1.784f, -7.01f)
                curveToRelative(0.381f, -0.333f, 0.826f, -0.629f, 1.023f, -1.099f)
                curveToRelative(0.233f, -0.557f, -0.242f, -1.135f, -0.84f, -1.051f)
                curveToRelative(-1.961f, 0.274f, -3.647f, 1.798f, -4.407f, 3.643f)
                curveToRelative(-0.805f, 1.954f, -0.69f, 4.192f, -0.086f, 6.217f)
                curveToRelative(0.566f, 1.9f, 1.535f, 3.648f, 2.539f, 5.36f)
                curveToRelative(0.02f, 0.035f, 0.005f, 0.072f, -0.031f, 0.09f)
                curveToRelative(-0.192f, 0.097f, -0.262f, 0.336f, -0.152f, 0.527f)
                curveToRelative(0.014f, 0.024f, 0.028f, 0.049f, 0.042f, 0.074f)
                curveToRelative(0.665f, 1.207f, 1.409f, 2.745f, 2.089f, 4.014f)
                curveToRelative(0.116f, 0.217f, 0.389f, 0.295f, 0.607f, 0.17f)
                curveToRelative(0.037f, -0.021f, 0.085f, -0.005f, 0.102f, 0.034f)
                curveToRelative(0.152f, 0.351f, 0.295f, 0.706f, 0.423f, 1.067f)
                curveToRelative(1.047f, 2.972f, 0.43f, 6.193f, -0.431f, 9.224f)
                curveToRelative(-0.78f, 2.748f, -1.078f, 5.554f, -2.016f, 8.255f)
                curveToRelative(-0.122f, 0.351f, -0.261f, 0.702f, -0.484f, 0.999f)
                curveToRelative(-0.73f, 0.973f, -1.795f, 0.808f, -2.121f, -0.334f)
                curveToRelative(-0.846f, -2.963f, 0.458f, -7.039f, 2.276f, -9.527f)
                curveToRelative(0.384f, -0.526f, 0.847f, -1.141f, 0.57f, -1.768f)
                curveToRelative(-0.21f, -0.476f, -0.757f, -0.704f, -1.264f, -0.589f)
                curveToRelative(-0.935f, 0.212f, -1.381f, 1.059f, -1.721f, 1.867f)
                curveToRelative(-1.228f, 2.916f, -1.786f, 6.112f, -1.619f, 9.271f)
                curveToRelative(0.081f, 1.524f, 0.668f, 3.967f, 2.699f, 3.715f)
                curveToRelative(0.753f, -0.094f, 1.382f, -0.619f, 1.874f, -1.197f)
                curveToRelative(0.02f, -0.023f, 0.04f, -0.047f, 0.059f, -0.07f)
                close()
            }
        }.build()

        return _Earthworm!!
    }

@Suppress("ObjectPropertyName")
private var _Earthworm: ImageVector? = null
