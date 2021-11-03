package com.example.weatherappdemo.data.source.remote.response.weather

import com.google.gson.annotations.SerializedName


data class WeatherSysSource(
    @SerializedName("country")
    val country: String? = "",
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("sunrise")
    val sunrise: Int? = 0,
    @SerializedName("sunset")
    val sunset: Int? = 0,
    @SerializedName("type")
    val type: Int? = 0
)
