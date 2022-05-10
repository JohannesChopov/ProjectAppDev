package com.example.mobilevax

import android.graphics.Bitmap
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilevax.databinding.ActivityHomeBinding
import com.example.mobilevax.model.User

class HomeActivity : AppCompatActivity(){
    private lateinit var binding: ActivityHomeBinding
    private lateinit var pictureActivityResult: ActivityResultLauncher<Void>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*
        val user: User = intent.getSerializableExtra("user") as User
        //binding.txtWelcome.text = "Welcome, ${user.name}"
         */
        println("WelcomeActivity--onCreate")
    }
    override fun onStart() {
        super.onStart()
        println("WelcomeActivity--onStart")
    }

    override fun onResume() {
        super.onResume()
        println("WelcomeActivity--onResume")
    }

    override fun onPause() {
        super.onPause()
        println("WelcomeActivity--onPause")
    }

    override fun onStop() {
        super.onStop()
        println("WelcomeActivity--onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("WelcomeActivity--onDestroy")
    }
}