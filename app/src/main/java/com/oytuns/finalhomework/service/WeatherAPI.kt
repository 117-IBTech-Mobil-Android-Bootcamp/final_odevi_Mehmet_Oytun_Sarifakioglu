package com.oytuns.finalhomework.service

import com.oytuns.finalhomework.model.Cities
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    //BASE_URL : http://api.weatherapi.com/v1/
    //EXTENSION_URL : /search.json?key=5c252b0bdd594f2288f200117211010&q=London

    @GET("search.json")
    suspend fun getCities( @Query("key") key : String) : ArrayList<Cities>

   /* companion object{
        var BASE_URL = "http://api.weatherapi.com/v1/"

        fun getLocations() : List<Cities> {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(WeatherAPI::class.java)
        }
    }*/
}