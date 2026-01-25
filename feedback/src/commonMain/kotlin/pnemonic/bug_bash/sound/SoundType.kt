package pnemonic.bug_bash.sound

enum class SoundType(val fileName: String, val repeat: Boolean = false) {
    Bash("bash.wav", false),
    Kitchen("kitchen.wav", true),
    Table("table.wav", true),
    Garden("garden.wav", true),
}
