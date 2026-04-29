package oop_00000105527_michaelchristophersalim.week10

class WalletRepository<T> {

    private val items = mutableListOf<T>()

    fun add(item: T) {
        items.add(item)
    }

    fun getAll(): List<T> {
        return items
    }

    // khusus untuk yang punya name
    fun findByName(name: String): List<T> {
        return items.filter {
            (it as? HasName)?.name == name
        }
    }
}