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

// 3. Deserialization Parsing (Belum ada Error Handling)
fun fromCsvTrade(line: String): TradeRecord {
    val parts = line.split(",")
    return TradeRecord(
        id = parts[0].toInt(),
        symbol = parts[1],
        type = parts[2],
        margin = parts[3].toDouble(),
        pnl = parts[4].toDouble()
    )
}