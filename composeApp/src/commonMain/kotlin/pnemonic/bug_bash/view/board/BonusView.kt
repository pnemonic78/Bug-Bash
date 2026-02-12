package pnemonic.bug_bash.view.board

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pnemonic.bug_bash.model.Bonus
import pnemonic.bug_bash.view.theme.panel
import pnemonic.bug_bash.drawable.Bonus as BonusImage

private val sizeIcon = 30.dp
private val sizeBonus = 32.dp
private val sizeBonusText = sizeBonus * 0.75f

typealias BonusCallback = (Bonus) -> Unit

@Composable
fun BonusesView(modifier: Modifier = Modifier, bonuses: List<Bonus>, onClick: BonusCallback) {
    if (bonuses.isEmpty()) return
    var expanded by remember { mutableStateOf(true) }

    Row(modifier = modifier.panel(), verticalAlignment = Alignment.CenterVertically) {
        Image(
            imageVector = BonusImage,
            contentDescription = "🎁",
            modifier = Modifier.size(sizeIcon)
                .clickable { expanded = !expanded }
        )
        AnimatedVisibility(
            visible = expanded,
            // Combines sliding and expanding horizontally
            enter = slideInHorizontally(
                initialOffsetX = { fullWidth -> 0 } // Start from the left
            ) + expandHorizontally(
                expandFrom = Alignment.Start // Expand from the start (left)
            ) + fadeIn(),
            // Defines how it disappears
            exit = slideOutHorizontally(
                targetOffsetX = { fullWidth -> 0 } // Exit to the left
            ) + shrinkHorizontally(
                shrinkTowards = Alignment.Start // Shrink towards the start (left)
            ) + fadeOut()
        ) {
            Row(
                modifier = Modifier.scrollable(
                    state = rememberScrollState(),
                    orientation = Orientation.Horizontal
                )
            ) {
                for (bonus in bonuses) {
                    Spacer(modifier = Modifier.width(8.dp))
                    BonusView(bonus, onClick)
                }
            }
        }
    }
}

private val colorProgressBar = Color(0xFFBFC654)
private val colorProgressTrack = Color(0xFF005703)

@Composable
fun BonusView(bonus: Bonus, onBonusClick: BonusCallback) {
    val progress = bonus.progress
    if (progress <= 0) return
    val total = bonus.score
    val onClick = { onBonusClick(bonus) }

    Box(
        modifier = Modifier
            .size(sizeBonus)
            .clickable { if (progress >= total) onClick() },
        contentAlignment = Alignment.Center
    ) {
        when (bonus) {
            Bonus.None -> return
            is Bonus.Flower -> BonusFlower()
            is Bonus.Insecticide -> BonusInsecticide()
            is Bonus.Life -> BonusLife()
            is Bonus.RainbowSprinkles -> BonusRainbowSprinkles()
            is Bonus.Shoe -> BonusShoe()
            is Bonus.Swatter -> BonusSwatter()
            is Bonus.Zapper -> BonusZapper()
        }
        if (progress < total) {
            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth(),
                progress = { progress.toFloat() / total.toFloat() },
                color = colorProgressBar,
                trackColor = colorProgressTrack,
            )
        }
    }
}

@Composable
private fun BonusFlower() {
    val size = with(LocalDensity.current) { sizeBonusText.toSp() }
    Text(text = "🌼", fontSize = size)
}

@Composable
private fun BonusInsecticide() {
    val size = with(LocalDensity.current) { sizeBonusText.toSp() }
    Text(text = "☠", fontSize = size)
}

@Composable
private fun BonusLife() {
    val size = with(LocalDensity.current) { sizeBonusText.toSp() }
    Text(text = "💝", fontSize = size)
}

@Composable
private fun BonusRainbowSprinkles() {
    val size = with(LocalDensity.current) { sizeBonusText.toSp() }
    Text(text = "🌈", fontSize = size)
}

@Composable
private fun BonusShoe() {
    val size = with(LocalDensity.current) { sizeBonusText.toSp() }
    Text(text = "👞", fontSize = size)
}

@Composable
private fun BonusSwatter() {
    val size = with(LocalDensity.current) { sizeBonusText.toSp() }
    Text(text = "🏸", fontSize = size)
}

@Composable
private fun BonusZapper() {
    val size = with(LocalDensity.current) { sizeBonusText.toSp() }
    Text(text = "⚡", fontSize = size)
}

@Composable
@Preview
private fun Preview() {
    val items = listOf(
        Bonus.None,
        Bonus.Flower(progress = 10),
        Bonus.Life(progress = 50),
        Bonus.Shoe(progress = 200)
    )

    MaterialTheme {
        BonusesView(bonuses = items, onClick = {})
    }
}
