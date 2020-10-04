package com.example.bookmyevent.network.model


import android.annotation.SuppressLint
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
data class Banner(
    @SerializedName("category_id")
    val categoryId: CategoryId,
    @SerializedName("description")
    val description: String,
    @SerializedName("group_id")
    val groupId: GroupId,
    @SerializedName("_id")
    val id: String,
    @SerializedName("is_internal")
    val isInternal: Boolean,
    @SerializedName("map_link")
    val mapLink: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("priority")
    val priority: Int,
    @SerializedName("type")
    val type: String,
    @SerializedName("vertical_cover_image")
    val verticalCoverImage: String
) : Parcelable