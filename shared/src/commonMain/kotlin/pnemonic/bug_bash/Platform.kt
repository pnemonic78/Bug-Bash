package pnemonic.bug_bash

import pnemonic.bug_bash.haptic.HapticManager
import pnemonic.bug_bash.sound.SoundManager

interface Platform {
    val name: String

    val haptic: HapticManager
    val sound: SoundManager
}

expect fun getPlatform(): Platform