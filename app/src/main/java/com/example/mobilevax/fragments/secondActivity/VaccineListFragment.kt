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
    //private lateinit var main: HomeActivity
    private lateinit var adapter: VaccineAdapter
    private lateinit var vaccineViewModel: VaccineViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVaccinelistBinding.inflate(layoutInflater)
        //main = activity as HomeActivity

        adapter = VaccineAdapter(/*this*/)
        binding.rvwVaccine.adapter = adapter
        // If we don't supply a layout manager, the recyclerview will not be displayed
        // there are three options here: a simple LinearLayoutManager (1-dimensional), a GridLayoutManager (2D) or a StaggeredGridLayoutManager
        binding.rvwVaccine.layoutManager = LinearLayoutManager(this.context)

        //VaccineViewModel
        vaccineViewModel = ViewModelProvider(this).get(VaccineViewModel::class.java)
        vaccineViewModel.readAllData.observe(viewLifecycleOwner, Observer { vaccine ->
            adapter.setData(vaccine)
        })
        return binding.root
    }
}