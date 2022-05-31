package com.example.mobilevax.model.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.mobilevax.model.Vaccine

@Dao
interface VaccineDao {
    @Query("SELECT * FROM vaccine_table ORDER BY id ASC")
    fun query(): LiveData<List<Vaccine>>

    @Delete
    suspend fun deleteVaccine(vaccine: Vaccine)

    @Insert
    suspend fun addVaccine(vaccine: Vaccine)
    //suspend voor te kunnen pauzeren van een functie
}