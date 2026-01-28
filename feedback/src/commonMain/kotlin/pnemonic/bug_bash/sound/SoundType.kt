package pnemonic.bug_bash.sound

enum class SoundType(val fileName: String, val repeat: Boolean = false) {
    Beach("PLYGND01.WAV", false),
    Blip("CRIP006.WAV", false),
    Clang("CLANG001.WAV\n", false),
    Drip("DRIP002.WAV", false),
    Drop("DROPBOOK.WAV", false),
    Kitchen("kitchen.wav", true),
    Pop("POP002.WAV", false),
    Spray("SPRAY002.WAV", false),
    Swish("SWISH01.WAV", false),
    Switch("LIGHTSW.WAV", false),
    Table("table.wav", true),
    Garden("DUSK02.WAV", true),
}
