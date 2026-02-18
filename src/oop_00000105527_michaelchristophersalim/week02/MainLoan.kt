package oop_00000105527_michaelchristophersalim.week02

import java.util.Scanner

fun main(){
    val scanner = Scanner(System.`in`)

    println("--- Aplikasi Perpustakaan ---")

    print("Input Judul: ")
    val titleLoan = scanner.nextLine()

    print("Input Nama Peminjam: ")
    val titleBorrower = scanner.nextLine()

    print("Input Lama Pinjam: ")
    var titleLoanDur = scanner.nextInt()
    scanner.nextLine()

    if (titleLoanDur < 0){
        titleLoanDur = 1
    }

    val l1 = Loan(titleLoan, titleBorrower, titleLoanDur)
    println("\n--- Detail Peminjaman ---")
    println("Judul Buku    : ${l1.bookTitle}")
    println("Peminjam      : ${l1.borrower}")
    println("Lama Pinjam   : ${l1.loanDuration} hari")
    println("Total Denda   : Rp ${l1.calculateFine()}")
}