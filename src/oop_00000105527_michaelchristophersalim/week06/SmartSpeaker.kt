package oop_00000105527_michaelchristophersalim.week06

class SmartSpeaker(
    override val id: String,
    override val name: String
) : SmartDevice, Switchable {

    override fun turnOn() {
        println("Smart Speaker $name dinyalakan.")
    }

    override fun turnOff() {
        println("Smart Speaker $name dimatikan.")
    }

    fun playMusic(song: String) {
        println("Memutar lagu $song dari Spotify.")
    }
}