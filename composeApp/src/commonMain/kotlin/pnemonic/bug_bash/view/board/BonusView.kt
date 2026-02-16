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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pnemonic.bug_bash.drawable.Cupcake
import pnemonic.bug_bash.drawable.Flower
import pnemonic.bug_bash.drawable.GluePaper
import pnemonic.bug_bash.drawable.Insecticide
import pnemonic.bug_bash.drawable.LifeHas
import pnemonic.bug_bash.drawable.Shoe
import pnemonic.bug_bash.drawable.Swatter
import pnemonic.bug_bash.drawable.Trophy
import pnemonic.bug_bash.drawable.Zapper
import pnemonic.bug_bash.model.Bonus
import pnemonic.bug_bash.view.theme.panel
import pnemonic.bug_bash.drawable.Bonus as BonusImage

private val sizeIcon = 30.dp
private val sizeBonus = 48.dp
private val colorProgressBar = Color(0xFFBFC654)
private val colorProgressTrack = Color(0xFF005703)
private val spacing = 8.dp

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
                    Spacer(modifier = Modifier.width(spacing))
                    BonusView(bonus, onClick)
                }
            }
        }
    }
}

@Composable
fun BonusView(bonus: Bonus, onBonusClick: BonusCallback) {
    val progress = bonus.progress
    if (progress <= 0) return
    val total = bonus.score

    Box(
        modifier = Modifier
            .size(sizeBonus)
            .clickable {
                if (progress >= total) onBonusClick(bonus)
            },
        contentAlignment = Alignment.Center
    ) {
        when (bonus) {
            Bonus.None -> return
            is Bonus.Cupcake -> BonusCupcake()
            is Bonus.Flower -> BonusFlower()
            is Bonus.GluePaper -> BonusGluePaper()
            is Bonus.Insecticide -> BonusInsecticide()
            is Bonus.Life -> BonusLife()
            is Bonus.Score -> BonusScore()
            is Bonus.Shoe -> BonusShoe()
            is Bonus.Swatter -> BonusSwatter()
            is Bonus.Zapper -> BonusZapper()
        }
        if (progress < total) {
            CircularProgressIndicator(
                modifier = Modifier.fillMaxSize().alpha(0.7f),
                progress = { progress.toFloat() / total.toFloat() },
                color = colorProgressBar,
                trackColor = colorProgressTrack,
            )
        }
    }
}

@Composable
private fun BonusFlower() {
    Image(
        modifier = Modifier.size(sizeBonus),
        imageVector = Flower,
        contentDescription = "🌼",
        contentScale = ContentScale.Fit
    )
}

@Composable
private fun BonusGluePaper() {
    Image(
        modifier = Modifier.size(sizeBonus),
        imageVector = GluePaper,
        contentDescription = "📜",
        contentScale = ContentScale.Fit
    )
}

@Composable
private fun BonusInsecticide() {
    Image(
        modifier = Modifier.size(sizeBonus),
        imageVector = Insecticide,
        contentDescription = "☠",
        contentScale = ContentScale.Fit
    )
}

@Composable
private fun BonusLife() {
    Image(
        modifier = Modifier.size(sizeBonus),
        imageVector = LifeHas,
        contentDescription = "💝",
        contentScale = ContentScale.Fit
    )
}

@Composable
private fun BonusCupcake() {
    Image(
        modifier = Modifier.size(sizeBonus),
        imageVector = Cupcake,
        contentDescription = "🧁",
        contentScale = ContentScale.Fit
    )
}

@Composable
private fun BonusScore() {
    Image(
        modifier = Modifier.size(sizeBonus),
        imageVector = Trophy,
        contentDescription = "🏆",
        contentScale = ContentScale.Fit
    )
}

@Composable
private fun BonusShoe() {
    Image(
        modifier = Modifier.size(sizeBonus),
        imageVector = Shoe,
        contentDescription = "👞",
        contentScale = ContentScale.Fit
    )
}

@Composable
private fun BonusSwatter() {
    Image(
        modifier = Modifier.size(sizeBonus),
        imageVector = Swatter,
        contentDescription = "🏸",
        contentScale = ContentScale.Fit
    )
}

@Composable
private fun BonusZapper() {
    Image(
        modifier = Modifier.size(sizeBonus),
        imageVector = Zapper,
        contentDescription = "⚡",
        contentScale = ContentScale.Fit
    )
}

@Composable
@Preview(widthDp = 600)
private fun Preview() {
    val items = listOf(
        Bonus.None,
        Bonus.Cupcake(progress = 10),
        Bonus.Flower(progress = 20),
        Bonus.GluePaper(progress = 30),
        Bonus.Insecticide(progress = 40),
        Bonus.Life(progress = 50),
        Bonus.Score(progress = 60),
        Bonus.Shoe(progress = 70),
        Bonus.Swatter(progress =80),
        Bonus.Zapper(progress = 90),
    )

    MaterialTheme {
        BonusesView(bonuses = items, onClick = {})
    }
}
