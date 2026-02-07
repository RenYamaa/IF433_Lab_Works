package oop_00000105527_michaelchristophersalim.week01

fun main() {
    val gameTitle: String = "Simple Game Store"
    val price: Int = 600000

    val finalPrice = calculateDiscount(price)
    printReceipt(title = gameTitle, finalPrice = finalPrice)
}

fun calculateDiscount(price: Int) = if (price > 500000) price - (price * 0.2).toInt() else price - (price * 0.1).toInt()

fun printReceipt(title: String, finalPrice: Int){
    println("Game: $title")
    println("Final Price: Rp$finalPrice")
}