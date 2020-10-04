package com.example.bookmyevent

import android.app.Application
import com.facebook.stetho.Stetho

class EventApp : Application() {

    companion object {
        lateinit var instance: EventApp
            private set
    }

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        instance = this
    }
}