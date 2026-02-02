package pnemonic.bug_bash

import com.russhwolf.settings.Settings
import platform.UIKit.UIDevice
import pnemonic.bug_bash.haptic.HapticManager
import pnemonic.bug_bash.sound.SoundManager

class IOSPlatform : Platform {
    override val name: String =
        UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
    override val haptic: HapticManager = HapticManager
    override val sound: SoundManager = SoundManager
    override val settings: Settings by lazy { Settings() }
}

actual fun getPlatform(): Platform = IOSPlatform()