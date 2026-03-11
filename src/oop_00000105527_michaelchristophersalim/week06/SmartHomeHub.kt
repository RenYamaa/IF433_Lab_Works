package oop_00000105527_michaelchristophersalim.week06

class SmartHomeHub {

    val devices = mutableListOf<SmartDevice>()

    fun addDevice(device: SmartDevice) {
        devices.add(device)
        println("Device ${device.name} berhasil ditambahkan ke Smart Home Hub.")
    }

    fun turnOffAllSwitches() {
        println("Mematikan semua perangkat yang dapat dimatikan...")

        for (device in devices) {
            if (device is Switchable) {
                device.turnOff()
            }
        }
    }
}