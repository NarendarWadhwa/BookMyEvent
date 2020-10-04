package com.example.bookmyevent.network.model


import android.annotation.SuppressLint
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class Featured(
    @SerializedName("applicable_filters")
    val applicableFilters: ArrayList<String>,
    @SerializedName("category_id")
    val categoryId: CategoryId,
    @SerializedName("city")
    val city: String,
    @SerializedName("communication_strategy")
    val communicationStrategy: String,
    @SerializedName("event_state")
    val eventState: String,
    @SerializedName("group_id")
    val groupId: GroupId,
    @SerializedName("horizontal_cover_image")
    val horizontalCoverImage: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("is_rsvp")
    val isRsvp: Boolean,
    @SerializedName("min_price")
    val minPrice: Int,
    @SerializedName("min_show_start_time")
    val minShowStartTime: Int,
    @SerializedName("model")
    val model: String,
    @SerializedName("popularity_score")
    val popularityScore: Double,
    @SerializedName("price_display_string")
    val priceDisplayString: String,
    @SerializedName("purchase_visibility")
    val purchaseVisibility: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("venue_date_string")
    val venueDateString: String,
    @SerializedName("venue_id")
    val venueId: String,
    @SerializedName("venue_name")
    val venueName: String,
    @SerializedName("vertical_cover_image")
    val verticalCoverImage: String,
    @SerializedName("name")
    val name: String
) : Parcelable