package pnemonic.bug_bash.view.help

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import pnemonic.VoidCallback
import pnemonic.bug_bash.view.home.HomeButton

@Composable
fun HelpScreen(navController: NavHostController) {
    val onHomeClick: VoidCallback = { navController.navigateUp() }

    HelpScreen(onHomeClick = onHomeClick)
}

@Composable
fun HelpScreen(onHomeClick: VoidCallback) {
    Column(modifier = Modifier.fillMaxSize()) {
        Row {
            HomeButton(onClick = onHomeClick)
        }
    }
}