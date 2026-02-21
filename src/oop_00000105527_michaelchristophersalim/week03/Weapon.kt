package oop_00000105527_michaelchristophersalim.week03

class Weapon(val name: String) {
    var damage: Int = 0
        get() = field
        set(value) {
            if (value < 0) {
                println("Peringatan! Damage untuk $name tidak boleh negatif!")
            } else if (value > 1000) {
                println("Peringatan! $name terlalu besar damagenya! Di reset ke 1000")
                field = 1000
            } else {
                field = value
            }
        }
    val tier: String
        get() {
            return when {
                damage > 800 -> "Legendary"
                damage > 500 -> "Epic"
                else -> "Common"
            }
        }
}