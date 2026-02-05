package pnemonic.bug_bash.view.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import pnemonic.bug_bash.model.Scene
import pnemonic.bug_bash.view.board.SceneView

@Composable
fun HomeScreen(navController: NavHostController) {
    val lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current
    //FIXME for JVM val viewModel = viewModel<HomeViewModel>()
    val viewModel = viewModel { HomeViewModel() }

    SceneView(
        modifier = Modifier.fillMaxSize(),
        scene = Scene.Beach,
    ) {
        Box(modifier = Modifier.fillMaxSize().background(color = Color.Black.copy(alpha = 0.5f)))
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(0.25f))
            Title(modifier = Modifier.fillMaxWidth().padding(36.dp))
            Spacer(modifier = Modifier.weight(0.25f))
            StartButton(
                modifier = Modifier.padding(36.dp),
                onClick = { viewModel.onPlayClick(navController) }
            )
            Spacer(modifier = Modifier.weight(0.25f))
            SettingsPanel(
                isSoundEnabled = viewModel.isSoundEnabled,
                onSoundChange = viewModel::onSoundChange,
                isMusicEnabled = viewModel.isMusicEnabled,
                onMusicChange = viewModel::onMusicChange,
                onHelpClick = { viewModel.onHelpClick(navController) }
            )
            Spacer(modifier = Modifier.weight(0.25f))
        }
    }

    DisposableEffect(lifecycleOwner) {
        viewModel.observe(lifecycleOwner)

        onDispose {
            viewModel.onDispose(lifecycleOwner)
        }
    }
}

@Composable
@Preview(widthDp = 400, heightDp = 600)
private fun Preview() {
    val navController = rememberNavController()

    MaterialTheme {
        HomeScreen(navController)
    }
}