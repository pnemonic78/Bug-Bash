package pnemonic.bug_bash.view.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.VoidCallback
import pnemonic.bug_bash.view.theme.colorButton
import pnemonic.bug_bash.view.theme.modifierButton
import pnemonic.bug_bash.view.theme.modifierIcon

@Composable
fun HomeButton(onClick: VoidCallback) {
    IconButton(onClick = onClick, modifier = Modifier.modifierButton()) {
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = "Home",
            tint = colorButton,
            modifier = Modifier.modifierIcon()
        )
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFF0000FF)
private fun Preview() {
    MaterialTheme {
        HomeButton {}
    }
}