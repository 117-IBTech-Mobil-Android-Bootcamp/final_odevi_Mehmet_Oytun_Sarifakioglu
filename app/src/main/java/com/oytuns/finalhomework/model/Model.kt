package com.oytuns.finalhomework.model

import com.google.gson.annotations.SerializedName
import java.sql.Timestamp

data class Cities(
    @SerializedName("id")
    val id : Int,
    @SerializedName("name")
    val name : String,
    @SerializedName("region")
    val region : String,
    @SerializedName("country")
    val country : String,
    @SerializedName("lat")
    val latitude : Double,
    @SerializedName("lon")
    val longtitude : Double,
    @SerializedName("url")
    val url : String
    //URL EKLEMEK GEREKEBİLİR !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    /*val localTime : Timestamp,
    val situation : String,
    val tempC : Double,
    val tempF : Double,
    val imageUrl : String,
    val feelC : Double,
    val feelF : Double*/
)