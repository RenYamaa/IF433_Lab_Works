package oop_00000105527_michaelchristophersalim.week14
import java.io.File
import java.io.FileWriter

class BadOrderProcessor {
    // VIOLATION: Hardcoded File I/O (DIP), Melakukan kalkulasi + I/O + Notifikasi sekaligus
    private val file = File("orders.csv")

    fun processOrder(itemName: String, basePrice: Double, customerType: String) {
        // VIOLATION: Kaku jika ada tipe customer/diskon baru di masa depan (OCP)
        val finalPrice = when (customerType) {
            "REGULAR" -> basePrice
            "VIP" -> basePrice * 0.90 // Diskon 10%
            else -> basePrice
        }

        println("Memproses pesanan $itemName seharga $finalPrice")

        // VIOLATION SRP/DIP: Menulis file langsung di class bisnis
        file.appendText("$itemName,$finalPrice,$customerType\n")

        // VIOLATION SRP/DIP: Notifikasi terikat kuat dengan sistem order
        println("Email terkirim: Pesanan $itemName Anda telah dikonfirmasi!")
    }
}

// --- 1. Fix SRP & DIP: Database ---
interface OrderRepository {
    fun saveOrder(itemName: String, finalPrice: Double, customerType: String)
}

class CsvOrderRepository : OrderRepository {
    override fun saveOrder(itemName: String, finalPrice: Double, customerType: String) {
        // Menggunakan blok safe resource handling 'use' dan FileWriter(..., true) agar mode append
        FileWriter("orders.csv", true).use { writer ->
            writer.append("$itemName,$finalPrice,$customerType\n")
        }
    }
}

// --- 2. Fix SRP & DIP: Notifikasi ---
interface NotificationService {
    fun sendNotification(message: String)
}

class EmailNotifier : NotificationService {
    override fun sendNotification(message: String) {
        println("Email terkirim: $message")
    }
}

// --- 3. Refactored Processor (Tahap 1) ---
class SafeOrderProcessor(
    val repo: OrderRepository,
    val notifier: NotificationService
) {
    fun processOrder(itemName: String, basePrice: Double, customerType: String) {
        // Blok when ini masih melanggar OCP, akan kita perbaiki di Checkpoint 20
        val finalPrice = when (customerType) {
            "REGULAR" -> basePrice
            "VIP" -> basePrice * 0.90
            else -> basePrice
        }

        println("Memproses pesanan $itemName seharga $finalPrice")

        // Panggil fungsi lewat interface (DIP)
        repo.saveOrder(itemName, finalPrice, customerType)
        notifier.sendNotification("Pesanan $itemName Anda telah dikonfirmasi!")
    }
}