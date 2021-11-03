package com.example.weatherappdemo.data.source.remote.response.weather

import com.google.gson.annotations.SerializedName


data class WeatherCoordSource(
    @SerializedName("lat")
    val lat: Double? = 0.0,
    @SerializedName("lon")
    val lon: Double? = 0.0
)
