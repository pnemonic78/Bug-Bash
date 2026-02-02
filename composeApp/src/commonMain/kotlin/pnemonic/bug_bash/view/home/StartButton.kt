package pnemonic.bug_bash.view.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.elevatedButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import bug_bash.composeapp.generated.resources.Res
import bug_bash.composeapp.generated.resources.play
import org.jetbrains.compose.resources.stringResource
import pnemonic.VoidCallback
import pnemonic.bug_bash.view.theme.colorSecondary

@Composable
fun StartButton(modifier: Modifier = Modifier, onClick: VoidCallback) {
    Button(modifier = modifier, onClick = onClick, elevation = elevatedButtonElevation()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = stringResource(Res.string.play), fontSize = 40.sp, color = colorSecondary)
            Spacer(modifier = Modifier.width(ButtonDefaults.IconSpacing))
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = null,
                modifier = Modifier.size(60.dp),
                tint = colorSecondary
            )
        }
    }
}

@Composable
@Preview
private fun Preview() {
    MaterialTheme {
        StartButton {}
    }
}