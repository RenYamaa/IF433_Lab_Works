package oop_00000105527_michaelchristophersalim.week02

class Hero(val name: String, val baseDamage: Int, var hp: Int = 100) {

    // Method untuk simulasi menyerang
    fun attack(targetName: String) {
        println("$name menebas $targetName!")
    }

    // Method untuk menerima damage (State Management HP)
    fun takeDamage(damage: Int) {
        hp -= damage

        // Logika Wajib: Biar HP nggak minus (Minimal 0)
        if (hp < 0) {
            hp = 0
        }

        println("$name menerima $damage damage! HP sekarang: $hp")
    }

    // Method untuk cek apakah masih hidup
    fun isAlive(): Boolean {
        return hp > 0
    }
}