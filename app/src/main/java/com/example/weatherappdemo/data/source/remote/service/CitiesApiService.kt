package com.example.weatherappdemo.data.source.remote.service

import com.example.weatherappdemo.common.Constants
import com.example.weatherappdemo.data.source.remote.response.cities.CitiesSource
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface CitiesApiService {
    @Headers(
        "x-rapidapi-host:${Constants.CITIES_HOST}",
        "x-rapidapi-key:${Constants.CITIES_KEY}"
    )
    @GET("/v1/geo/cities")
    suspend fun getCities(
        @Query("countryIds") id: String
    ): CitiesSource
}