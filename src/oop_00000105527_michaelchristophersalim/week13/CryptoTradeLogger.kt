package oop_00000105527_michaelchristophersalim.week13
import java.io.File
import java.io.FileNotFoundException

data class TradeRecord(
    val id: Int,
    val symbol: String,
    val type: String,
    val margin: Double,
    val pnl: Double
)

fun TradeRecord.toCsv(): String = "$id,$symbol,$type,$margin,$pnl"

fun fromCsvTrade(line: String): TradeRecord? {
    return try {
        val parts = line.split(",")
        TradeRecord(
            id = parts[0].toInt(),
            symbol = parts[1],
            type = parts[2],
            margin = parts[3].toDouble(),
            pnl = parts[4].toDouble()
        )
    } catch (e: Exception) { // Menangkap NumberFormatException, IndexOutOfBounds, dll
        println("(Log) Data korup diabaikan: $line")
        null
    }
}

fun saveTrades(trades: List<TradeRecord>, path: String) {
    File(path).printWriter().use { out ->
        trades.forEach { out.println(it.toCsv()) }
    }
}

fun loadTrades(path: String): List<TradeRecord> {
    return try {
        File(path).readLines().mapNotNull { fromCsvTrade(it) }
    } catch (e: FileNotFoundException) {
        println("Error: File tidak ditemukan!")
        emptyList()
    }
}

fun main() {
    val mockTrades = listOf(
        TradeRecord(id = 1, symbol = "BTCUSDT", type = "Long", margin = 1000.0, pnl = 150.5),
        TradeRecord(id = 2, symbol = "ETHUSDT", type = "Short", margin = 500.0, pnl = -20.0)
    )
    val filePath = "crypto_trades.csv"
    saveTrades(mockTrades, filePath)

    File(filePath).appendText("CORRUPT_ID,DOGEUSDT,Hold,XX,YY\n")
}