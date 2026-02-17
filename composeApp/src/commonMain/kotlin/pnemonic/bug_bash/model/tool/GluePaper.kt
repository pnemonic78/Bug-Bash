package pnemonic.bug_bash.model.tool

import pnemonic.bug_bash.model.Bonus

class GluePaper(val bonus: Bonus.GluePaper) : Tool() {
    override val description: String = bonus.description
}