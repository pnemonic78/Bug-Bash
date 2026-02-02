package pnemonic.bug_bash.control

import androidx.navigation.NavHostController
import pnemonic.bug_bash.view.navigation.Routes

class HomeViewModel : LifecycleViewModel() {
    var isSoundEnabled = true
        private set
    var isMusicEnabled = true
        private set

    fun onSoundChange(checked: Boolean) {
        isSoundEnabled = checked
    }

    fun onMusicChange(checked: Boolean) {
        isMusicEnabled = checked
    }

    fun onPlayClick(navController: NavHostController) {
        navController.navigate(Routes.Board.route)
    }

    fun onHelpClick(navController: NavHostController) {
        navController.navigate(Routes.Help.route)
    }
}