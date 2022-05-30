package com.example.mobilevax.fragments.firstActivity

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mobilevax.R
import com.example.mobilevax.databinding.FragmentRegisterBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class RegisterFragment : Fragment(R.layout.fragment_register) {
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
        binding.btnRegister.setOnClickListener(this::makeAccount)
        return binding.root
    }

    private fun makeAccount(view: View) {
        when {
            !isConnected() -> { //controle op internetverbinding.
                msgToast("No internet connection. Connect with the internet.")
            }
            //Als er enkel spaties worden ingevoerd wordt er gevraagd input te geven
            TextUtils.isEmpty(binding.edRegisterEmail.text.toString().trim { it <= ' ' }) -> {
                msgToast("Please enter an email address")
            }
            TextUtils.isEmpty(binding.edRegisterPassword.text.toString().trim { it <= ' ' }) -> {
                msgToast("Please enter a password")
            }
            else -> {
                val email: String = binding.edRegisterEmail.text.toString().trim { it <= ' ' }
                val password: String = binding.edRegisterPassword.text.toString().trim { it <= ' ' }

                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(
                        OnCompleteListener<AuthResult> { task ->
                            if (task.isSuccessful) {
                                val firebaseUser: FirebaseUser = task.result!!.user!!
                                msgToast("Account created")
                                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                            } else {
                                msgToast("Password of email is incorrect")
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

    private fun msgToast(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_LONG).show()

    }

    private fun isConnected(): Boolean {
        var wifiConnected = false
        var mobileConnected = false
        val connectivityManager = requireActivity().getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo

        if (networkInfo != null && networkInfo.isConnected) {
            wifiConnected = networkInfo.type == ConnectivityManager.TYPE_WIFI
            mobileConnected = networkInfo.type == ConnectivityManager.TYPE_MOBILE
        }

        return wifiConnected || mobileConnected
    }
}