package com.example.mobilevax

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobilevax.databinding.FragmentVaccinelistBinding
import com.example.mobilevax.model.Vaccine

class VaccineListFragment : Fragment(R.layout.fragment_vaccinelist) {

    private lateinit var binding: FragmentVaccinelistBinding
    private val vaccineList = sampleTodoList()
    private lateinit var main: HomeActivity
    private lateinit var adapter: VaccineAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVaccinelistBinding.inflate(layoutInflater)
        main = activity as HomeActivity

        adapter = VaccineAdapter(vaccineList)
        binding.rvwVaccine.adapter = adapter
        // If we don't supply a layout manager, the recyclerview will not be displayed
        // there are three options here: a simple LinearLayoutManager (1-dimensional), a GridLayoutManager (2D) or a StaggeredGridLayoutManager
        binding.rvwVaccine.layoutManager = LinearLayoutManager(this.context)

        binding.btnAddVaccine.setOnClickListener {
            /*
            val newVaccineTitle = binding.edtTodo.text.toString()
            // this will not automatically updat the view!
            todoList.add(Todo(newTodoTitle, false))
            adapter.notifyItemInserted(todoList.size - 1)
            // adapter.notifyDatasetChanged() also works but will update EVERYTHING, which is not too efficient.
            binding.edtTodo.text.clear()
            binding.edtTodo.clearFocus()

            main.hideKeyboard(it)
             */
        }
        return binding.root
    }

    private fun sampleTodoList() = arrayListOf(
        Vaccine("Moderna"),
        Vaccine("Moderna"),
        Vaccine("Moderna"),
        Vaccine("Moderna"),
        Vaccine("Moderna"),
        Vaccine("Moderna"),
        Vaccine("Pfizer"),
        Vaccine("Astra"),
        Vaccine("flu-shotje"),
        Vaccine("shotje van verkiezingen")
    )
}