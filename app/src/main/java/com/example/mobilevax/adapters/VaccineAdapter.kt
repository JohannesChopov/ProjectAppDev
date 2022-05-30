package com.example.mobilevax.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilevax.R
import com.example.mobilevax.fragments.secondActivity.VaccineListFragmentDirections
import com.example.mobilevax.model.Vaccine

class VaccineAdapter() : RecyclerView.Adapter<VaccineAdapter.VaccineViewHolder>() {

    private var items = emptyList<Vaccine>()

    inner class VaccineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    // this creates the needed ViewHolder class that links our layout XML to our viewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VaccineViewHolder {
        // don't forget to set attachToRoot to false, otherwise it will crash!
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_vaccine, parent, false)
        return VaccineViewHolder(view)
    }

    override fun onBindViewHolder(holder: VaccineViewHolder, position: Int) {
        // bind the data to our items: set the todo text view text and checked state accordingly
        val currentVaccine = items[position]
        holder.itemView.apply {
            findViewById<TextView>(R.id.txtVaccineName).text = currentVaccine.name
        }

        holder.itemView.setOnClickListener {
            val action = VaccineListFragmentDirections.actionListFragmentToVaccineinfoFragment(currentVaccine)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int = items.size

    fun setData(vaccine: List<Vaccine>) {
        this.items = vaccine
        notifyDataSetChanged()
    }
}