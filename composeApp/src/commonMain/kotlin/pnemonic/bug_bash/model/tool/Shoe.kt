package pnemonic.bug_bash.model.tool

import pnemonic.bug_bash.model.Bonus

class Shoe(val bonus: Bonus.Shoe) : Tool() {
    override val description: String = bonus.description
}