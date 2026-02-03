package pnemonic.bug_bash.view.board

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pnemonic.bug_bash.drawable.LifeHad
import pnemonic.bug_bash.drawable.LifeHas

private val sizeIcon = 32.dp

@Composable
fun LivesView(modifier: Modifier = Modifier, lives: Int, liveTotal: Int) {
    Row(modifier = modifier) {
        (1..lives).forEach { _ ->
            LifeAlive()
        }
        ((lives + 1)..liveTotal).forEach { _ ->
            LifeDead()
        }
    }
}

@Composable
private fun LifeAlive() {
    Image(
        modifier = Modifier.size(sizeIcon).padding(start = 4.dp),
        imageVector = LifeHas,
        contentDescription = "💚",
        contentScale = ContentScale.Fit
    )
}

@Composable
private fun LifeDead() {
    Image(
        modifier = Modifier.size(sizeIcon).padding(start = 4.dp),
        imageVector = LifeHad,
        contentDescription = "🤍",
        contentScale = ContentScale.Fit
    )
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFF008800)
private fun Preview() {
    MaterialTheme {
        LivesView(lives = 2, liveTotal = 4)
    }
}