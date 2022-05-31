package com.example.mobilevax.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilevax.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    var firebaseAuth: FirebaseAuth? = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        println("MainActivity--onCreate")
    }

    override fun onStart() {
        super.onStart()

        //als er de vorige keer niet is uitgelogd, moet de user niet opnieuw inloggen
        checkIfLoggedIn()

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

    private fun checkIfLoggedIn() {
        val user : FirebaseUser? = firebaseAuth?.currentUser
        if (user != null) run {
            val intent = Intent(this, HomeActivity::class.java)
            //nodig voor email weer te geven in volgende activity
            intent.putExtra("userEmail", user.email)
            startActivity(intent)
            finish() //niet naar vorige activity gaan als er niet op "logout" is geklikt
        }
    }
}