package pnemonic.bug_bash.model.tool

import pnemonic.bug_bash.model.Bonus

class Score(val bonus: Bonus.Score) : Tool() {
    override val description: String = bonus.description
}