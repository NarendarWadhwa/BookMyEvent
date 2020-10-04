package com.example.bookmyevent.network

import com.example.bookmyevent.network.model.EventsResponse
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer

interface RemoteDataProvider {

    fun getEvents(
        success: Consumer<EventsResponse>,
        error: Consumer<Throwable>
    ): Disposable

}