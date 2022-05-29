package com.example.mobilevax.model.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.mobilevax.model.Vaccine
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VaccineViewModel(application: Application): AndroidViewModel(application) {
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
}