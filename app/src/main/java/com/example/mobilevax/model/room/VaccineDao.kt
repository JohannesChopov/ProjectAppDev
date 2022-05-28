package com.example.mobilevax.model.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mobilevax.model.Vaccine

@Dao
interface VaccineDao {
    @Query("SELECT * FROM Vaccine")
    fun query(): List<Vaccine>

    @Update
    fun update(items: List<Vaccine>)

    @Query("DELETE FROM Vaccine")
    fun deleteAll()

    @Insert
    fun insert(items: List<Vaccine>)
}