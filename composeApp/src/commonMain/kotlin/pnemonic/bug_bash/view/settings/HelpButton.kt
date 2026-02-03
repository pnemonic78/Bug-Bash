package pnemonic.bug_bash.view.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Help
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.tooling.preview.Preview
import pnemonic.VoidCallback
import pnemonic.bug_bash.view.click
import pnemonic.bug_bash.view.theme.colorButton
import pnemonic.bug_bash.view.theme.modifierButton
import pnemonic.bug_bash.view.theme.modifierIcon

@Composable
fun HelpButton(onClick: VoidCallback) {
    val haptic = LocalHapticFeedback.current

    IconButton(
        onClick = {
            haptic.click()
            onClick()
        },
        modifier = Modifier.modifierButton()
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.Help,
            contentDescription = "Help",
            tint = colorButton,
            modifier = Modifier.modifierIcon()
        )
    }
}

@Composable
@Preview
private fun Preview() {
    MaterialTheme {
        Column {
            HelpButton {}
        }
    }
}