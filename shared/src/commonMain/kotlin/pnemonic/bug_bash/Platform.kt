package pnemonic.bug_bash

import com.russhwolf.settings.Settings
import pnemonic.bug_bash.haptic.HapticManager
import pnemonic.bug_bash.sound.SoundManager

interface Platform {
    val name: String

    val haptic: HapticManager
    val sound: SoundManager
    val settings: Settings
}

expect fun getPlatform(): Platform