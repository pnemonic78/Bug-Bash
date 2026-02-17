package pnemonic.bug_bash.model.tool

import pnemonic.bug_bash.model.Bonus

class Spray(val bonus: Bonus.Spray) : Tool() {
    override val description: String = bonus.description
}