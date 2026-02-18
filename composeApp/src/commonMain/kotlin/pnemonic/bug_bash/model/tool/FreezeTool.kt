package pnemonic.bug_bash.model.tool

import pnemonic.bug_bash.model.Bonus
import pnemonic.bug_bash.model.bug.Bug
import pnemonic.bug_bash.model.bug.Swarm

open class FreezeTool(bonus: Bonus) : BonusTool(bonus) {
    private val frozen = mutableListOf<Bug>()

    fun freeze(swarm: Swarm) {
        for (bug in swarm) {
            if (isHit(bug)) {
                freeze(bug)
            }
        }
    }

    fun freeze(bug: Bug) {
        if ((hits > 0) && !frozen.contains(bug)) {
            bug.freeze(Long.MAX_VALUE)
            frozen.add(bug)
            hits -= bug.hits
        }
    }

    fun thaw() {
        for (bug in frozen) {
            bug.freeze(0L)
        }
        frozen.clear()
    }
}