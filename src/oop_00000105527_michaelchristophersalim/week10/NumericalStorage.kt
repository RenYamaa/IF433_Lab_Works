package oop_00000105527_michaelchristophersalim.week10

import kotlin.text.toDouble

class MathBox<T: Number>(var value1: T, val value2: T){
    fun sum(): Double {
        return value1.toDouble() + value2.toDouble()
    }
}

fun <T> getMax(a: T, b: T): T where T: Comparable<T>{
    return if (a > b) a else b
}
