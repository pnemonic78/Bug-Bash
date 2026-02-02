package pnemonic.bug_bash.view.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.VoidCallback
import pnemonic.bug_bash.view.theme.colorButton

@Composable
fun HomeButton(onClick: VoidCallback) {
    IconButton(onClick = onClick) {
        Icon(imageVector = Icons.Default.Home, contentDescription = "Home", tint = colorButton)
    }
}

@Composable
@Preview
private fun Preview() {
    MaterialTheme {
        HomeButton {}
    }
}