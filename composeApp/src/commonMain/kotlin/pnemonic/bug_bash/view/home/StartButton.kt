package pnemonic.bug_bash.view.home

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import bug_bash.composeapp.generated.resources.Res
import bug_bash.composeapp.generated.resources.start
import org.jetbrains.compose.resources.stringResource
import pnemonic.VoidCallback

@Composable
fun StartButton(onClick: VoidCallback) {
    Button(onClick = onClick) {
        Text(stringResource(Res.string.start))
    }
}