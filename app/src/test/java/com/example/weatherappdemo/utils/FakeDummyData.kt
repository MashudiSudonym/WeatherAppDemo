package com.example.weatherappdemo.utils

import com.example.weatherappdemo.data.source.remote.response.cities.CitiesDataSource
import com.example.weatherappdemo.data.source.remote.response.cities.CitiesSource

fun generateFakeDummyRemoteCitiesResponse(): CitiesSource {
    val fakeCitiesSource = CitiesSource()
    val fakeDataCitiesSource: ArrayList<CitiesDataSource> = arrayListOf()

    CitiesSource(
        fakeDataCitiesSource.apply {
            add(
                CitiesDataSource(
                    "South Tangerang",
                    "Indonesia",
                    "ID",
                )
            )
        }
    )

    return fakeCitiesSource
}