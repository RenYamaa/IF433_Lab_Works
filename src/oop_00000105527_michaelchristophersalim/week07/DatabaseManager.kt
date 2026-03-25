package oop_00000105527_michaelchristophersalim.week07

object DatabaseManager {
    var connectionStatus: String = "Disconnected"

    fun connect() {
        connectionStatus = "Connected to the server"
        println("Database is ready.")
    }
}