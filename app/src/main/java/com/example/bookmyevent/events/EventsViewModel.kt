package com.example.bookmyevent.events

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bookmyevent.base.BaseViewModel
import com.example.bookmyevent.network.DataProvider
import com.example.bookmyevent.network.model.EventsResponse
import io.reactivex.functions.Consumer

class EventsViewModel : BaseViewModel() {

    private val eventsLiveData = MutableLiveData<EventsResponse>()
    val errorLiveData = MutableLiveData<String>()

    fun getEventsData(): LiveData<EventsResponse> = eventsLiveData

    fun getEvents() {
        dialogMessage.value = "Fetching Events..."
        dialogVisibility.value = true
        getDisposable().add(DataProvider.getEvents(Consumer {
            dialogVisibility.value = false
            eventsLiveData.value = it
        }, Consumer {
            dialogVisibility.value = false
            errorLiveData.value = it.message
        }))
    }

}