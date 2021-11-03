package com.example.weatherappdemo.domain.repository.remote

import com.example.weatherappdemo.data.source.remote.response.weather.WeatherSource

interface WeatherRemoteRepository {
    suspend fun getWeatherByCityName(
        cityName: String,
        key: String,
        units: String
    ): WeatherSource
}