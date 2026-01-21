package pnemonic.bug_bash

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform