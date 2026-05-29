package oop_00000105527_michaelchristophersalim.week12

fun dispenseKibble(requestedGram: Int, availableGram: Int, isJammed: Boolean): Int {
    require(requestedGram > 0) { "Porsi kibble harus lebih dari 0 gr" }

    if (isJammed) {
        throw DispenserJamException()
    }

    if (requestedGram > availableGram) {
        throw FoodEmptyException(requestedGram, availableGram)
    }

    println("Kibble berhasil dikeluarkan!")
    return availableGram - requestedGram
}

fun main() {
    var currentKibbleStock = 50

    try {
        currentKibbleStock = dispenseKibble(
            requestedGram = 80,
            availableGram = currentKibbleStock,
            isJammed = false
        )
    } catch (e: DispenserJamException) {
        println("Caught Domain Error: ${e.message}")
    } catch (e: FoodEmptyException) {
        println("Caught Domain Error: ${e.message}")
    } catch (e: Exception) {
        println("Caught General Error: Terjadi kesalahan tidak terduga.")
    } finally {
        println("Siklus pengecekan dispenser pagi selesai.")
    }
}