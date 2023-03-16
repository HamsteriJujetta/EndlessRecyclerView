package com.example.endlessrecyclerview

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {

    private val btnPrime: Button by lazy { findViewById(R.id.btnPrime) }
    private val btnFibonacci: Button by lazy { findViewById(R.id.btnFibonacci) }
    private val rvList: RecyclerView by lazy { findViewById(R.id.rvList) }

    private val whiteColor by lazy { ContextCompat.getColor(applicationContext, R.color.white) }
    private val customColor by lazy { ContextCompat.getColor(applicationContext, R.color.custom1) }

    private var numbers: NumInterface = PrimeNumbers()

    private val adapter: CustomAdapter by lazy {
        CustomAdapter(
            ContextCompat.getColor(applicationContext, R.color.light_grey),
            ContextCompat.getColor(applicationContext, R.color.dark_grey)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnFibonacci.setBackgroundColor(customColor)
        btnPrime.setOnClickListener {
            btnPrime.setBackgroundColor(whiteColor)
            btnFibonacci.setBackgroundColor(customColor)
            numbers = PrimeNumbers()
            setList()
        }

        btnFibonacci.setOnClickListener {
            btnPrime.setBackgroundColor(customColor)
            btnFibonacci.setBackgroundColor(whiteColor)
            numbers = FibonacciNumbers()
            setList()
        }

        var visibleItemCount = 0
        var totalItemCount = 0
        var pastVisiblesItems = 0
        var loading = true
        val layoutManager = LinearLayoutManager(this)
        rvList.layoutManager = layoutManager
        rvList.setOnScrollChangeListener { view, scrollX, scrollY, oldScrollX, oldScrollY ->
            if ( (scrollY - oldScrollY) > 0 ) {
                visibleItemCount = layoutManager.childCount
                totalItemCount = layoutManager.itemCount
                pastVisiblesItems = layoutManager.findFirstVisibleItemPosition()
                if (loading) {
                    if ((visibleItemCount + pastVisiblesItems) >=totalItemCount ) {
                        loading = false
                        Log.d("Hamster", "is scared")
                        setList()
                        loading = true
                    }
                }
            }
        }

        setList()
    }

    private fun setList() {
        val list = mutableListOf<Pair<String, String>>()
        for (i in 1..100) {
            list.add(Pair(numbers.next(), numbers.next()))
        }
        adapter.setData(list.toList())
        rvList.adapter = adapter
    }

}