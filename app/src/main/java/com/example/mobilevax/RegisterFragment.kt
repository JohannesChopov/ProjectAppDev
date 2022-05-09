package com.example.mobilevax

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mobilevax.databinding.FragmentRegisterBinding

class RegisterFragment: Fragment(R.layout.fragment_register) {
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        binding.btnGoToLogin.setOnClickListener {
            // adding an object to a bundle only works with serialization plugins!
            // see the intents parts of the course.
            //val bundle = bundleOf("mydata" to data)
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
        // use the "elvis operator": if left-hand side is null, provide right-hand side.
        // since arguments is nullable ("?"), always make sure to provide an alternative.
        /*
        data = (arguments?.getSerializable("mydata") as MySharedData?) ?: MySharedData()

        binding.txtFragmentSecond.text = "Fragment 2, model: ${data.age}"
         */
        return binding.root
    }
}