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
            startActivity(Intent(activity, MainActivity::class.java))
        }
        binding.btnDeleteAccount.setOnClickListener {
            FirebaseAuth.getInstance().currentUser!!.delete()
            startActivity(Intent(activity, MainActivity::class.java))
        }
        return binding.root
    }
}