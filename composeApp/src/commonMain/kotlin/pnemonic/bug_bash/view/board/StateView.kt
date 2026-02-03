package pnemonic.bug_bash.view.board

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import bug_bash.composeapp.generated.resources.Res
import bug_bash.composeapp.generated.resources.game_state_finished
import org.jetbrains.compose.resources.stringResource
import pnemonic.bug_bash.model.GameState

@Composable
fun StateView(state: GameState) {
    if (state === GameState.FINISHED) {
        Box(
            modifier = Modifier.fillMaxSize().padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            GameOver()
        }
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFF0000FF)
private fun Preview() {
    StateView(GameState.FINISHED)
}

private val sizeText = 60.sp
private val shadow = Shadow(blurRadius = 2f, offset = Offset(2f, 2f))
private val colorGameOver = Color(0xCCCC0088)

@Composable
private fun GameOver() {
    val style = MaterialTheme.typography.bodyLarge.copy(
        color = colorGameOver,
        fontSize = sizeText,
        fontWeight = FontWeight.Bold,
        shadow = shadow
    )

    Text(
        modifier = Modifier.background(
            color = Color.Black.copy(alpha = 0.25f),
            shape = MaterialTheme.shapes.medium
        ).padding(8.dp),
        text = stringResource(Res.string.game_state_finished),
        style = style
    )
}