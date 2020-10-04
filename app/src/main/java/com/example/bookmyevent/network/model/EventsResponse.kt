package com.example.bookmyevent.network.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "events_tbl")
data class EventsResponse(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @SerializedName("groups")
    val groups: ArrayList<String>,
    var lists: EventsList? = EventsList()
) : Parcelable