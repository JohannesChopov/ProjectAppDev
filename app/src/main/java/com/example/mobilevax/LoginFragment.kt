package com.example.mobilevax

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mobilevax.databinding.FragmentLoginBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("Fragment: onCreateView")
        // this looks a lot like activities! Fragments have their own lifecycle.
        // return inflater.inflate(R.layout.fragment_first, container, false)
        // -- above should NOT be needed since we used a constructor argument!
        binding = FragmentLoginBinding.inflate(layoutInflater)
        binding.btnGoToRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
        binding.btnLogin.setOnClickListener(this::loginAccount)
        // remember to do this instead of super.onCreateView()
        // otherwise nothing will happen.
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("Fragment: onViewCreated")
    }

    // here the view should NOT be set: onCreateView() is called afterwards.
    // remember that accessing UI components here will crash!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("Fragment: onCreate")
    }

    private fun login(view: View) {
        if(binding.edLoginEmail.text.toString().isEmpty()) {
            msg("Your username is empty!", view)
            return
        }
        if(!binding.edLoginPassword.text.contentEquals("test")) {
            msg("Invalid password!", view)
            return
        }

        msg("And we're in!", view)
        val intent = Intent(activity, HomeActivity::class.java)
        // 1. the "easy but stupid" way
        // intent.putExtra("username", binding.txtUsername.text.toString())
        // 2. the "better" way, using a model
        //intent.putExtra("user", createUser())
        startActivity(intent)
    }
    private fun msg(text: String, view: View) {
        Snackbar.make(view, text, Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()

    }

    private fun loginAccount(view: View) {
        when {
            binding.edLoginEmail.text.toString().isEmpty() -> {
                msg("Please enter Email", view)
            }
            binding.edLoginPassword.text.toString().isEmpty() -> {
                msg("Please enter a Password", view)
            }
            else -> {
                val email:String = binding.edLoginEmail.text.toString().trim { it <= ' '}
                val password:String = binding.edLoginPassword.text.toString().trim { it <= ' '}

                FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password).addOnCompleteListener(
                    OnCompleteListener<AuthResult> { task ->
                        if (task.isSuccessful) {
                            val firebaseUser: FirebaseUser = task.result!!.user!!
                            msg("Logging in", view)
                            val intent = Intent(activity,HomeActivity::class.java)
                            startActivity(intent)
                        }
                        else {
                            msg("Email or password are wrong", view)
                        }
                    }
                )
            }
        }
    }
}