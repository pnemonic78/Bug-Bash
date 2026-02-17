package pnemonic.bug_bash.model.tool

import pnemonic.bug_bash.model.Bonus

class ExtraLife(val bonus: Bonus.Life) : Tool() {
    override val description: String = bonus.description
}
