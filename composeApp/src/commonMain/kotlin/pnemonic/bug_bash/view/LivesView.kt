package pnemonic.bug_bash.view

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun LivesView(lives: Int, liveTotal: Int) {
    Row {
        (1..lives).forEach { _ ->
            Text("💚")
        }
        ((lives + 1)..liveTotal).forEach { _ ->
            Text("🤍")
        }
    }
}