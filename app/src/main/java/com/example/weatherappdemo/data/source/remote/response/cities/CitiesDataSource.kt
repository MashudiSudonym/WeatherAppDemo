package com.example.weatherappdemo.data.source.remote.response.cities

import com.google.gson.annotations.SerializedName


data class CitiesDataSource(
    @SerializedName("city")
    val city: String? = null,
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("countryCode")
    val countryCode: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("latitude")
    val latitude: Double? = null,
    @SerializedName("longitude")
    val longitude: Double? = null,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("population")
    val population: Int? = null,
    @SerializedName("region")
    val region: String? = null,
    @SerializedName("regionCode")
    val regionCode: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("wikiDataId")
    val wikiDataId: String? = null
)
