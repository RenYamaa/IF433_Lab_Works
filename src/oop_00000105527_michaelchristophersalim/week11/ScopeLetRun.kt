package oop_00000105527_michaelchristophersalim.week11

fun main(){
    println("=== TEST LET FUNCTION ===")
    val name: String? = "Alexander"


    val length = name?.let {
        println("Nama terdeteksi: $it")
        it.length
    }

    println("Panjang nama: $length")
}