package oop_00000105527_michaelchristophersalim.week02

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    // 1. Input nama Hero & stat Damage. Buat Objeknya.
    println("--- WELCOME TO MINI RPG ---")
    print("Masukkan Nama Hero: ")
    val name = scanner.nextLine()
    print("Masukkan Base Damage: ")
    val damage = scanner.nextInt()

    val myHero = Hero(name, damage) // HP otomatis 100 karena default argument

    // 2. Variabel bantuan untuk musuh
    var enemyHp = 100
    val enemyName = "Wild Slime"

    println("\nSeekor $enemyName muncul!")

    // 3. Gunakan loop while
    while (myHero.isAlive() && enemyHp > 0) {
        println("\n--- STATUS ---")
        println("${myHero.name} (HP: ${myHero.hp}) vs $enemyName (HP: $enemyHp)")
        println("Menu: 1. Serang, 2. Kabur")
        print("Pilih aksi: ")

        when (scanner.nextInt()) {
            1 -> {
                // Hero menyerang
                myHero.attack(enemyName)
                enemyHp -= myHero.baseDamage
                if (enemyHp < 0) enemyHp = 0
                println("HP $enemyName sisa: $enemyHp")

                // Jika musuh masih hidup, musuh membalas
                if (enemyHp > 0) {
                    val dmgDealt = (10..20).random()
                    myHero.takeDamage(dmgDealt)
                }
            }
            2 -> {
                println("${myHero.name} memilih untuk kabur dari pertarungan!")
                break // Paksa loop berhenti
            }
            else -> println("Pilihan tidak valid!")
        }
    }

    // 4. Pengumuman pemenang di luar loop
    println("\n--- PERTARUNGAN BERAKHIR ---")
    if (!myHero.isAlive()) {
        println("GAME OVER... ${myHero.name} telah gugur.")
    } else if (enemyHp <= 0) {
        println("VICTORY! ${myHero.name} berhasil mengalahkan $enemyName!")
    } else {
        println("Pertarungan berakhir tanpa pemenang karena kabur.")
    }
}