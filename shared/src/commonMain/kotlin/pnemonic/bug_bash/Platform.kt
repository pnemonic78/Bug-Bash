package pnemonic.bug_bash

import androidx.compose.ui.text.intl.Locale
import com.russhwolf.settings.Settings
import pnemonic.bug_bash.haptic.HapticManager
import pnemonic.bug_bash.sound.SoundManager

interface Platform {

    val name: String

    val haptic: HapticManager
    val sound: SoundManager
    val settings: Settings

    fun formatInteger(locale: Locale, number: Long): String
}

expect fun getPlatform(): Platform