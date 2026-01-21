package pnemonic.bug_bash

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import pnemonic.bug_bash.view.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Bug Bash",
    ) {
        App()
    }
}