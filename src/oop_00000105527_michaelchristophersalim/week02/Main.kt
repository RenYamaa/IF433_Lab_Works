package oop_00000105527_michaelchristophersalim.week02

import java.util.Scanner

fun main(){
    val scanner = Scanner(System.`in`)

    println("--- Aplikasi PMB UMN ---")

    print("Masukkan Nama: ")
    val name = scanner.nextLine()

    print("Masukkan NIM (Wajib 5 karakter): ")
    val nim = scanner.next()

    print("Pilih Jalur (1. Reguler, 2. Umum): ")
    val type = scanner.nextInt()
    scanner.nextLine() //Consume newLine

    if (type == 1){
        print("Masukkan Jurusan: ")
        val major = scanner.nextLine()
        //Call Primary Constructor
        // Instansiasi Objek karena data sudah aman
        val s1 = Student(name, nim, major)
        println("Terdafatr di: ${s1.major} dengan GPA awal ${s1.gpa}")
    } else if (type == 2){
        // Memanggil Secondary Constructor, jurusan otomatis "Non-Matriculated"
        val s2 = Student(name, nim)
        println("Terdaftar di: ${s2.major} dengan GPA awal ${s2.gpa}")
    } else {
        println("Pilihan tidak ada! Pendaftaran batal.")
    }
}