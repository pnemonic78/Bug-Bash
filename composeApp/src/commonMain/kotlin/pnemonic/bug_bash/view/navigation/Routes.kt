package pnemonic.bug_bash.view.navigation

enum class Routes(val route: String) {
    Home("/"),
    Board("/board");

    override fun toString(): String {
        return route
    }
}