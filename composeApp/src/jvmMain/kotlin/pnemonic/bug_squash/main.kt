package pnemonic.bug_squash

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Bug Squash",
    ) {
        App()
    }
}