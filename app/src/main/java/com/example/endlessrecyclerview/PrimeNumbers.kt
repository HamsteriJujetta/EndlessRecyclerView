package com.example.endlessrecyclerview

class PrimeNumbers {

    private var current: Int = 2

    fun next(): Int {
        val temp = current

        while (true) {
            current++
            var i = 2
            var nonPrime = false
            for (i in 2..current/2) {
                if (current % i == 0) {
                    nonPrime = true
                    break
                }
            }
            if (!nonPrime) {
                break
            }
        }

        return temp
    }

}