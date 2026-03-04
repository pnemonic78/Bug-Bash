package pnemonic.bug_bash.view.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import pnemonic.BooleanCallback
import pnemonic.VoidCallback
import pnemonic.bug_bash.model.Scene
import pnemonic.bug_bash.view.board.SceneView
import pnemonic.bug_bash.view.previewHeightDp
import pnemonic.bug_bash.view.previewWidthDp

@Composable
fun HomeScreen(navController: NavHostController) {
    val lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current
    //FIXME for JVM val viewModel = viewModel<HomeViewModel>()
    val viewModel = viewModel { HomeViewModel() }

    HomeScreen(
        onPlayClick = { viewModel.onPlayClick(navController) },
        isSoundEnabled = viewModel.isSoundEnabled,
        onSoundChange = viewModel::onSoundChange,
        isMusicEnabled = viewModel.isMusicEnabled,
        onMusicChange = viewModel::onMusicChange,
        onHelpClick = { viewModel.onHelpClick(navController) }
    )

    DisposableEffect(lifecycleOwner) {
        viewModel.observe(lifecycleOwner)

        onDispose {
            viewModel.onDispose(lifecycleOwner)
        }
    }
}

private val colorMask = Color(0xAA452716)

@Composable
private fun HomeScreen(
    onPlayClick: VoidCallback,
    isSoundEnabled: Boolean = true,
    onSoundChange: BooleanCallback,
    isMusicEnabled: Boolean = true,
    onMusicChange: BooleanCallback,
    onHelpClick: VoidCallback,
) {
    SceneView(
        modifier = Modifier.fillMaxSize(),
        scene = Scene.Grass,
    ) {
        Box(modifier = Modifier.fillMaxSize().background(color = colorMask))
        Title(
            modifier = Modifier.align(BiasAlignment(0f, -0.75f))
                .padding(24.dp)
        )
        StartButton(
            modifier = Modifier.align(BiasAlignment(0f, 0f))
                .padding(24.dp),
            onClick = onPlayClick
        )
        SettingsPanel(
            modifier = Modifier.align(BiasAlignment(0f, 0.5f)),
            isSoundEnabled = isSoundEnabled,
            onSoundChange = onSoundChange,
            isMusicEnabled = isMusicEnabled,
            onMusicChange = onMusicChange,
            onHelpClick = onHelpClick
        )
    }
}

@Composable
@Preview(widthDp = previewWidthDp, heightDp = previewHeightDp)
private fun Preview() {
    MaterialTheme {
        HomeScreen(
            onPlayClick = {},
            onSoundChange = {},
            onMusicChange = {},
            onHelpClick = {},
        )
    }
}