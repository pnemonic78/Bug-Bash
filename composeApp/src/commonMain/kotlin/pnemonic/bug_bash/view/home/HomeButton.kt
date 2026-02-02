package pnemonic.bug_bash.view.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.VoidCallback

@Composable
fun HomeButton(onClick: VoidCallback) {
    IconButton(onClick = onClick) {
        Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
    }
}

@Composable
@Preview
private fun Preview() {
    MaterialTheme {
        HomeButton {}
    }
}