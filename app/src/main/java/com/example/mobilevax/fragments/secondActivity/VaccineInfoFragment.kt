package com.example.mobilevax.fragments.secondActivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mobilevax.R
import com.example.mobilevax.databinding.FragmentVaccineinfoBinding
import com.example.mobilevax.viewmodel.VaccineViewModel
import java.text.SimpleDateFormat

class VaccineInfoFragment: Fragment(R.layout.fragment_vaccineinfo) {
    private lateinit var binding: FragmentVaccineinfoBinding
    private lateinit var vaccineViewModel: VaccineViewModel

    //nodig voor informatie via navcontroller door te voeren
    private val args by navArgs<VaccineInfoFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVaccineinfoBinding.inflate(layoutInflater)

        vaccineViewModel = ViewModelProvider(this).get(VaccineViewModel::class.java)
        binding.textNameContent.setText(args.currentVaccine.name)
        val df = SimpleDateFormat("dd/MM/yyyy")
        binding.textDateContent.setText(df.format(args.currentVaccine.date).toString())

        binding.btnReturn.setOnClickListener {
            findNavController().navigate(R.id.action_vaccineinfoFragment_to_listFragment)
        }
        binding.btnDelete.setOnClickListener {
            deleteVaccine()
        }

        return binding.root
    }

    private fun deleteVaccine() {
        vaccineViewModel.deleteVaccine(args.currentVaccine)
        findNavController().navigate(R.id.action_vaccineinfoFragment_to_listFragment)
    }
}