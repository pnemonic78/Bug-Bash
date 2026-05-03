package pnemonic.bug_bash.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.bug_bash.view.theme.AppTheme

@Composable
fun App() {
    AppTheme {
        MainScreen()
    }
}

@Preview
@Composable
private fun Preview() {
    App()
}