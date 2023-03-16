package com.example.endlessrecyclerview

interface NumInterface {
    var leftNum: String
    var rightNum: String
    fun getNext(): NumInterface
}