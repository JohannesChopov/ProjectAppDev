package com.example.mobilevax.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "vaccine_table")
data class Vaccine(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "vaccine_name")
    val name:String,
    @ColumnInfo(name = "date_injected")
    val date: Date
    ): Parcelable
