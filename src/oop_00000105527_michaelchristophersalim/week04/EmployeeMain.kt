package oop_00000105527_michaelchristophersalim.week04

fun main() {
    val manager = Manager("Budi", 10_000_000)
    val developer = Developer("Andi", 8_000_000, "Kotlin")

    // Manager
    manager.work()
    println("Bonus Manager: Rp ${manager.calculateBonus()}")

    println()

    // Dev
    developer.work()
    println("Bonus Developer: Rp ${developer.calculateBonus()}")
}