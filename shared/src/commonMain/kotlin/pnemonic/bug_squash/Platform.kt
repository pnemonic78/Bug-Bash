package pnemonic.bug_squash

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform