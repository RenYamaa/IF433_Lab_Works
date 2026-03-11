package oop_00000105527_michaelchristophersalim.week06

fun processCheckout(method: PaymentMethod, amount: Double) {
    println("-> Memulai checkout...")
    method.pay(amount)
}

fun main() {
    val myWatch = Smartwatch()
    myWatch.showTime()

    val myPhone = Smartphone()
    myPhone.turnOn()

    val pay1 = Gopay()
    val pay2 = CreditCard()

    println("\n=== Testing Checkout ===")
    processCheckout(pay1, 50000.0)
    processCheckout(pay2, 150000.0)

    // ===============
    // TASK
    // ==============


    val lamp = SmartLamp("L001", "Ruang Tamu")

    val speaker = SmartSpeaker("S001", "Google Nest Dapur")

    val cctv = SmartCCTV("C001", "Ezviz Garasi")

    // Instansiasi Smart Home Hub
    val hub = SmartHomeHub()

    // Menambahkan perangkat ke hub
    hub.addDevice(lamp)
    hub.addDevice(speaker)
    hub.addDevice(cctv)

    println()

    // Aktifkan mode keamanan
    hub.activateSecurityMode()

    println()

    // Matikan semua perangkat yang bisa dimatikan
    hub.turnOffAllSwitches()

}
