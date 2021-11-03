package com.example.weatherappdemo.domain.use_case.get_weather_by_cities_name

import com.example.weatherappdemo.common.Constants
import com.example.weatherappdemo.common.Resource
import com.example.weatherappdemo.data.source.remote.response.weather.toWeather
import com.example.weatherappdemo.domain.model.Weather
import com.example.weatherappdemo.domain.repository.remote.WeatherRemoteRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetWeatherByCitiesName @Inject constructor(private val weatherRemoteRepository: WeatherRemoteRepository) {
    suspend operator fun invoke(cityName: String): SharedFlow<Resource<Weather>> {
        val weatherResult : MutableSharedFlow<Resource<Weather>> = MutableSharedFlow()
        val getWeather = weatherRemoteRepository.getWeatherByCityName(
                cityName,
                key = Constants.WEATHER_KEY,
                units = Constants.UNIT_METRIC
            ).toWeather()

        try {
            weatherResult.emit(Resource.Loading())
            weatherResult.emit(Resource.Success(getWeather))
        } catch (e: HttpException) {
            weatherResult.emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            weatherResult.emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }

        return weatherResult
    }
//    operator fun invoke(cityName: String): Flow<Resource<Weather>> = flow {
//        try {
//            emit(Resource.Loading())
//            val cities = weatherRemoteRepository.getWeatherByCityName(
//                cityName,
//                key = Constants.WEATHER_KEY,
//                units = Constants.UNIT_METRIC
//            ).toWeather()
//            emit(Resource.Success(cities))
//        } catch (e: HttpException) {
//            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
//        } catch (e: IOException) {
//            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
//        }
//    }
}