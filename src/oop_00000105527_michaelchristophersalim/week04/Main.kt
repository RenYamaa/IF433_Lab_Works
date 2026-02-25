package oop_00000105527_michaelchristophersalim.week04

fun main(){
    println("--- Testing Vehicle ---")
    val generateVehicle = Vehicle("Sepeda ontel")
    generateVehicle.honk()
    generateVehicle.accelerate()

    println("\n--- Testing Car ---")
    val myCar = Car("Toyota", 4)
    myCar.openTrunk()
    myCar.honk()
    myCar.accelerate()

    val myEcar = ElectricCar("Tesla", 4, 100)
    myEcar.openTrunk()
    myEcar.honk()
    myEcar.accelerate()
}