package com.example.bookmyevent.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel : ViewModel() {

    private val mDisposable = CompositeDisposable()
    protected val dialogMessage: MutableLiveData<String> = MutableLiveData("")
    protected val dialogVisibility: MutableLiveData<Boolean> = MutableLiveData(false)


    fun getMessage() = dialogMessage
    fun getVisibility() = dialogVisibility
    fun getDisposable() = mDisposable

    override fun onCleared() {
        super.onCleared()
        if (!mDisposable.isDisposed) {
            mDisposable.dispose()
        }
    }

}