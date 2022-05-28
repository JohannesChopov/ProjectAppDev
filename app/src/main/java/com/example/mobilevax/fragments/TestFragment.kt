package com.example.mobilevax.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mobilevax.MainActivity
import com.example.mobilevax.R
import com.example.mobilevax.databinding.FragmentTestBinding

import com.google.firebase.auth.FirebaseAuth

class TestFragment: Fragment(R.layout.fragment_register) {
    private lateinit var binding: FragmentTestBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTestBinding.inflate(layoutInflater)
        // use the "elvis operator": if left-hand side is null, provide right-hand side.
        // since arguments is nullable ("?"), always make sure to provide an alternative.
        /*
        data = (arguments?.getSerializable("mydata") as MySharedData?) ?: MySharedData()

        binding.txtFragmentSecond.text = "Fragment 2, model: ${data.age}"
         */
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