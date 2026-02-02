package pnemonic.bug_bash

import com.russhwolf.settings.Settings
import pnemonic.bug_bash.haptic.HapticManager
import pnemonic.bug_bash.sound.SoundManager

class JVMPlatform: Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
    override val haptic: HapticManager = HapticManager
    override val sound: SoundManager = SoundManager
    override val settings: Settings by lazy { Settings() }
}

actual fun getPlatform(): Platform = JVMPlatform()