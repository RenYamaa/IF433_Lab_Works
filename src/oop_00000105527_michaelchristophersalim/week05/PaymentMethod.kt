package oop_00000105527_michaelchristophersalim.week05

abstract class PaymentMethod(val accountName: String) {
    abstract fun processPayment(amount: Double)
}