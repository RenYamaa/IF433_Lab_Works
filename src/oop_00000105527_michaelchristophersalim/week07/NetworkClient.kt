package oop_00000105527_michaelchristophersalim.week07

class NetworkClient private constructor(val url: String) {
    companion object {
        const val BASE_URL = "https://api.column.ac.id" // Shared constant

        fun createClient(): NetworkClient {
            println("Membangun NetworkClient dengan BASE_URL: $BASE_URL")
            return NetworkClient(BASE_URL)
        }
    }

    fun connect() {
        println("Connecting to $url...")
    }
}