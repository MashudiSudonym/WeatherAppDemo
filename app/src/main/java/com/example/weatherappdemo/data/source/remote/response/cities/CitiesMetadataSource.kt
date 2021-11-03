package com.example.weatherappdemo.data.source.remote.response.cities

import com.google.gson.annotations.SerializedName


data class CitiesMetadataSource(
    @SerializedName("currentOffset")
    val currentOffset: Int? = 0,
    @SerializedName("totalCount")
    val totalCount: Int? = 0
)
