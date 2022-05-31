package com.example.mobilevax.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mobilevax.model.Vaccine

@Database(entities = [Vaccine::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class VaccineDatabase : RoomDatabase() {
    abstract fun vaccineDao() : VaccineDao
    companion object {
        @Volatile
        private var INSTANCE: VaccineDatabase? = null

        fun getDatabase(context: Context): VaccineDatabase {
            val tempInstance = INSTANCE
            //gebruik van singleton. als er geen is, maak er een. Als er al een is, gebruik die
            if(tempInstance != null) {
                return  tempInstance
            }
            synchronized(this) {
                    val instance = Room.databaseBuilder(context.applicationContext, VaccineDatabase::class.java, "vaccine_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}