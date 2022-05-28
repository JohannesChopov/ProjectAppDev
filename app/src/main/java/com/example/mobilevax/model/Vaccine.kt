package com.example.mobilevax.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.util.*

@Entity
data class Vaccine(
    @ColumnInfo(name = "vaccine_name") val name:String,
    @ColumnInfo(name = "date_injected") var date: Date,
    @PrimaryKey(autoGenerate = true) var id: Int = 0)