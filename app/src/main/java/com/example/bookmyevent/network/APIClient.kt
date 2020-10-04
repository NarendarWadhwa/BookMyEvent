package com.example.bookmyevent.network

import com.example.bookmyevent.BuildConfig
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {

    companion object {

        fun getClient(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .build()
        }

        private fun getOkHttpClient(): OkHttpClient {
            val loggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            return OkHttpClient.Builder()
                .addInterceptor(HeaderInterceptor())
                .addNetworkInterceptor(loggingInterceptor)
                .addNetworkInterceptor(StethoInterceptor())
                .build()
        }


        class HeaderInterceptor : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val request = chain.request()

                val reqBuilder = request.newBuilder().apply {
                    addHeader("Content-Type", "application/json;charset=utf-8")
                    addHeader("Accept", "application/json")
                }

                return chain.proceed(reqBuilder.build())
            }
        }
    }


}