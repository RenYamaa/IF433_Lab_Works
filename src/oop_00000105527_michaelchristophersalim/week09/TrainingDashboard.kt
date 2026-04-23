package oop_00000105527_michaelchristophersalim.week09

fun main(){
    val tradeHistory = listOf(
        TradeLog("BTCUSDT", "LONG", 10, 5.2, "CLOSED"),   // profit
        TradeLog("BTCUSDT", "SHORT", 5, -2.1, "CLOSED"),  // loss
        TradeLog("ETHUSDT", "LONG", 8, 3.5, "CLOSED"),    // profit
        TradeLog("ETHUSDT", "SHORT", 10, -1.8, "OPEN"),   // masih open
        TradeLog("BTCUSDT", "LONG", 3, 0.0, "OPEN"),      // break even, open
        TradeLog("ETHUSDT", "LONG", 6, 7.0, "CLOSED")
    )

    val closedTrades = tradeHistory
        .filter { it.status == "CLOSED" }

    val winningTrades = closedTrades
        .filter { it.roe > 0 }

    val losingTrades = closedTrades
        .filter { it.roe <= 0 }

    val topPerformersString = winningTrades
        .sortedByDescending { it.roe }
        .map { trade ->
            "WIN [${trade.pair} - ${trade.position}]: +${trade.roe}% ROE (Lev: ${trade.leverage}x)"
        }

    val worstPerformersString = losingTrades
        .sortedBy{ it.roe }
        .map { trade ->
            "LOSS [${trade.pair} - ${trade.position}]: ${trade.roe}% ROE (Lev: ${trade.leverage}x)"
        }

    val uniquePairs = tradeHistory
        .map { it.pair }
        .toSet()
}