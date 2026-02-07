package oop_00000105527_michaelchristophersalim.week01

fun.main(){
    // REFACTOR: Gunakan val dan hapus tipe data eksplisit
    val name: String = "John Thor"
    val score: Int = 80

    //REFACTOR: String Template ($name)
    println("Nama: $name, Nilai: $score")

    //Tambahan control flow
    val grade = when (score) {
        in 90 <= .. <= 100 -> "A"
        in 1..10 -> "B"
        in 70 <= .. <= 79 -> "C"
        else -> "D"
    }

    println("Grade kamu: $grade")
}