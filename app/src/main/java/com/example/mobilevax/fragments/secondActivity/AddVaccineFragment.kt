package com.example.mobilevax.fragments.secondActivity

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mobilevax.R
import com.example.mobilevax.adapters.VaccineAdapter
import com.example.mobilevax.databinding.FragmentAddvaccineBinding
import com.example.mobilevax.model.Vaccine
import com.example.mobilevax.viewmodel.VaccineViewModel
import java.util.*

class AddVaccineFragment: Fragment(R.layout.fragment_addvaccine) {
    private lateinit var binding: FragmentAddvaccineBinding
    private lateinit var adapter: VaccineAdapter
    private lateinit var mVaccineViewModel: VaccineViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //val view = inflater.inflate(R.layout.fragment_addvaccine, container, false)
        binding = FragmentAddvaccineBinding.inflate(layoutInflater)

        mVaccineViewModel = ViewModelProvider(this).get(VaccineViewModel::class.java)

        binding.btnAdd.setOnClickListener(this::addVaccine)
        return binding.root
    }

    private fun addVaccine(it : View) {
        val newVaccineName = binding.edAddName.text.toString()
        val day = binding.datePickerVaccine.dayOfMonth
        val month = binding.datePickerVaccine.month
        val year = binding.datePickerVaccine.year

        if (validInput(newVaccineName)) {
            val vaccine = Vaccine(0,newVaccineName,Date(day,month,year))
            mVaccineViewModel.addVaccine(vaccine)
            //display message to show its done succesfully
            Toast.makeText(requireContext(),
                "Added vaccine.",
                Toast.LENGTH_LONG).show()
            //navigate back
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frameLayout, VaccineListFragment())
            fragmentTransaction.commit()
        }
        else {
            Toast.makeText(requireContext(),
                "Please fill in a name for the vaccine.",
                Toast.LENGTH_LONG).show()
        }
    }

    private fun validInput(name: String): Boolean {
        return !(TextUtils.isEmpty(name))
    }
}