package com.example.mobilevax.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.versionedparcelable.VersionedParcelize
import java.time.LocalDate
import java.util.*

@Entity(tableName = "vaccine_table")
data class Vaccine(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "vaccine_name")
    val name:String,
    @ColumnInfo(name = "date_injected")
    val date: Date
    ): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        TODO("date")
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Vaccine> {
        override fun createFromParcel(parcel: Parcel): Vaccine {
            return Vaccine(parcel)
        }

        override fun newArray(size: Int): Array<Vaccine?> {
            return arrayOfNulls(size)
        }
    }
}
