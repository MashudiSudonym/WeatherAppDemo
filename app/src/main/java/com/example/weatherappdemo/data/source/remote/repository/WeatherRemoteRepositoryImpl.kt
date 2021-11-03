package com.example.weatherappdemo.data.source.remote.repository

import com.example.weatherappdemo.data.source.remote.response.weather.WeatherSource
import com.example.weatherappdemo.data.source.remote.service.WeatherApiService
import com.example.weatherappdemo.domain.repository.remote.WeatherRemoteRepository
import javax.inject.Inject

class WeatherRemoteRepositoryImpl @Inject constructor(private val weatherApiService: WeatherApiService) :
    WeatherRemoteRepository {
    override suspend fun getWeatherByCityName(
        cityName: String,
        key: String,
        units: String
    ): WeatherSource = weatherApiService.getWeatherByCityName(
        cityName,
        key,
        units
    )
}