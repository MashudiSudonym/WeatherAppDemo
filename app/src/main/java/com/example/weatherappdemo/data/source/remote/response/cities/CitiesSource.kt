package com.example.weatherappdemo.data.source.remote.response.cities

import com.example.weatherappdemo.domain.model.Cities
import com.google.gson.annotations.SerializedName


data class CitiesSource(
    @SerializedName("data")
    val data: List<CitiesDataSource> = listOf(),
    @SerializedName("links")
    val links: List<CitiesLinkSource>? = listOf(),
    @SerializedName("metadata")
    val metadata: CitiesMetadataSource? = CitiesMetadataSource()
)

fun CitiesSource.toCities(): Cities {
    return Cities(
        data = data
    )
}

