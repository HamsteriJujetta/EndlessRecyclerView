package com.example.endlessrecyclerview

import java.math.BigInteger

class PrimeNumbers : NumInterface {

    private var current = "2"

    override fun next(): String {
        val temp = current
        current = BigInteger(current).nextProbablePrime().toString()
        /*while (true) {
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
        }*/
        return temp
    }

}