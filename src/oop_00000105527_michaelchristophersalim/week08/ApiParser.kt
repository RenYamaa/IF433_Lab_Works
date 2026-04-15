package oop_00000105527_michaelchristophersalim.week08

class ApiParser {
    fun parseProduct(rawJson: Map<String, Any?>): Product? {
        // 1. Ekstrak id dan name dengan requireNotNull (Wajib ada)
        val id = requireNotNull(rawJson["id"] as? String) {
            "API Invalid: Missing or Invalid ID"
        }
        val name = requireNotNull(rawJson["name"] as? String) {
            "API Invalid: Missing or Invalid Name"
        }

        // 2. Ekstrak type untuk menentukan jenis produk
        val type = rawJson["type"] as? String

        // 3. Logika parsing berdasarkan tipe produk
        return when (type?.uppercase()) {
            "ELECTRONIC" -> {
                // Ekstrak warranty dengan as? Int dan fallback Elvis 12
                val warranty = rawJson["warrantyMonths"] as? Int ?: 12
                Product.Electronic(id, name, warranty)
            }
            "CLOTHING" -> {
                // Ekstrak size dengan as? String dan fallback Elvis "All Size"
                val size = rawJson["size"] as? String ?: "All Size"
                Product.Clothing(id, name, size)
            }
            else -> null // Jika tipe tidak dikenal atau null, return null
        }
    }
}