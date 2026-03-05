package pnemonic.bug_bash.model.tool

import pnemonic.bug_bash.model.Bonus

abstract class BonusTool(val bonus: Bonus) : Tool() {
    var hits: Long = bonus.hits
    override val sound = bonus.sound
    override val description = bonus.description
}