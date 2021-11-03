package com.example.weatherappdemo.data.source.remote.response.weather

import com.google.gson.annotations.SerializedName


data class WeatherWeatherSource(
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("icon")
    val icon: String? = "",
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("main")
    val main: String? = ""
)
