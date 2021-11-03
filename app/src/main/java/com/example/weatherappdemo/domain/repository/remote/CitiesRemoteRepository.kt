package com.example.weatherappdemo.domain.repository.remote

import com.example.weatherappdemo.data.source.remote.response.cities.CitiesSource

interface CitiesRemoteRepository {
    suspend fun getCities(id: String): CitiesSource
}