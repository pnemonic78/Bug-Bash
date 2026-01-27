package pnemonic.bug_bash.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import pnemonic.bug_bash.view.navigation.NavigationGraph

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Box(modifier = Modifier.fillMaxSize()) {
        NavigationGraph(navController = navController)
    }
}