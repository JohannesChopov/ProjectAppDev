package com.example.mobilevax.fragments.secondActivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mobilevax.R
import com.example.mobilevax.activities.HomeActivity
import com.example.mobilevax.databinding.FragmentHostListOrInfoBinding

class HostListOrInfoFragment : Fragment(R.layout.fragment_host_list_or_info) {

    private lateinit var binding: FragmentHostListOrInfoBinding
    private lateinit var main: HomeActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHostListOrInfoBinding.inflate(layoutInflater)
        main = activity as HomeActivity

        return binding.root
    }
}