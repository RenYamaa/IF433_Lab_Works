package oop_00000105527_michaelchristophersalim.week08

class ApiParser {
    // CUKUP SATU SAJA fungsi parseProduct
    fun parseProduct(rawJson: Map<String, Any?>): Product? {
        // 1. Ekstrak id dan name dengan requireNotNull (Wajib ada)
        // Jika null/salah tipe, akan throw IllegalArgumentException
        val id = requireNotNull(rawJson["id"] as? String) {
            "API Invalid: Missing or Invalid ID"
        }
        val name = requireNotNull(rawJson["name"] as? String) {
            "API Invalid: Missing or Invalid Name"
        }

        // 2. Ekstrak type untuk menentukan jenis produk
        val type = rawJson["type"] as? String

        // 3. Logika parsing berdasarkan tipe produk (menggunakan safe cast 'as?' dan Elvis '?:')
        return when (type?.uppercase()) {
            "ELECTRONIC" -> {
                val warranty = rawJson["warrantyMonths"] as? Int ?: 12
                Product.Electronic(id, name, warranty)
            }
            "CLOTHING" -> {
                val size = rawJson["size"] as? String ?: "All Size"
                Product.Clothing(id, name, size)
            }
            else -> null // Kembalikan null jika tipe tidak dikenal
        }
    }

    // Fungsi Checkout untuk Java Interop
    fun checkout(product: Product) {
        // Smart cast otomatis karena Product adalah sealed class
        val productId = when (product) {
            is Product.Electronic -> product.id
            is Product.Clothing -> product.id
        }

        // Memanggil Java static method dan menggunakan !! sesuai instruksi tugas
        val transactionId = JavaPaymentService.processPayment(productId)!!

        println("Checkout Berhasil!")
        println("Transaction ID: $transactionId")
    }
}