package com.example.bookmyevent.network

import com.example.bookmyevent.network.model.EventsList
import com.example.bookmyevent.network.model.EventsResponse
import com.example.bookmyevent.network.model.Featured
import com.example.bookmyevent.utils.isNetworkAvailable
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import org.json.JSONObject
import java.lang.reflect.Type

object DataProvider : RemoteDataProvider {

    private val mServices: APIInterface by lazy {
        APIClient.getClient().create(APIInterface::class.java)
    }

    private fun noInternetAvailable(error: Consumer<Throwable>) =
        error.accept(Throwable("No Internet Connection"))

    private fun getDefaultDisposable(): Disposable = object : Disposable {
        override fun isDisposed() = false
        override fun dispose() {}
    }

    override fun getEvents(
        success: Consumer<EventsResponse>,
        error: Consumer<Throwable>
    ): Disposable = if (isNetworkAvailable()) {
        mServices.getEvents("1", "go-out", "mumbai")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(Consumer {
                val result = JSONObject(it.body()!!.string())
                val eventDemoResponseModel =
                    Gson().fromJson(result.toString(), EventsResponse::class.java)
                val listMasterListJson =
                    result.getJSONObject("list").getJSONObject("masterList").toString()
                val type: Type = object : TypeToken<Map<String?, Featured>?>() {}.type
                val listMasterListMap: Map<String, Featured> =
                    Gson().fromJson(listMasterListJson, type)
                val listMasterList: ArrayList<Featured> = ArrayList(listMasterListMap.values)
                eventDemoResponseModel.lists = EventsList()
                eventDemoResponseModel.lists!!.masterList = listMasterList
                success.accept(eventDemoResponseModel)
            }, error)

    } else {
        noInternetAvailable(error)
        getDefaultDisposable()
    }

}