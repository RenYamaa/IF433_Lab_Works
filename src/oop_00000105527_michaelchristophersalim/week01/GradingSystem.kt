package oop_00000105527_michaelchristophersalim.week01

fun calculateStatus(score: Int) = if (score > 75) "Lulus" else "Tidak Lulus"

fun main(){
    // REFACTOR: Gunakan val dan hapus tipe data eksplisit
    val name: String = "John Thor"
    val score: Int = 80

    //REFACTOR: String Template ($name)
    println("Nama: $name, Nilai: $score")

    //Tambahan control flow
    val grade = when (score) {
        in 90 .. 100 -> "A"
        in 1..10 -> "B"
        in 70 .. 79 -> "C"
        else -> "D"
    }

    println("Grade kamu: $grade")
    println("Status: ${calculateStatus(score)}")

    //Tambahan Null Safety
    val studentId: String? = null

    //if null, gunakan nilai default 0
    val idLength = studentId?.length ?: 0

    println("Panjang ID: $idLength")
}