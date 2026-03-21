package pnemonic.bug_bash.view.help

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import pnemonic.VoidCallback
import pnemonic.bug_bash.drawable.Touch
import pnemonic.bug_bash.drawable.Trophy
import pnemonic.bug_bash.model.Bonus
import pnemonic.bug_bash.model.bug.Bug
import pnemonic.bug_bash.view.board.BonusCallback
import pnemonic.bug_bash.view.board.BonusSprite
import pnemonic.bug_bash.view.board.BugCallback
import pnemonic.bug_bash.view.board.BugSprite
import pnemonic.bug_bash.view.home.HomeButton
import pnemonic.bug_bash.view.previewHeightDp
import pnemonic.bug_bash.view.previewWidthDp
import pnemonic.bug_bash.view.settings.ActionPanel
import pnemonic.bug_bash.drawable.Bonus as BonusImage

@Composable
fun HelpScreen(navController: NavHostController) {
    //FIXME for JVM val viewModel = viewModel<HelpViewModel>()
    val viewModel = viewModel { HelpViewModel() }

    val onHomeClick: VoidCallback = { navController.navigateUp() }
    val catalog = viewModel.catalog.collectAsState()
    val bonuses = viewModel.bonuses.collectAsState()

    HelpScreen(
        onHomeClick = onHomeClick,
        bugs = catalog.value,
        onBugClick = viewModel::onBugClick,
        bonuses = bonuses.value,
        onBonusClick = viewModel::onBonusClick,
    )
}

@Composable
fun HelpScreen(
    onHomeClick: VoidCallback,
    bugs: List<Bug>,
    onBugClick: BugCallback,
    bonuses: List<Bonus>,
    onBonusClick: BonusCallback,
) {
    Column(modifier = Modifier.fillMaxSize().systemBarsPadding()) {
        Box(modifier = Modifier.fillMaxWidth()) {
            ActionPanel(modifier = Modifier.align(Alignment.TopEnd)) {
                HomeButton(onClick = onHomeClick)
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        BugList(bugs, onBugClick, bonuses, onBonusClick)
    }
}

private val sizeCellWidth = 170.dp
private val sizeBugWidth = 60.dp
private val sizeBugHeight = 80.dp
private val sizeBonusWidth = sizeBugWidth
private val sizeBonusHeight = sizeBugHeight
private val sizeBonus = max(sizeBonusWidth, sizeBonusHeight)
private val sizeIconHit = 40.dp
private val sizeIconScore = sizeIconHit
private val sizeSpace = 4.dp
private val colorGood = Color.Black
private val colorBad = Color.Red

@Composable
private fun BugList(
    bugs: List<Bug>,
    onBugClick: BugCallback,
    bonuses: List<Bonus>,
    onBonusClick: BonusCallback
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(sizeCellWidth),
        modifier = Modifier.padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp), // Spacing between columns
        verticalArrangement = Arrangement.spacedBy(8.dp) // Spacing between rows
    ) {
        items(bugs) { bug ->
            HelpCard(bug = bug, onBugClick)
        }
        items(bonuses) { bonus ->
            HelpCard(bonus = bonus, onBonusClick)
        }
    }
}

@Composable
fun HelpCard(bug: Bug, onClick: BugCallback) {
    Card {
        BugCell(bug, onClick)
    }
}

@Composable
fun HelpCard(bonus: Bonus, onClick: BonusCallback) {
    Card {
        BonusCell(bonus, onClick)
    }
}

@Composable
private fun BugCell(bug: Bug, onClick: BugCallback) {
    val color = if (bug.score >= 0) colorGood else colorBad

    Row(modifier = Modifier.padding(8.dp)) {
        Box(
            modifier = Modifier.size(sizeBugWidth, sizeBugHeight),
            contentAlignment = Alignment.Center
        ) {
            BugSprite(
                bug = bug,
                boardSize = Size.Zero,
                onSize = {},
                onTap = onClick
            )
        }
        Spacer(modifier = Modifier.width(4.dp))
        Column(modifier = Modifier.weight(1f)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier.size(sizeIconHit),
                    imageVector = Touch,
                    contentDescription = "👆"
                )
                Spacer(modifier = Modifier.width(sizeSpace))
                Text("×")
                Spacer(modifier = Modifier.width(sizeSpace))
                Text("${bug.hits}", fontWeight = FontWeight.Medium, softWrap = false)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier.size(sizeIconScore),
                    imageVector = Trophy,
                    contentDescription = "🏆"
                )
                Spacer(modifier = Modifier.width(sizeSpace))
                Text("×")
                Spacer(modifier = Modifier.width(sizeSpace))
                Text(
                    "${bug.score}",
                    fontWeight = FontWeight.Medium,
                    softWrap = false,
                    color = color
                )
            }
        }
    }
}

@Composable
private fun BonusCell(bonus: Bonus, onClick: BonusCallback) {
    val color = if (bonus.hits >= 0) colorGood else colorBad
    val isPrize = (bonus is Bonus.Cupcake)
            || (bonus is Bonus.Flower)
            || (bonus is Bonus.Life)
            || (bonus is Bonus.Score)

    Row(modifier = Modifier.padding(8.dp)) {
        Box(
            modifier = Modifier.size(sizeBonusWidth, sizeBonusHeight),
            contentAlignment = Alignment.Center
        ) {
            BonusSprite(bonus, sizeBonus, onClick)
        }
        Spacer(modifier = Modifier.width(4.dp))
        Column(modifier = Modifier.weight(1f)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier.size(sizeIconScore),
                    imageVector = Trophy,
                    contentDescription = "🏆"
                )
                Spacer(modifier = Modifier.width(sizeSpace))
                Text("×")
                Spacer(modifier = Modifier.width(sizeSpace))
                Text("${bonus.score}", fontWeight = FontWeight.Medium, softWrap = false)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (isPrize) {
                    Image(
                        modifier = Modifier.size(sizeIconHit),
                        imageVector = BonusImage,
                        contentDescription = "🎁"
                    )
                } else {
                    Image(
                        modifier = Modifier.size(sizeIconHit),
                        imageVector = Touch,
                        contentDescription = "👆"
                    )
                }
                Spacer(modifier = Modifier.width(sizeSpace))
                Text("×")
                Spacer(modifier = Modifier.width(sizeSpace))
                Text(
                    "${bonus.hits}",
                    fontWeight = FontWeight.Medium,
                    softWrap = false,
                    color = color
                )
            }
        }
    }
}

@Composable
@Preview(widthDp = previewWidthDp + 100, heightDp = 1700)
private fun Preview() {
    val nav = rememberNavController()

    MaterialTheme {
        HelpScreen(nav)
    }
}

@Composable
@Preview(widthDp = previewWidthDp * 2, heightDp = previewHeightDp * 2)
private fun PreviewWide() {
    val nav = rememberNavController()

    MaterialTheme {
        HelpScreen(nav)
    }
}