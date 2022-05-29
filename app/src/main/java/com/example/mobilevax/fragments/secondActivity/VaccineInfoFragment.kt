package com.example.mobilevax.fragments.secondActivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mobilevax.R
import com.example.mobilevax.databinding.FragmentVaccineinfoBinding

class VaccineInfoFragment: Fragment(R.layout.fragment_vaccineinfo) {
    private lateinit var binding: FragmentVaccineinfoBinding

    private val args by navArgs<VaccineInfoFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVaccineinfoBinding.inflate(layoutInflater)

        binding.textNameContent.setText(args.currentVaccine.name)
        binding.textDateContent.setText(args.currentVaccine.date.toString())

        binding.btnReturn.setOnClickListener {
            findNavController().navigate(R.id.action_vaccineinfoFragment_to_listFragment)
        }

        return binding.root
    }
}