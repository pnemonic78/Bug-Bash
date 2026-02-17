package pnemonic.bug_bash.model.tool

import pnemonic.bug_bash.model.Bonus

class Flower(val bonus: Bonus.Flower) : Tool() {
    override val description: String = bonus.description
}