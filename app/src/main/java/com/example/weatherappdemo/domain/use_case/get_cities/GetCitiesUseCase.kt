package com.example.weatherappdemo.domain.use_case.get_cities

import android.util.Log
import com.example.weatherappdemo.common.Constants
import com.example.weatherappdemo.common.Resource
import com.example.weatherappdemo.data.source.remote.response.cities.toCities
import com.example.weatherappdemo.domain.model.Cities
import com.example.weatherappdemo.domain.repository.remote.CitiesRemoteRepository
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import okhttp3.internal.toImmutableList
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCitiesUseCase @Inject constructor(private val citiesRemoteRepository: CitiesRemoteRepository) {
    suspend operator fun invoke(): StateFlow<Resource<Cities>> {
        val citiesResult: MutableStateFlow<Resource<Cities>> = MutableStateFlow(
            Resource.Success(
                Cities(
                    emptyList()
                )
            )
        )
        val getCities = citiesRemoteRepository.getCities(Constants.COUNTRY_ID).toCities()

        try {
            citiesResult.emit(Resource.Loading())
            citiesResult.emit(Resource.Success(getCities))
        } catch (e: HttpException) {
            citiesResult.emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            citiesResult.emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }


        return citiesResult
    }
}