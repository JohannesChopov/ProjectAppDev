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
        binding = FragmentAddvaccineBinding.inflate(layoutInflater)

        mVaccineViewModel = ViewModelProvider(this)[VaccineViewModel::class.java]

        binding.btnAdd.setOnClickListener(this::addVaccine)
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

    private fun addVaccine(it : View) {
        val newVaccineName = binding.edAddName.text.toString()

        val day = binding.datePickerVaccine.dayOfMonth
        val month = binding.datePickerVaccine.month
        val year = binding.datePickerVaccine.year
        //For some reason somewhere a 1900 is always added to year. Years in date start from this.
        val vaccineDate = Date(year-1900,month-0,day-0)

        if (validNameInput(newVaccineName)) {
            if (hasDatePassed(vaccineDate)) {
                val vaccine = Vaccine(0,newVaccineName,vaccineDate)
                mVaccineViewModel.addVaccine(vaccine)
                //display message to show its done succesfully
                msgToast("Added vaccine.")
                //navigate back
                val fragmentManager = requireActivity().supportFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.frameLayout, HostListOrInfoFragment())
                fragmentTransaction.commit()
            }
            else {
                msgToast("Please use a date that has passed.")
            }
        }
        else {
            msgToast("Please fill in a name for the vaccine.")
        }
    }

    private fun msgToast(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
    }

    private fun validNameInput(name: String): Boolean {
        return !(TextUtils.isEmpty(name.trim { it <= ' ' }))
    }

    private fun hasDatePassed(vaccineDate: Date): Boolean {
        return !vaccineDate.after(Date())
    }
}