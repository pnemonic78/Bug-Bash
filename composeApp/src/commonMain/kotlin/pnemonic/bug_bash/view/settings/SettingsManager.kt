package pnemonic.bug_bash.view.settings

import com.russhwolf.settings.Settings
import pnemonic.bug_bash.Platform
import pnemonic.bug_bash.getPlatform

object SettingsManager {
    private const val KEY_MUSIC = "settings.music"
    private const val KEY_SOUND = "settings.sound"

    private val platform: Platform = getPlatform()
    private val settings: Settings get() = platform.settings

    var isMusicEnabled: Boolean
        get() = settings.getBoolean(KEY_MUSIC, true)
        set(value) {
            settings.putBoolean(KEY_MUSIC, value)
        }

    var isSoundEnabled: Boolean
        get() = settings.getBoolean(KEY_SOUND, true)
        set(value) {
            settings.putBoolean(KEY_SOUND, value)
        }
}