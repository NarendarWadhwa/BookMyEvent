package com.example.bookmyevent.network.model


import android.annotation.SuppressLint
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
data class Dates(
    @SerializedName("next_weekend")
    val nextWeekend: String,
    @SerializedName("next_weekend_date_string")
    val nextWeekendDateString: String,
    @SerializedName("today")
    val today: String,
    @SerializedName("today_date_string")
    val todayDateString: String,
    @SerializedName("tomorrow")
    val tomorrow: String,
    @SerializedName("tomorrow_date_string")
    val tomorrowDateString: String,
    @SerializedName("weekend")
    val weekend: String,
    @SerializedName("weekend_date_string")
    val weekendDateString: String
) : Parcelable