package pnemonic.bug_bash.view.difficulty

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pnemonic.bug_bash.model.Difficulty
import pnemonic.bug_bash.view.settings.ActionPanel
import pnemonic.bug_bash.view.theme.shapePanel
import pnemonic.bug_bash.view.theme.sizeHomeButton

typealias DifficultyCallback = (Difficulty) -> Unit

private val colorEasy = Green.copy(alpha = 0.5f)
private val colorMedium = Yellow.copy(alpha = 0.5f)
private val colorHard = Red.copy(alpha = 0.5f)

@Composable
fun DifficultyPanel(
    modifier: Modifier = Modifier,
    difficulty: Difficulty = Difficulty.Easy,
    onDifficultyChange: DifficultyCallback,
) {
    var difficultyState by remember { mutableStateOf(difficulty) }

    ActionPanel(
        modifier = modifier.background(
            brush = Brush.horizontalGradient(colors = listOf(colorEasy, colorMedium, colorHard)),
            shape = shapePanel
        )
    ) {
        EasyButton(enabled = difficultyState == Difficulty.Easy, size = sizeHomeButton) {
            difficultyState = Difficulty.Easy
            onDifficultyChange(difficultyState)
        }
        Spacer(modifier = Modifier.width(8.dp))
        MediumButton(enabled = difficultyState == Difficulty.Medium, size = sizeHomeButton) {
            difficultyState = Difficulty.Medium
            onDifficultyChange(difficultyState)
        }
        Spacer(modifier = Modifier.width(8.dp))
        HardButton(enabled = difficultyState == Difficulty.Hard, size = sizeHomeButton) {
            difficultyState = Difficulty.Hard
            onDifficultyChange(difficultyState)
        }
    }
}

@Preview
@Composable
private fun Preview() {
    MaterialTheme {
        DifficultyPanel(onDifficultyChange = {})
    }
}
