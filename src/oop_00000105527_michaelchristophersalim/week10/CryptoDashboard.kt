package oop_00000105527_michaelchristophersalim.week10

fun main(){
    val coinRepo = WalletRepository<Coin>()

    coinRepo.add(Coin("BTC", 1.5))
    coinRepo.add(Coin("ETH", 2.0))
    coinRepo.add(Coin("USDT", 1.0))

    val response = ApiResponse("200 OK", coinRepo.getAll())

    println("Status: ${response.status}")

    response.data.forEach { coin ->
        println("Coin: ${coin.name}, Balance: ${coin.balance}")
    }

    val txRepo = WalletRepository<Transaction>()

    // data transaksi
    txRepo.add(Transaction("TX001", 1000.0))
    txRepo.add(Transaction("TX002", -500.0))

    println("=== Transactions ===")
    txRepo.getAll().forEach {
        println("ID: ${it.id}, Amount: ${it.amount}")
    }
}