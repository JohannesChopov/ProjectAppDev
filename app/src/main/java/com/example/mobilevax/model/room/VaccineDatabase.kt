package com.example.mobilevax.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mobilevax.model.Vaccine

@TypeConverters(DateConverter::class)
@Database(entities = arrayOf(Vaccine::class), version = 1)
abstract class VaccineDatabase : RoomDatabase() {
    abstract fun vaccineDao() : VaccineDao
}