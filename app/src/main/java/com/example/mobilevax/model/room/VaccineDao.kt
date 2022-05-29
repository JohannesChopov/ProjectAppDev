package com.example.mobilevax.model.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mobilevax.model.Vaccine

@Dao
interface VaccineDao {
    @Query("SELECT * FROM vaccine_table ORDER BY id ASC")
    fun query(): LiveData<List<Vaccine>>

    @Update
    fun update(items: List<Vaccine>)

    @Delete
    suspend fun deleteVaccine(vaccine: Vaccine)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addVaccine(vaccine: Vaccine)
    //suspend voor te kunnen pauzeren van een functie
}