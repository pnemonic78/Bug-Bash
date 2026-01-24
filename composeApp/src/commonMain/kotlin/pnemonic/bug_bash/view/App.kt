package pnemonic.bug_bash.view

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import pnemonic.bug_bash.control.GameViewModel

@Composable
fun App() {
    val lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current
    val viewModel = viewModel<GameViewModel>()
    val board = viewModel.board.collectAsState()
    val state = viewModel.state.collectAsState()

    MaterialTheme {
        BoardView(
            board = board.value,
            state = state.value,
            onSize = viewModel::onSize,
            onBugSize = viewModel::onBugSize,
            onTap = viewModel::onTap,
            onDead = viewModel::onDead,
            onSoundChange = viewModel::onSoundChange,
            onMusicChange = viewModel::onMusicChange,
        )
    }

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_DESTROY -> viewModel.onDestroy()
                Lifecycle.Event.ON_PAUSE -> viewModel.onPause()
                Lifecycle.Event.ON_START -> viewModel.onStart()
                Lifecycle.Event.ON_STOP -> viewModel.onStop()
                else -> Unit
            }
        }

        // Add the observer to the lifecycle
        lifecycleOwner.lifecycle.addObserver(observer)

        // When the effect leaves the Composition, remove the observer
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
}

@Preview
@Composable
private fun AppAndroidPreview() {
    App()
}