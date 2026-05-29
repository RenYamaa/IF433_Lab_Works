package oop_00000105527_michaelchristophersalim.week13
import java.io.File

fun main() {
    // LANGKAH 1: Menulis ke File (writeText)
    println("=== TEST WRITE TEXT ===")
    val file = File("notes.txt")
    file.writeText("Line 1: Inisialisasi sistem.\n")
    println("File berhasil dibuat dan ditulis.")
}