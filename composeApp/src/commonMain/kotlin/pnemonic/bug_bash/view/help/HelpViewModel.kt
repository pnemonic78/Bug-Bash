package pnemonic.bug_bash.view.help

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pnemonic.bug_bash.BugFactory
import pnemonic.bug_bash.Platform
import pnemonic.bug_bash.control.LifecycleViewModel
import pnemonic.bug_bash.getPlatform
import pnemonic.bug_bash.model.Bug

class HelpViewModel : LifecycleViewModel() {
    private val _catalog = MutableStateFlow<List<Bug>>(emptyList())
    val catalog: StateFlow<List<Bug>> = _catalog

    private val platform: Platform = getPlatform()

    init {
        viewModelScope.launch {
            val bugs = BugFactory.allBugs.sortedWith { b1, b2 ->
                val c = b1.hits - b2.hits
                if (c != 0) return@sortedWith c
                b1.score - b2.score
            }
            _catalog.emit(bugs)
        }
    }

    fun onBugClick(bug: Bug) {
        platform.sound.play(bug.sound)
    }
}