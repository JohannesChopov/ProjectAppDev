package com.example.mobilevax.model

import androidx.lifecycle.LiveData
import com.example.mobilevax.model.room.VaccineDao

class VaccineRepository(private val vaccineDao: VaccineDao) {
    val readAllData: LiveData<List<Vaccine>> = vaccineDao.query()
    //suspend voor te kunnen pauzeren en later te gebruiken.
    suspend fun addVaccine(vaccine: Vaccine) {
        vaccineDao.addVaccine(vaccine)
    }
}