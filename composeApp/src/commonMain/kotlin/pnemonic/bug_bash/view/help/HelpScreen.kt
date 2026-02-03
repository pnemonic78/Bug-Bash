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
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import pnemonic.VoidCallback
import pnemonic.bug_bash.BugFactory
import pnemonic.bug_bash.drawable.Touch
import pnemonic.bug_bash.drawable.Trophy
import pnemonic.bug_bash.model.Bug
import pnemonic.bug_bash.view.board.BugView
import pnemonic.bug_bash.view.home.HomeButton

@Composable
fun HelpScreen(navController: NavHostController) {
    val onHomeClick: VoidCallback = { navController.navigateUp() }

    HelpScreen(onHomeClick = onHomeClick)
}

@Composable
fun HelpScreen(onHomeClick: VoidCallback) {
    Column(modifier = Modifier.fillMaxSize().safeContentPadding()) {
        Row(modifier = Modifier.padding(8.dp)) {
            Spacer(modifier = Modifier.weight(1f))
            HomeButton(onClick = onHomeClick)
        }
        BugList()
    }
}

@Composable
private fun BugList() {
    val bugs = BugFactory.allBugs.sortedWith { b1, b2 ->
        val c = b1.hits - b2.hits
        if (c != 0) return@sortedWith c
        b1.score - b2.score
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // Defines a grid with 2 columns
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp), // Spacing between columns
        verticalArrangement = Arrangement.spacedBy(8.dp) // Spacing between rows
    ) {
        items(bugs) { bug ->
            HelpCard(bug = bug)
        }
    }
}

@Composable
fun HelpCard(bug: Bug) {
    Card {
        BugCell(bug)
    }
}

@Composable
private fun BugCell(bug: Bug) {
    Row(modifier = Modifier.padding(8.dp)) {
        Box(
            modifier = Modifier.size(60.dp, 80.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            BugView(
                bug = bug,
                onSize = {},
                onTap = {},
                onDead = {}
            )
        }
        Spacer(modifier = Modifier.width(4.dp))
        Column(modifier = Modifier.weight(1f)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier.size(40.dp),
                    imageVector = Touch,
                    contentDescription = "Touch"
                )
                Text("×")
                Spacer(modifier = Modifier.height(4.dp))
                Text("${bug.hits}", fontWeight = FontWeight.Medium, softWrap = false)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier.size(40.dp),
                    imageVector = Trophy,
                    contentDescription = "Touch"
                )
                Text("×")
                Spacer(modifier = Modifier.height(4.dp))
                Text("${bug.score}", fontWeight = FontWeight.Medium, softWrap = false)
            }
        }
    }
}

@Composable
@Preview
private fun Preview() {
    MaterialTheme {
        HelpScreen {}
    }
}