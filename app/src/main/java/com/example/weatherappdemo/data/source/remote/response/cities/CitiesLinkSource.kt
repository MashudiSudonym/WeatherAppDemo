package com.example.weatherappdemo.data.source.remote.response.cities

import com.google.gson.annotations.SerializedName


data class CitiesLinkSource(
    @SerializedName("href")
    val href: String? = "",
    @SerializedName("rel")
    val rel: String? = ""
)
