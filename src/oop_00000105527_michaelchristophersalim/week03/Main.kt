package oop_00000105527_michaelchristophersalim.week03

fun main() {
    val player = Player("Caleb")

    //Test xp Private (error)
    // println(player.xp)

    //Panggil addXp 50 (level 1)
    player.addXp(50)

    //Total 110, harus Level Up ke 2
    player.addXp(60)
}