package pnemonic.bug_bash.view.home

import androidx.navigation.NavHostController
import pnemonic.bug_bash.control.LifecycleViewModel
import pnemonic.bug_bash.view.navigation.Routes
import pnemonic.bug_bash.view.settings.SettingsManager

class HomeViewModel : LifecycleViewModel() {
    private val settings = SettingsManager
    val isMusicEnabled get() = settings.isMusicEnabled
    val isSoundEnabled get() = settings.isSoundEnabled

    fun onMusicChange(enabled: Boolean) {
        SettingsManager.isMusicEnabled = enabled
    }

    fun onSoundChange(enabled: Boolean) {
        SettingsManager.isSoundEnabled = enabled
    }

    fun onPlayClick(navController: NavHostController) {
        navController.navigate(Routes.Board.route)
    }

    fun onHelpClick(navController: NavHostController) {
        navController.navigate(Routes.Help.route)
    }
}