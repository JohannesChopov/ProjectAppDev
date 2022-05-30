package com.example.mobilevax.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilevax.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        println("MainActivity--onCreate")
    }

    override fun onStart() {
        super.onStart()
        println("MainActivity--onStart")
    }

    override fun onResume() {
        super.onResume()
        println("MainActivity--onResume")
    }

    override fun onPause() {
        super.onPause()
        println("MainActivity--onPause")
    }

    override fun onStop() {
        super.onStop()
        println("MainActivity--onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("MainActivity--onDestroy")
    }
}