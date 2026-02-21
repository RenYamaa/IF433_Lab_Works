package oop_00000105527_michaelchristophersalim.week03

fun main() {
    val sword = Weapon("Excalibur")

    //Test 1: Damage negatif
    sword.damage = -50

    //Test 2: Damage terlalu besar
    sword.damage = 9999

    //Print tier
    println("Tier dari ${sword.name} adalah ${sword.tier}")
}