package pnemonic.bug_bash.view.board

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import bug_bash.composeapp.generated.resources.Res
import bug_bash.composeapp.generated.resources.game_state_finished
import org.jetbrains.compose.resources.stringResource
import pnemonic.bug_bash.model.GameState
import pnemonic.bug_bash.view.previewColor

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

private val sizeText = 60.sp
private val colorText = Color(0xFFCC0088)
private val colorPanel = Color.Black.copy(alpha = 0.25f)

@Composable
private fun GameOver(modifier: Modifier = Modifier) {
    val text = stringResource(Res.string.game_state_finished)
    GameOver(modifier = modifier, text = text)
}

@Composable
private fun GameOver(modifier: Modifier = Modifier, text: String) {
    val style = LocalTextStyle.current.copy(
        lineHeight = sizeText,
        shadow = Shadow(blurRadius = 5f)
    )

    Text(
        modifier = modifier.background(
            color = colorPanel,
            shape = MaterialTheme.shapes.medium
        ).padding(8.dp),
        text = text,
        fontSize = sizeText,
        fontWeight = FontWeight.Bold,
        color = colorText,
        textAlign = TextAlign.Center,
        style = style,
    )
}

@Composable
@Preview(showBackground = true, backgroundColor = previewColor, widthDp = 400)
private fun Preview() {
    MaterialTheme {
        GameOver()
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = previewColor, widthDp = 300)
private fun Preview2() {
    MaterialTheme {
        GameOver(text = "Game Over! Go Home!!")
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = previewColor, widthDp = 350, locale = "af")
private fun Preview3() {
    MaterialTheme {
        GameOver()
    }
}