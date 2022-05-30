package com.example.mobilevax.fragments.secondActivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobilevax.R
import com.example.mobilevax.adapters.VaccineAdapter
import com.example.mobilevax.databinding.FragmentVaccinelistBinding
import com.example.mobilevax.viewmodel.VaccineViewModel

class VaccineListFragment : Fragment(R.layout.fragment_vaccinelist) {

    private lateinit var binding: FragmentVaccinelistBinding
    private lateinit var adapter: VaccineAdapter
    private lateinit var vaccineViewModel: VaccineViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVaccinelistBinding.inflate(layoutInflater)

        adapter = VaccineAdapter()
        binding.rvwVaccine.adapter = adapter
        binding.rvwVaccine.layoutManager = LinearLayoutManager(this.context)

        //VaccineViewModel
        vaccineViewModel = ViewModelProvider(this).get(VaccineViewModel::class.java)
        vaccineViewModel.readAllData.observe(viewLifecycleOwner, Observer { vaccine ->
            adapter.setData(vaccine)
            checkEmptyList(binding,adapter)
        })

        return binding.root
    }

    private fun checkEmptyList(bind: FragmentVaccinelistBinding, adapter: VaccineAdapter) {
        //Bij lege lijst een mededeling
        if (adapter.itemCount == 0) {
            bind.txtEmptyMessage.text = "No vaccines added.\n Use button on top left to add new vaccine."
        } //anders geen mededeling
        else {
            bind.txtEmptyMessage.text = ""
        }
    }


}