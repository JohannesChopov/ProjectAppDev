package com.example.mobilevax.model.room

import android.content.Context
import androidx.room.Room
import com.example.mobilevax.model.Vaccine
import com.example.mobilevax.model.VaccineRepository
import java.security.AccessControlContext

class VaccineRoomRepository(appContext: Context) : VaccineRepository {
    private val db: VaccineDatabase
    private val dao: VaccineDao

    init {
        db = Room.databaseBuilder(appContext, VaccineDatabase::class.java, "vaccine-db")
            .allowMainThreadQueries()
            .build()
        dao = db.vaccineDao()
    }

    override fun load(): List<Vaccine> = dao.query()

    override fun save(items: List<Vaccine>) {
        // You'll learn more about transactions in the database course in the 3rd academic year.
        db.runInTransaction {
            dao.deleteAll()
            dao.insert(items)
        }
    }
}