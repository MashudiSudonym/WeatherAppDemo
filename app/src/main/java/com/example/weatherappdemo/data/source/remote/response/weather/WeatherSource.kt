package com.example.weatherappdemo.data.source.remote.response.weather

import com.example.weatherappdemo.domain.model.Weather
import com.google.gson.annotations.SerializedName

data class WeatherSource(
    @SerializedName("base")
    val base: String? = "",
    @SerializedName("clouds")
    val clouds: WeatherCloudsSource? = WeatherCloudsSource(),
    @SerializedName("cod")
    val cod: Int? = 0,
    @SerializedName("coord")
    val coord: WeatherCoordSource? = WeatherCoordSource(),
    @SerializedName("dt")
    val dt: Int? = 0,
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("main")
    val main: WeatherMainSource? = WeatherMainSource(),
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("sys")
    val sys: WeatherSysSource? = WeatherSysSource(),
    @SerializedName("timezone")
    val timezone: Int? = 0,
    @SerializedName("visibility")
    val visibility: Int? = 0,
    @SerializedName("weather")
    val weather: List<WeatherWeatherSource>? = listOf(),
    @SerializedName("wind")
    val wind: WeatherWindSource? = WeatherWindSource()
)

fun WeatherSource.toWeather(): Weather {
    return Weather(
        main = main?.temp
    )
}