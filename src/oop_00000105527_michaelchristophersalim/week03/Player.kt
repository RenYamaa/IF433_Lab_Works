package oop_00000105527_michaelchristophersalim.week03

class Player(val username: String) {
    private var xp: Int = 0

    val level: Int
        get() = (xp / 100) + 1

    fun addXp(amount: Int) {
        if (amount <= 0) {
            println("XP yang ditambahkan harus positif!")
            return
        }

        val oldLevel = level
        xp += amount
        val newLevel = level

        if (newLevel > oldLevel) {
            println("Level up! Selamat $username naik ke level $newLevel")
        }
    }
}