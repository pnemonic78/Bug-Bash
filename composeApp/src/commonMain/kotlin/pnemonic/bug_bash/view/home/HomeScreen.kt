package pnemonic.bug_bash.view.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import bug_bash.composeapp.generated.resources.Res
import bug_bash.composeapp.generated.resources.start
import org.jetbrains.compose.resources.stringResource
import pnemonic.VoidCallback
import pnemonic.bug_bash.control.HomeViewModel
import pnemonic.bug_bash.view.navigation.Routes

@Composable
fun HomeScreen(navController: NavHostController) {
    val lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current
    //FIXME for JVM val viewModel = viewModel<HomeViewModel>()
    val viewModel = viewModel { HomeViewModel() }
    val onStartClick: VoidCallback = { navController.navigate(Routes.Board.route) }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = onStartClick) {
            Text(stringResource(Res.string.start))
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
@Preview
private fun Preview() {
    val navController = rememberNavController()

    MaterialTheme {
        HomeScreen(navController)
    }
}