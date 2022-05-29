package com.example.mobilevax.activities

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilevax.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var menuBarToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //binding.btnLogin.setOnClickListener(this::login)


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


    /*
    override fun onSaveInstanceState(outState: Bundle) {
        println("MainActivity--OnSaveInstanceState (1arg)")
        outState.run {
            putString("name", binding.txtLoginName.text.toString())
            // Do we want to save the password? Think about it...
        }
        super.onSaveInstanceState(outState)
    }

    // Watch out with this method with two arguments, it will only work with Lollipop and higher
    // See https://stackoverflow.com/questions/30549722/onsaveinstancestate-is-not-getting-called-after-screen-rotation/30549787
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        println("MainActivity--OnSaveInstanceState (2args)")
        super.onSaveInstanceState(outState, outPersistentState)
        super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        println("MainActivity--onRestoreInstanceState (2args)")
        super.onRestoreInstanceState(savedInstanceState, persistentState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        println("MainActivity--onRestoreInstanceState (1arg)")
        savedInstanceState.run {
            binding.txtLoginName.setText(getString("name"))
        }
        super.onRestoreInstanceState(savedInstanceState)
    }
    private fun login(view: View) {
        if(binding.txtLoginName.text.toString().isEmpty()) {
            msg("Your username is empty!", view)
            return
        }
        if(!binding.txtPassword.text.contentEquals("test")) {
            msg("Invalid password!", view)
            return
        }

        msg("And we're in!", view)
        val intent = Intent(this, HomeActivity::class.java)
        // 1. the "easy but stupid" way
        // intent.putExtra("username", binding.txtUsername.text.toString())
        // 2. the "better" way, using a model
        intent.putExtra("user", createUser())
        startActivity(intent)
    }

    private fun createUser(): User {
        return User(binding.txtLoginName.text.toString())
    }

    private fun msg(text: String, view: View) {
        Snackbar.make(view, text, Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()

    }
     */
}