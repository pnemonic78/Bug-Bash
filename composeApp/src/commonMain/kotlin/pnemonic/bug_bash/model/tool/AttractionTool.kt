package pnemonic.bug_bash.model.tool

import pnemonic.bug_bash.model.Bonus
import pnemonic.bug_bash.model.bug.Bug
import pnemonic.bug_bash.model.bug.Swarm
import pnemonic.half

open class AttractionTool(bonus: Bonus) : BonusTool(bonus) {
    private val trails = mutableListOf<Trail>()

    fun attract(swarm: Swarm) {
        if (trails.isNotEmpty()) return
        for (bug in swarm) {
            attract(bug)
        }
    }

    fun attract(bug: Bug) {
        val x = left + width.half
        val y = top + height.half
        val trail = Trail(bug, bug.destinationX, bug.destinationY)
        trails.add(trail)
        bug.setDestination(x, y)
    }

    fun thaw() {
        for (trail in trails) {
            trail.bug.setDestination(trail.destinationX, trail.destinationY)
        }
        trails.clear()
    }

    private data class Trail(val bug: Bug, val destinationX: Float, val destinationY: Float)
}