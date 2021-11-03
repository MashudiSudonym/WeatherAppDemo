package com.example.weatherappdemo.data.source.remote.repository

import com.example.weatherappdemo.data.source.remote.response.cities.CitiesSource
import com.example.weatherappdemo.data.source.remote.service.CitiesApiService
import com.example.weatherappdemo.domain.repository.remote.CitiesRemoteRepository
import javax.inject.Inject

class CitiesRemoteRepositoryImpl @Inject constructor(private val citiesApiService: CitiesApiService) :
    CitiesRemoteRepository {
    override suspend fun getCities(id: String): CitiesSource = citiesApiService.getCities(id)
}