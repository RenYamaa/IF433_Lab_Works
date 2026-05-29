package oop_00000105527_michaelchristophersalim.week14

interface Shape {
    fun area(): Int
}

class SafeRectangle(var width: Int, var var height: Int) : Shape {
    override fun area() = width * height
}

class SafeSquare(var side: Int) : Shape {
    override fun area() = side * side
}