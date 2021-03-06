package com.example.mobilevax.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.mobilevax.model.Vaccine
import com.example.mobilevax.model.room.VaccineDatabase
import com.example.mobilevax.model.room.VaccineRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VaccineViewModel(application: Application): AndroidViewModel(application) {
    //klasse houdt data bij die bij de view hoort
    internal val readAllData: LiveData<List<Vaccine>>
    private val repository: VaccineRepository

    init {
        val vaccineDao = VaccineDatabase.getDatabase(application).vaccineDao()
        repository = VaccineRepository(vaccineDao)
        readAllData = repository.readAllData
    }

    fun addVaccine(vaccine: Vaccine) { //using coroutine to run in backgroundthread instead of mainthread
        viewModelScope.launch(Dispatchers.IO) {
            repository.addVaccine(vaccine)
        }
    }

    fun deleteVaccine(vaccine: Vaccine) {
        viewModelScope.launch(Dispatchers.IO) {//running query from background thread
            repository.deleteVaccine(vaccine)
        }
    }
}