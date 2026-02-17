package pnemonic.bug_bash.model.tool

import pnemonic.bug_bash.model.Bonus

class Swatter(val bonus: Bonus.Swatter) : Tool() {
    override val description: String = bonus.description
}