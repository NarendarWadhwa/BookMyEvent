package com.example.bookmyevent.network.model


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EventsPicks(
    var masterList: ArrayList<Featured> = ArrayList()
) : Parcelable