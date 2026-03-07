package pnemonic.bug_bash.view.help

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pnemonic.bug_bash.BugFactory
import pnemonic.bug_bash.Platform
import pnemonic.bug_bash.control.LifecycleViewModel
import pnemonic.bug_bash.getPlatform
import pnemonic.bug_bash.model.Bonus
import pnemonic.bug_bash.model.bug.Bug

class HelpViewModel : LifecycleViewModel() {
    private val _catalog = MutableStateFlow<List<Bug>>(emptyList())
    val catalog: StateFlow<List<Bug>> = _catalog

    private val _bonuses = MutableStateFlow<List<Bonus>>(emptyList())
    val bonuses: StateFlow<List<Bonus>> = _bonuses

    private val platform: Platform = getPlatform()

    init {
        viewModelScope.launch {
            val bugs = BugFactory.allBugs.sortedWith { b1, b2 ->
                val c = b1.hits.compareTo(b2.hits)
                if (c != 0) return@sortedWith c
                b1.score.compareTo(b2.score)
            }
            bugs.forEach { it.freeze(1L) }
            _catalog.update { bugs }
        }
        viewModelScope.launch {
            _bonuses.update {
                listOf(
                    Bonus.Cupcake(progress = Long.MAX_VALUE),
                    Bonus.Flower(progress = Long.MAX_VALUE),
                    Bonus.GluePaper(progress = Long.MAX_VALUE),
                    Bonus.Life(progress = Long.MAX_VALUE),
                    Bonus.Score(progress = Long.MAX_VALUE),
                    Bonus.Shoe(progress = Long.MAX_VALUE),
                    Bonus.Spray(progress = Long.MAX_VALUE),
                    Bonus.Swatter(progress = Long.MAX_VALUE),
                    Bonus.Zapper(progress = Long.MAX_VALUE),
                )
            }
        }
    }

    fun onBugClick(bug: Bug) {
        platform.sound.play(bug.soundBash)
    }

    fun onBonusClick(bonus: Bonus) {
        platform.sound.play(bonus.sound)
    }
}