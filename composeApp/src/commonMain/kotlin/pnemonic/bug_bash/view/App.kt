package pnemonic.bug_bash.view

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun App() {
    MaterialTheme {
        MainScreen()
    }
}

@Preview
@Composable
private fun Preview() {
    App()
}