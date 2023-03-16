package com.example.endlessrecyclerview

import java.math.BigInteger

class PrimeNumbers : NumInterface {

    private var current = "2"

    override fun next(): String {
        val temp = current
        current = BigInteger(current).nextProbablePrime().toString()
        return temp
    }

}