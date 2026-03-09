package oop_00000105527_michaelchristophersalim.week05

fun main(){
    val dosen1 = Dosen("Pak Alex", "0123456")
    val admin1 = Admin("Bu Siti")

    // Polymorphic Collection: List yang berisi tipe Parent, tapi isinya objek Anak
    val daftarPegawai: List<Pegawai> = listOf(dosen1, admin1)

    println("=== AKTIVITAS PEGAWAI ===")
    for (pegawai in daftarPegawai){
        // Pemanggilan Runtime Polymorphism
        pegawai.bekerja()

        // Pegawai.mengajar() // Ini akan Error karena tipe referensinya adalah Pegawai

        // Smart Casting dengan is dan when
        when (pegawai){
            is Dosen -> {
                println("=> Terdeteksi sebagai Dosen (NIDN: ${pegawai.nidn})")
                pegawai.mengajar()
            }
            is Admin -> {
                println("=> Terdeteksi sebagai Admin")
                pegawai.doAdminWork()
            }
        }
        println("---------------------------")
    }

    // =========================
    // TUGAS MANDIRI 1
    // =========================

    val math = MathHelper()

    println("=== Perhitungan Luas ===")
    println("Luas Persegi: ${math.hitungLuas(4)}")
    println("Luas Persegi Panjang: ${math.hitungLuas(5,3)}")
    println("Luas Lingkaran: ${math.hitungLuas(7.0)}")

    // =========================
    // TUGAS MANDIRI 1
    // =========================

    val ewallet = Ewallet("Michael", 50000.0)
    val creditCard = CreditCard("Mikel", 100000.0)

    val metodePembayaran: List<PaymentMethod> = listOf(ewallet, creditCard)

    for (method in metodePembayaran){
        method.processPayment(75000.0)
    }
}