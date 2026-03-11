package oop_00000105527_michaelchristophersalim.week06

// Interface utama untuk semua perangkat smart home
interface SmartDevice {
    val id: String
    val name: String
}

// Interface untuk perangkat yang bisa dinyalakan/dimatikan
interface Switchable {
    fun turnOn()
    fun turnOff()
}

// Interface untuk perangkat yang bisa merekam
interface Recordable {
    fun startRecord()

    // Default function
    fun stopRecord() {
        println("Perekaman dihentikan dan disimpan ke Cloud.")
    }
}