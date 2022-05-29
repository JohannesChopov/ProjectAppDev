package com.example.mobilevax.fragments.firstActivity

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mobilevax.R
import com.example.mobilevax.databinding.FragmentRegisterBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class RegisterFragment: Fragment(R.layout.fragment_register) {
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        binding.btnGoToLogin.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
        binding.btnRegister.setOnClickListener (this::makeAccount)
        return binding.root
    }

    private fun makeAccount(view: View) {
        when {
            //Als er enkel spaties worden ingevoerd crasht de app
            TextUtils.isEmpty(binding.edRegisterEmail.text.toString().trim { it <= ' '}) -> {
                msg("Please enter an email address", view)
            }
            TextUtils.isEmpty(binding.edRegisterPassword.text.toString().trim { it <= ' '}) -> {
                msg("Please enter a password", view)
            }
            else -> {
                val email:String = binding.edRegisterEmail.text.toString().trim { it <= ' '}
                val password:String = binding.edRegisterPassword.text.toString().trim { it <= ' '}

                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password).addOnCompleteListener(
                    OnCompleteListener<AuthResult> {
                        task -> if (task.isSuccessful) {
                            val firebaseUser: FirebaseUser = task.result!!.user!!
                            msg("Account created", view)
                            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                        }
                        else {
                            msg("Password of email is incorrect", view)
                        }
                    }
                )
            }
        }
    }

    private fun msg(text: String, view: View) {
        Snackbar.make(view, text, Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()

    }
}