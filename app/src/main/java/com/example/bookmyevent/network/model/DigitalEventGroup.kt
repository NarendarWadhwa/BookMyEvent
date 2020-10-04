package com.example.bookmyevent.network.model


import android.annotation.SuppressLint
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
data class DigitalEventGroup(
    @SerializedName("tag_id")
    val tagId: String,
    @SerializedName("thumbnail_url")
    val thumbnailUrl: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
) : Parcelable