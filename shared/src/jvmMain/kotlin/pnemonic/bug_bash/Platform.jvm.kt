package pnemonic.bug_bash

import pnemonic.bug_bash.haptic.HapticManager
import pnemonic.bug_bash.sound.SoundManager

class JVMPlatform: Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
    override val haptic: HapticManager = HapticManager
    override val sound: SoundManager = SoundManager
}

actual fun getPlatform(): Platform = JVMPlatform()