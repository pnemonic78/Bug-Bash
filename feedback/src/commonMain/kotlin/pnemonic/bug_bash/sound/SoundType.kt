package pnemonic.bug_bash.sound

enum class SoundType(val fileName: String, val repeat: Boolean = false) {
    None("", false),
    Beach("PLYGND01.WAV", false),
    Blip("CRIP006.WAV", false),
    Chips("Eat Chips.wav", false),
    Clang("CLANG001.WAV", false),
    Drip("DRIP002.WAV", false),
    Drop("DROPBOOK.WAV", false),
    GameFinish("GLASS04.WAV", false),
    GameStart("GONG16.WAV", false),
    Garden("DUSK02.WAV", true),
    Kiss("KISS001.WAV", false),
    Kitchen("kitchen.wav", true),
    Laser("LASER02.WAV", false),
    Level("BOING001.WAV", false),
    Pop("POP002.WAV", false),
    SlimeSplash("Slime Splash.wav", false), // heavy
    SpitSplat("Spit_Splat.wav", false), // splat
    Spray("SPRAY002.WAV", false),
    Squeeze("Squishy 2.wav", false), // squeeze
    Squirt("Blood Squirt.wav", false), // chop
    Squish1("Squish Fart.wav", false), // fart
    Swish("SWISH01.WAV", false),
    Switch("LIGHTSW.WAV", false),
    Table("table.wav", true),
}
