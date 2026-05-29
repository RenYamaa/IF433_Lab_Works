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

// --- 4. Fix OCP: Abstraksi Diskon ---
interface PricingStrategy {
    fun calculate(price: Double): Double
}

class RegularPricing : PricingStrategy {
    override fun calculate(price: Double): Double = price
}

class VipPricing : PricingStrategy {
    override fun calculate(price: Double): Double = price * 0.90
}

// --- 5. Final Refactored Processor ---
class SafeOrderProcessor(
    val repo: OrderRepository,
    val notifier: NotificationService
) {
    // Fungsi processOrder dimodifikasi untuk menerima PricingStrategy
    fun processOrder(itemName: String, basePrice: Double, customerType: String, pricingStrategy: PricingStrategy) {
        // Kalkulasi harga diserahkan ke masing-masing class strategi
        val finalPrice = pricingStrategy.calculate(basePrice)

        println("Memproses pesanan $itemName seharga $finalPrice")

        repo.saveOrder(itemName, finalPrice, customerType)
        notifier.sendNotification("Pesanan $itemName Anda telah dikonfirmasi!")
    }
}

fun main() {
    val repo = CsvOrderRepository()
    val notifier = EmailNotifier()
    val processor = SafeOrderProcessor(repo, notifier)

    processor.processOrder("Laptop", 10000.0, "REGULAR", RegularPricing())
    processor.processOrder("Smartphone", 5000.0, "VIP", VipPricing())
}
