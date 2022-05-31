package com.example.mobilevax.fragments.secondActivity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mobilevax.R
import com.example.mobilevax.activities.MainActivity
import com.example.mobilevax.databinding.FragmentLogoutBinding
import com.google.firebase.auth.FirebaseAuth

class LogoutFragment: Fragment(R.layout.fragment_register) {
    private lateinit var binding: FragmentLogoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLogoutBinding.inflate(layoutInflater)
        binding.btnLogOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
            //Na het uitloggen mag de gebruiker niet zomaar met de back knop terug kunnen in de applicatie
            requireActivity().finish()
        }
        binding.btnDeleteAccount.setOnClickListener {
            FirebaseAuth.getInstance().currentUser!!.delete()
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
            //Na het uitloggen mag de gebruiker niet zomaar met de back knop terug kunnen in de applicatie
            requireActivity().finish()
        }
        return binding.root
    }
}