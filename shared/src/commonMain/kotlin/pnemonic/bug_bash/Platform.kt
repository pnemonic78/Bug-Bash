package pnemonic.bug_bash

import pnemonic.haptic.HapticManager

interface Platform {
    val name: String

    val haptic: HapticManager
}

expect fun getPlatform(): Platform