package com.example.endlessrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private val btnPrime: Button by lazy { findViewById(R.id.btnPrime) }
    private val btnFibonacci: Button by lazy { findViewById(R.id.btnFibonacci) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val prime = PrimeNumbers()
        for (i in 1..20) {
            Log.d("Hamster prime", "${prime.next()}")
        }
        val fibonacci = FibonacciNumbers()
        for (i in 1..20) {
            Log.d("Hamster fibonacci", "${fibonacci.next()}")
        }*/

    }
}