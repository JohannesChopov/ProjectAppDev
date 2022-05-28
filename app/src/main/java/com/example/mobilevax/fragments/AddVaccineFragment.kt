package com.example.mobilevax.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mobilevax.MainActivity
import com.example.mobilevax.R
import com.example.mobilevax.adapters.VaccineAdapter
import com.example.mobilevax.databinding.FragmentAddvaccineBinding
import com.example.mobilevax.databinding.FragmentTestBinding
import com.example.mobilevax.databinding.FragmentVaccinelistBinding
import com.example.mobilevax.model.Vaccine
import com.google.firebase.auth.FirebaseAuth
import java.util.*

class AddVaccineFragment: Fragment(R.layout.fragment_addvaccine) {
    private lateinit var binding: FragmentAddvaccineBinding
    private lateinit var recyclerviewFrag: VaccineListFragment
    private lateinit var adapter: VaccineAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddvaccineBinding.inflate(layoutInflater)
        // use the "elvis operator": if left-hand side is null, provide right-hand side.
        // since arguments is nullable ("?"), always make sure to provide an alternative.
        /*
        data = (arguments?.getSerializable("mydata") as MySharedData?) ?: MySharedData()

        binding.txtFragmentSecond.text = "Fragment 2, model: ${data.age}"
         */
        binding.btnAdd.setOnClickListener(this::addVaccine)
        return binding.root
    }

    private fun addVaccine(it : View) {
        val newVaccineName = binding.edAddName.text.toString()
        val day = binding.datePickerVaccine.dayOfMonth
        val month = binding.datePickerVaccine.month
        val year = binding.datePickerVaccine.year

        var vaxList = recyclerviewFrag.vaccineList
        vaxList.add(Vaccine(newVaccineName, Date(day,month,year)))

        adapter.notifyItemInserted(vaxList.size - 1)
        binding.edAddName.text.clear()
        binding.edAddName.clearFocus()
    }
}