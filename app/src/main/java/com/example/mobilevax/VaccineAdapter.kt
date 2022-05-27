package com.example.mobilevax

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilevax.model.Vaccine

class VaccineAdapter(val items: List<Vaccine>) : RecyclerView.Adapter<VaccineAdapter.VaccineViewHolder>() {

    inner class VaccineViewHolder(currentItemView: View) : RecyclerView.ViewHolder(currentItemView)

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
            //findViewById<CheckBox>(R.id.chkTodoDone).isChecked = currentTodoItem.isDone
        }
    }

    override fun getItemCount(): Int = items.size
}