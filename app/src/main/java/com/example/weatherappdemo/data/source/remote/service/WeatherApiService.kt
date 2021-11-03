package com.example.weatherappdemo.data.source.remote.service

import com.example.weatherappdemo.data.source.remote.response.weather.WeatherSource
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("weather")
    suspend fun getWeatherByCityName(
        @Query("q") cityName: String,
        @Query("appid") key: String,
        @Query("units") units: String,
    ): WeatherSource
}