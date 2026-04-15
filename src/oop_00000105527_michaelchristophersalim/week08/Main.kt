package oop_00000105527_michaelchristophersalim.week08

fun main() {
    println("=== TEST SAFE CALLS & ELVIS ===")
    val emptyOrder = Order(null, null)

    val destination = emptyOrder.deliveryDetails?.address?.city?.name ?: "Kota Tidak Diketahui"
    println("Tujuan pengiriman: $destination")

    println("\n=== TEST LET BLOCK ===")
    val validOrder = Order(null, 250000)

    val receipt = validOrder.totalPrice?.let { price ->
        val tax = price * 0.11
        "Transaksi Valid. Harga: Rp$price, Pajak: Rp$tax"
    } ?: "Transaksi Invalid: Harga belum di-set!"

    println(receipt)

    println("\n=== TEST SAFE CASTING ===")
    val mixedData: List<Any> = listOf(
        "Smartphone",
        1500000,
        UserProfile("Andi", null),
        "Laptop",
        4500000.0
    )

    for (item in mixedData) {
        val text = item as? String

        text?.let {
            println("Ditemukan teks: ${it.uppercase()}")
        }
    }

    val someObject: Any = 100

    val safeString = someObject as? String ?: "Unknown String"
    println("Hasil cast + fallback: $safeString")
    //Sudah di test

    println("\n=== TEST THE RED BUTTON (!!) ===")
    val apiResponse: Map<String, String?> = mapOf("status" to "200", "token" to null)
    try{
        val token = requireNotNull(apiResponse["token"]){
            "CRITICAL EXCEPTION: Token otentikasi tidak ditemukan dari server!"
        }
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }

    println("\n=== TEST JAVA INTEROP ===")
    val javaResponse =  LegacyJavaAPI.fetchServerStatus()

    val statusLength = javaResponse!!.length
    println("Status dari Java: $javaResponse (Length: $statusLength)")

    runMockUnitTest()

    //Data kotor dari API sesuai skenario
    val rawApiData: List<Map<String, Any?>> = listOf(
        mapOf("id" to "E01", "name" to "Laptop", "type" to "ELECTRONIC", "warrantyMonths" to 24),
        mapOf("id" to "C01", "name" to "T-Shirt", "type" to "CLOTHING", "size" to "XL"),
        mapOf("id" to "E02", "name" to "Mouse", "type" to "ELECTRONIC", "warrantyMonths" to "Not An Integer"), // Corrupted warranty
        mapOf("name" to "Ghost Item", "type" to "CLOTHING"), // Missing ID!
        mapOf("id" to "X01", "name" to "Unknown", "type" to "FOOD") // Unknown type
    )

    val parser = ApiParser()

    println("=== STARTING BATCH PROCESS ===\n")

    for (raw in rawApiData) {
        try {
            // Memanggil parseProduct yang mengandung requireNotNull
            val product = parser.parseProduct(raw)

            // Menggunakan ?.let untuk memproses hanya jika hasil parse tidak null
            product?.let {
                parser.checkout(it)
            } ?: println("SKIP: Tipe produk '${raw["type"]}' tidak didukung.")

        } catch (e: IllegalArgumentException) {
            // Menangkap error dari requireNotNull (seperti Ghost Item yang tidak punya ID)
            println("ALERT: Data korup ditemukan! -> ${e.message}")
        }
        println("------------------------------")
    }

    println("\n=== BATCH PROCESS FINISHED ===")
}