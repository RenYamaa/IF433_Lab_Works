package oop_00000105527_michaelchristophersalim.week03

fun main() {
    val e = Employee("Budi")
    e.salary = -1000
    e.salary = 50000000
    println("Gaji: ${e.salary}")

    // 2. Test Encapsulation
    e.increasePerformance()
    e.performanceRating = 5 // gabisa diakses atau error karena ini private property yang hanya bisa jalan di epmployee.kt

    // 3. Test Computed Property
    println("Pajak yang harus dibayar: ${e.tax}")
}