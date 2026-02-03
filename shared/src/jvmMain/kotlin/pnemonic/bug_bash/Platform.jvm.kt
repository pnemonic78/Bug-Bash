package pnemonic.bug_bash

import androidx.compose.ui.text.intl.Locale
import com.russhwolf.settings.Settings
import pnemonic.bug_bash.haptic.HapticManager
import pnemonic.bug_bash.sound.SoundManager
import java.text.NumberFormat

class JVMPlatform: Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
    override val haptic: HapticManager = HapticManager
    override val sound: SoundManager = SoundManager
    override val settings: Settings by lazy { Settings() }

    override fun formatInteger(locale: Locale, number: Long): String {
        val formatter = NumberFormat.getIntegerInstance(locale.platformLocale)
        return formatter.format(number)
    }
}

actual fun getPlatform(): Platform = JVMPlatform()