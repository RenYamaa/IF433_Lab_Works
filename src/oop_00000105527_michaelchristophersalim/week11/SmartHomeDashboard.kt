package oop_00000105527_michaelchristophersalim.week11

fun main(){
    val homeDevices = mutableListOf<SmartDevice>()
    val philipsWiz = SmartDevice().apply {
        name = "Philips WiZ Living Room"
        category = "Lighting"
        isOnline = true
        powerLoad = 12
    }.also {
        homeDevices.add(it)
    }
}