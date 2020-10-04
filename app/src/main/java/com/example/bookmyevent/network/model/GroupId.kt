package com.example.bookmyevent.network.model


import android.annotation.SuppressLint
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class GroupId(
    @SerializedName("_id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String
) : Parcelable