package com.oytuns.finalhomework.repository

import android.location.Location
import com.oytuns.finalhomework.model.Cities
import com.oytuns.finalhomework.resource.Resource
import com.oytuns.finalhomework.service.WeatherAPI

class LocationRepository(val api : WeatherAPI) {

    suspend fun getLocationList() : Resource<ArrayList<Cities>> {

        val response = try {
            api.getCities("5c252b0bdd594f2288f200117211010")
        } catch (e: Exception) {
            return Resource.Error("Error!!")
        }
        return Resource.Success(response)
    }
}