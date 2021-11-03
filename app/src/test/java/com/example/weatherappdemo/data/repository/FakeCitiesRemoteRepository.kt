package com.example.weatherappdemo.data.repository

import com.example.weatherappdemo.data.source.remote.response.cities.CitiesSource
import com.example.weatherappdemo.domain.repository.remote.CitiesRemoteRepository
import com.example.weatherappdemo.utils.generateFakeDummyRemoteCitiesResponse

class FakeCitiesRemoteRepository : CitiesRemoteRepository {
    private val citiesSourceResponse = generateFakeDummyRemoteCitiesResponse()

    override suspend fun getCities(id: String): CitiesSource {
        return citiesSourceResponse
    }
}