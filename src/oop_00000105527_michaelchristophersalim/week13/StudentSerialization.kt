package oop_00000105527_michaelchristophersalim.week13

import java.io.File
import java.io.FileNotFoundException

data class Student(val name: String, val age: Int, val gpa: Double)

// Serialization (Object -> CSV)
fun Student.toCsv(): String = "$name,$age,$gpa"

// Deserialization (CSV -> Object)
fun fromCsv(line: String): Student {
    val parts = line.split(",")
    return Student(name = parts[0], age = parts[1].toInt(), gpa = parts[2].toDouble())
}