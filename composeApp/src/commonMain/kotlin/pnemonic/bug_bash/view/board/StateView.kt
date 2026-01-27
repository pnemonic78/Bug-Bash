package pnemonic.bug_bash.view.board

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import bug_bash.composeapp.generated.resources.Res
import bug_bash.composeapp.generated.resources.game_state_finished
import org.jetbrains.compose.resources.stringResource
import pnemonic.bug_bash.model.GameState

@Composable
fun StateView(state: GameState) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (state === GameState.FINISHED) {
            Text(stringResource(Res.string.game_state_finished))
        }
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFF0000FF)
private fun Preview() {
    StateView(GameState.FINISHED)
}