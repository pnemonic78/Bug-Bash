package pnemonic.bug_squash.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import pnemonic.bug_squash.model.Scene

@Composable
fun SceneView(
    modifier: Modifier = Modifier,
    scene: Scene,
    content: @Composable BoxScope.() -> Unit,
) {
    Box(modifier = modifier) {
        when (scene) {
            Scene.Kitchen -> SceneKitchen()
            Scene.Table -> SceneTable()
            Scene.Garden -> SceneGarden()
        }
        content()
    }
}

@Composable
private fun SceneKitchen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Blue)
    )
}

@Composable
private fun SceneTable(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Red)
    )
}

@Composable
private fun SceneGarden(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Green)
    )
}
