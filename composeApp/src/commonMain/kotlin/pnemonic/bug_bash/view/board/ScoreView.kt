package pnemonic.bug_bash.view.board

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ScoreView(score: Long) {
    Text("🏆 $score")
}