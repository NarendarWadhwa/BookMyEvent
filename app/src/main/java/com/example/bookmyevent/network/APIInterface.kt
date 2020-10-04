package com.example.bookmyevent.network

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {

    @GET("home")
    fun getEvents(
        @Query("norm") norm: String,
        @Query("filterBy") filter: String,
        @Query("city") city: String
    ): Single<Response<ResponseBody>>

}