package oop_00000105527_michaelchristophersalim.week04

open class Car(brand: String, val numberOfDoors: Int) : Vehicle(brand) {

    fun openTrunk() {
        println("Bagasi mobil $brand dengan $numberOfDoors pintu dibuka.")
    }

    override fun honk(){
        println("TIN TIN! Mobil $brand lewat!")
    }

    override fun accelerate(){
        super.accelerate()
        println("Mobil $brand menggunnakan transmisi gigi untuk menambah kecepatan.")
    }
}