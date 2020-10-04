package com.example.bookmyevent.utils

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.bookmyevent.EventApp
import com.example.bookmyevent.R


fun AppCompatActivity.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.showToast(message: String) {
    Toast.makeText(this.activity, message, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.hideKeyboard() {
    val view = this.currentFocus
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    view?.let {
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

@BindingAdapter("visibleGone")
fun View.showHide(show: Boolean) {
    this.visibility = if (show) View.VISIBLE else View.GONE
}

@BindingAdapter("loadUrl")
fun AppCompatImageView.loadUrl(imageUrl: String) {
    if (imageUrl.isNotEmpty()) {
        Glide.with(this.context)
            .load(imageUrl)
            .into(this)
    }
}

@BindingAdapter("showPrice")
fun AppCompatTextView.showAmountWithRupeeSymbol(price: Int) {
    this.text = StringBuilder(this.resources.getString(R.string.rupee)).append(price.toString())
}

fun isNetworkAvailable(): Boolean {
    val cm =
        EventApp.instance.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        cm.activeNetwork != null
    } else {
        val activeNetwork = cm.activeNetworkInfo ?: return false
        return activeNetwork.isConnected
    }
}

