package pnemonic.bug_bash.view.board

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.ImageBitmapConfig
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.toIntSize
import org.jetbrains.compose.resources.imageResource
import pnemonic.bug_bash.model.Scene
import pnemonic.bug_bash.view.OrientationPreviews
import pnemonic.compose.isZero
import pnemonic.compose.orientation
import pnemonic.compose.times
import pnemonic.compose.toDp
import pnemonic.compose.toOrientation
import pnemonic.half
import kotlin.math.max

@Composable
fun SceneView(
    modifier: Modifier = Modifier,
    scene: Scene,
    content: @Composable BoxScope.() -> Unit,
) {
    var size by remember { mutableStateOf(IntSize.Zero) }

    Box(
        modifier = modifier.onSizeChanged { size = it },
        contentAlignment = AbsoluteAlignment.TopLeft
    ) {
        SceneBackground(scene = scene, size = size)
        content()
    }
}

@Composable
private fun SceneBackground(modifier: Modifier = Modifier, scene: Scene, size: IntSize) {
    if (size.isZero()) return
    val sizeDp = size.toDp()
    val screenOrientation = size.toOrientation()
    val image = imageResource(scene.image)
    val imageOrientation = image.orientation

    if (screenOrientation == imageOrientation) {
        Image(
            modifier = modifier.size(sizeDp),
            bitmap = image,
            contentScale = ContentScale.Crop,
            contentDescription = scene.name
        )
    } else {
        val sizeWidth = size.width.toFloat()
        val scaleX = sizeWidth / image.height.toFloat()
        val scaleY = size.height.toFloat() / image.width.toFloat()
        val scale = max(scaleX, scaleY)
        val srcSize = IntSize(image.width, image.height)
        val dstSize = (srcSize * scale).toIntSize()
        val pivot = size.width.half.toFloat()
        val flipHorizontal = scene.flipPortraitHorizontal
        val bitmap = ImageBitmap(size.width, size.height, ImageBitmapConfig.Rgb565)
        Canvas(bitmap).apply {
            rotate(90f, pivot, pivot)
            if (flipHorizontal) {
                scale(1f, -1f)
                translate(0f, -sizeWidth)
            }
            drawImageRect(
                image = image,
                srcOffset = IntOffset.Zero,
                srcSize = srcSize,
                dstOffset = IntOffset.Zero,
                dstSize = dstSize,
                paint = Paint()
            )
        }
        Image(
            modifier = modifier.size(sizeDp),
            bitmap = bitmap,
            contentScale = ContentScale.Crop,
            contentDescription = scene.name
        )
    }
}

class ScenePreviewParameterProvider : PreviewParameterProvider<Scene> {
    override val values: Sequence<Scene> = Scene.entries.asSequence()
}

@Composable
@OrientationPreviews
private fun Preview(
    @PreviewParameter(ScenePreviewParameterProvider::class) scene: Scene
) {
    SceneView(
        modifier = Modifier.fillMaxSize(),
        scene = scene
    ) {}
}
