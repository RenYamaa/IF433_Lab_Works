package oop_00000105527_michaelchristophersalim.week01

fun main() {
    val gameTitle: String = "Simple Game Store"
    val price: Int = 600000


}

fun calculateDiscount(price: Int) = if (price > 500000) price - (price * 0.2).toInt() else price - (price * 0.1).toInt()

fun printReceipt(title: String, finalPrice: Int){
    println("$title, $finalPrice")
}