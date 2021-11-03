package com.example.weatherappdemo.data.source.remote.response.weather

import com.google.gson.annotations.SerializedName


data class WeatherWindSource(
    @SerializedName("deg")
    val deg: Int? = 0,
    @SerializedName("gust")
    val gust: Double? = 0.0,
    @SerializedName("speed")
    val speed: Double? = 0.0
)
