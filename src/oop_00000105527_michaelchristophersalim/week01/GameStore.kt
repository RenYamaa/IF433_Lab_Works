package oop_00000105527_michaelchristophersalim.week01

fun main() {
    val gameTitle: String = "Simple Game Store"
    val price: Int = 600000

    val finalPrice = calculateDiscount(price)

    val userNote: String? = null

    printReceipt(
        title = gameTitle,
        finalPrice = finalPrice,
        userNote = userNote
    )
}

fun calculateDiscount(price: Int) = if (price > 500000) price - (price * 0.2).toInt() else price - (price * 0.1).toInt()

fun printReceipt(title: String, finalPrice: Int, userNote: String?) {
    println("Game: $title")
    println("Final Price: Rp$finalPrice")

    val noteToPrint = userNote ?: "No Note"
    println("Note: $noteToPrint")
}