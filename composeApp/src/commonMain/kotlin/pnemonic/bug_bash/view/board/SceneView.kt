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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.ImageBitmapConfig
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import org.jetbrains.compose.resources.imageResource
import pnemonic.bug_bash.model.Scene
import pnemonic.bug_bash.view.isZero
import pnemonic.bug_bash.view.orientation
import pnemonic.bug_bash.view.rotate
import pnemonic.bug_bash.view.toDp
import pnemonic.bug_bash.view.toOrientation

@Composable
fun SceneView(
    modifier: Modifier = Modifier,
    scene: Scene,
    content: @Composable BoxScope.() -> Unit,
) {
    var size by remember { mutableStateOf(IntSize.Zero) }

    Box(modifier = modifier.onSizeChanged { size = it }) {
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
        val srcSize = IntSize(image.width, image.height)
        val dstSize = srcSize.rotate()
        val pivot = dstSize.width / 2f
        val bitmap = ImageBitmap(dstSize.width, dstSize.height, ImageBitmapConfig.Rgb565)
        Canvas(bitmap).apply {
            rotate(90f, pivot, pivot)
            drawImageRect(
                image = image,
                srcOffset = IntOffset.Zero,
                srcSize = srcSize,
                dstOffset = IntOffset.Zero,
                dstSize = srcSize,
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

@Composable
@Preview(widthDp = 500, heightDp = 300, backgroundColor = 0xFF00FF00)
private fun SceneKitchen_Landscape() {
    SceneView(
        modifier = Modifier.fillMaxSize(),
        scene = Scene.Kitchen
    ) {}
}

@Composable
@Preview(widthDp = 300, heightDp = 500, backgroundColor = 0xFF0000FF)
private fun SceneKitchen_Portrait() {
    SceneView(
        modifier = Modifier.fillMaxSize(),
        scene = Scene.Kitchen
    ) {}
}
