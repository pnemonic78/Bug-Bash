package pnemonic.bug_squash.view

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun LivesView(lives: Int) {
    Row {
        (1..lives).forEach { _ ->
            Text("💚")
        }
    }
}