package com.example.android_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, InputFragment())
            .commit()
    }

    fun showResultFragment(selectedBook: String, selectedYear: String) {
        val resultFragment = ResultFragment.newInstance(selectedBook, selectedYear)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, resultFragment)
            .addToBackStack(null)
            .commit()
    }

    fun showInputFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, InputFragment())
            .commit()
    }
}
