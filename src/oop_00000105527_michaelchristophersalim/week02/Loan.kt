package oop_00000105527_michaelchristophersalim.week02

class Loan (val bookTitle: String, val borrower: String, val loanDuration: Int = 1){
    fun calculateFine(): Int {
        if(loanDuration > 3){
            val fine = loanDuration - 3
            return fine * 2000
        } else {
            return 0
        }
    }
}