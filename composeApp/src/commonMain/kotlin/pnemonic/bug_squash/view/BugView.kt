package pnemonic.bug_squash.view

import androidx.compose.runtime.Composable
import pnemonic.bug_squash.model.Ant
import pnemonic.bug_squash.model.Bee
import pnemonic.bug_squash.model.Bug
import pnemonic.bug_squash.model.Butterfly
import pnemonic.bug_squash.model.Caterpillar
import pnemonic.bug_squash.model.Cockroach
import pnemonic.bug_squash.model.Fly
import pnemonic.bug_squash.model.Ladybug
import pnemonic.bug_squash.model.Mosquito
import pnemonic.bug_squash.model.Moth
import pnemonic.bug_squash.model.Scorpion
import pnemonic.bug_squash.model.Snail
import pnemonic.bug_squash.model.Spider
import pnemonic.bug_squash.model.Termite
import pnemonic.bug_squash.model.Wasp
import pnemonic.bug_squash.model.Worm

typealias BugCallback = (Bug) -> Unit

@Composable
fun BugView(bug: Bug, onTap: BugCallback) {
    when (bug) {
        is Ant -> AntView(bug, onTap)
        is Bee -> BeeView(bug, onTap)
        is Butterfly -> ButterflyView(bug, onTap)
        is Caterpillar -> CaterpillarView(bug, onTap)
        is Cockroach -> CockroachView(bug, onTap)
        is Fly -> FlyView(bug, onTap)
        is Ladybug -> LadyBugView(bug, onTap)
        is Mosquito -> MosquitoView(bug, onTap)
        is Moth -> MothView(bug, onTap)
        is Scorpion -> ScorpionView(bug, onTap)
        is Snail -> SnailView(bug, onTap)
        is Spider -> SpiderView(bug, onTap)
        is Termite -> TermiteView(bug, onTap)
        is Wasp -> WaspView(bug, onTap)
        is Worm -> WormView(bug, onTap)
        else -> Unit
    }
}
