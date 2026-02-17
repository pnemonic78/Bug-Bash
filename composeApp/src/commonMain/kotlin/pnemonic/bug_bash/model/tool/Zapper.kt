package pnemonic.bug_bash.model.tool

import pnemonic.bug_bash.model.Bonus

class Zapper(val bonus: Bonus.Zapper) : Tool() {
    override val description: String = bonus.description
}