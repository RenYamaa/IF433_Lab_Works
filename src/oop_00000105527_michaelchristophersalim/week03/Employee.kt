package oop_00000105527_michaelchristophersalim.week03

class Employee(val name: String) {
    var salary: Int = 0
        set(value) {
            println("Mencoba set gaji ke: $value")
            //Kode dibawah ini salah dan berbahaya!
            //Kita memanggil setter di dalam setter (Recursive)
            this.salary = value
        }
}