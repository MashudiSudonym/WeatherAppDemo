package com.example.weatherappdemo.domain.model

import com.example.weatherappdemo.data.source.remote.response.cities.CitiesDataSource

data class Cities(
    val data: List<CitiesDataSource>
)
