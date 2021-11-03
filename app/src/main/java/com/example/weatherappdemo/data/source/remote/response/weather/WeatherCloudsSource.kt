package com.example.weatherappdemo.data.source.remote.response.weather

import com.google.gson.annotations.SerializedName


data class WeatherCloudsSource(
    @SerializedName("all")
    val all: Int? = 0
)
