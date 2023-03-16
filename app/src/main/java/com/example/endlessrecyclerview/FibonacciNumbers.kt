package com.example.endlessrecyclerview

import java.math.BigInteger

class FibonacciNumbers : NumInterface {

    private var a = "0"
    private var b = "1"

    override fun next(): String {
        /*a = b
        b = sum
        sum = a + b*/
        val sum = BigInteger(a).add(BigInteger(b)).toString()
        val temp = a
        a = b
        b = sum
        return temp
    }

}