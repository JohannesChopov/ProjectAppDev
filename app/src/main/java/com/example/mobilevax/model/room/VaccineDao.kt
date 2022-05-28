package com.example.mobilevax.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

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