package com.example.mobilevax.fragments.firstActivity

import android.content.Context
import android.content.Intent
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
import com.example.mobilevax.activities.HomeActivity
import com.example.mobilevax.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        binding.btnGoToRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
        binding.btnLogin.setOnClickListener(this::loginAccount)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("Fragment: onViewCreated")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("Fragment: onCreate")
    }

    private fun msgToast(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
    }

    private fun loginAccount(view: View) {
        when {
            !isConnected() -> { //controle op internetverbinding.
                msgToast("No internet connection. Connect with the internet.")
            }
            //Als er enkel spaties worden ingevoerd is het ongeldig
            TextUtils.isEmpty(binding.edLoginEmail.text.toString().trim { it <= ' ' }) -> {
                msgToast("Please enter an email")
            }
            TextUtils.isEmpty(binding.edLoginPassword.text.toString().trim { it <= ' ' }) -> {
                msgToast("Please enter a password")
            }
            else -> {
                val email: String = binding.edLoginEmail.text.toString().trim { it <= ' ' }
                val password: String = binding.edLoginPassword.text.toString().trim { it <= ' ' }
                FirebaseAuth.getInstance().fetchSignInMethodsForEmail(email).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                val firebaseUser: FirebaseUser = task.result!!.user!!
                                msgToast("Logging in")
                                //ga naar de volgende activity. Waar het om draait
                                val intent = Intent(activity, HomeActivity::class.java)
                                intent.putExtra("userEmail", firebaseUser.email)
                                startActivity(intent)
                            } else {
                                msgToast("Password is incorrect. Try with another password")
                            }
                        }
                    } else {
                        msgToast("Email is not registered. First register your email")
                    }
                }
            }
        }
    }

    private fun isConnected(): Boolean {
        var wifiConnected = false
        var mobileConnected = false

        val connectivityManager = requireActivity().getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo

        if (networkInfo != null && networkInfo.isConnected) {
            wifiConnected = (networkInfo.type == ConnectivityManager.TYPE_WIFI)
            mobileConnected = (networkInfo.type == ConnectivityManager.TYPE_MOBILE)
        }
        return (wifiConnected || mobileConnected)
    }
}