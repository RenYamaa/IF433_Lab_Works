package oop_00000105527_michaelchristophersalim.week05

class Ewallet(accountName: String, var balance: Double) : PaymentMethod(accountName) {

    override fun processPayment(amount: Double) {
        if (balance >= amount) {
            balance -= amount
            println("Pembayaran sebear $amount berhasil dengan E-Wallet. Sisa saldo: $balance")
        } else {
            println("Saldo tidak cukup untuk pembayaran sebesar $amount")
        }
    }

    fun topUp(amount: Double) {
        balance += amount
        println("Top up berhasil. Saldo sekarang: $balance")
    }
}