package oop_00000105527_michaelchristophersalim.week10

import kotlin.text.toDouble

class MathBox<T: Number>(var value1: T, val value2: T){
    fun sum(): Double {
        return value1.toDouble() + value2.toDouble()
    }
}
