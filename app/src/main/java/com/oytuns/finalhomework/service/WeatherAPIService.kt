package com.oytuns.finalhomework.service

import com.oytuns.finalhomework.model.Cities
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class WeatherAPIService {

    //BASE_URL : http://api.weatherapi.com/v1/
    //EXTENSION_URL : current.json?key=5c252b0bdd594f2288f200117211010&q=London&aqi=no

    private val BASE_URL = "http://api.weatherapi.com/v1/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(WeatherAPI::class.java)

    suspend fun getData() : ArrayList<Cities> {
        return api.getCities()
    }

}