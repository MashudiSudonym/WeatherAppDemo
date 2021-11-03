package com.example.weatherappdemo.presentation.cities_list

import com.example.weatherappdemo.data.source.remote.response.cities.CitiesDataSource

data class CitiesListState(
    val isLoading: Boolean = false,
    val cities: List<CitiesDataSource> = listOf(),
    val error: String = ""
)