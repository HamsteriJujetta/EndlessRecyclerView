package com.example.endlessrecyclerview

class FibonacciNumbers {

    private var a: Int = 0
    private var b: Int = 1
    private var sum: Int = a + b

    fun next(): Int {
        val temp = sum

        a = b
        b = sum
        sum = a + b

        return temp
    }

}