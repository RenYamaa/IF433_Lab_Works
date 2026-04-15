package oop_00000105527_michaelchristophersalim.week08

// Definisi Sealed Class untuk Product
sealed class Product {
    // Properti umum diletakkan di dalam turunan agar fleksibel
    // atau bisa diletakkan di constructor sealed class jika semua turunan memilikinya

    data class Electronic(
        val id: String,
        val name: String,
        val warrantyMonths: Int
    ) : Product()

    data class Clothing(
        val id: String,
        val name: String,
        val size: String
    ) : Product()
}