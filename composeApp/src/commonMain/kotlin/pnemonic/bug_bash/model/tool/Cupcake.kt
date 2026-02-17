package pnemonic.bug_bash.model.tool

import pnemonic.bug_bash.model.Bonus

class Cupcake(val bonus: Bonus.Cupcake) : Tool() {
    override val description: String = bonus.description
}