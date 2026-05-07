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
    val ezvizCamera = SmartDevice("Ezviz Outdoor", "Camera").apply {
        isOnline = true
        powerLoad = 5
    }.also{
        println("(LOG) Kamera terhubung")
        homeDevices.add(it)
    }

    val acInverter = run {
        val device = SmartDevice("Daikin Inverter (Kabel 3x2.5)", "HVAC", false, 800)
        // Baris terakhir ini yang akan di-return dan ditangkap oleh variabel acInverter
        device
    }
    homeDevices.add(acInverter)

    homeDevices.add(SmartDevice("Picolo's Auto Feeder", "Pet Care", true, 10))

    val searchResult = homeDevices.find { it.category == "Camera" }

    searchResult?.let {
        println("\n--- Hasil Pencarian Kamera ---")
        println(it.diagnose())
    }

    with(homeDevices) {
        println("\n--- Rangkuman Dashboard ---")
        println("Total Perangkat Terdaftar: ${this.size}")
    }

    val totalPower = homeDevices.run {
        sumOf { it.powerLoad }
    }
    println("Total Power: $totalPower")

}