package oop_00000105527_michaelchristophersalim.week10

class WalletRepository<T : HasName> {

    private val items = mutableListOf<T>()

    fun add(item: T) {
        items.add(item)
    }

    fun getAll(): List<T> {
        return items
    }

    //Karena opsional untuk constraint <T: Any>, saya pakai HasName saja
    fun findByName(name: String): List<T> {
        return items.filter { it.name == name }
    }
}