package oop_00000105527_michaelchristophersalim.week02

import java.util.Scanner

fun main(){
    val scanner = Scanner(System.`in`)

    println("--- Aplikasi PMB UMN ---")

    print("Masukkan Nama: ")
    val name = scanner.nextLine()

    print("Masukkan NIM (Wajib 5 karakter): ")
    val nim = scanner.next()

    scanner.nextLine() //Bersihkan buffer newline

    //Validasi di sisi pemanggil (Main)
    if(nim.length != 5) {
        println("ERROR: Pendaftaran dibatalkan. NIM harus berisi 5 karakter!")
        //Program berhenti disini untuk mahasiswa ini, tidak membuat objek
    } else {
        print("Masukkan Jurusan: ")
        val major = scanner.nextLine()

        // Instansiasi Objek karena data sudah aman
        val s1 = Student(name, nim, major)
        println("Status: Pendaftaran selesai.")
    }
}