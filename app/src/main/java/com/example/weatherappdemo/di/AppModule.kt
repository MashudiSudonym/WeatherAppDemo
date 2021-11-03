package com.example.weatherappdemo.di

import com.example.weatherappdemo.common.Constants
import com.example.weatherappdemo.data.source.remote.repository.CitiesRemoteRepositoryImpl
import com.example.weatherappdemo.data.source.remote.repository.WeatherRemoteRepositoryImpl
import com.example.weatherappdemo.data.source.remote.service.CitiesApiService
import com.example.weatherappdemo.data.source.remote.service.WeatherApiService
import com.example.weatherappdemo.domain.repository.remote.CitiesRemoteRepository
import com.example.weatherappdemo.domain.repository.remote.WeatherRemoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // OkHttp Logging Interceptor
    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    // OkHttp Client
    @Provides
    @Singleton
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()

    // Retrofit for Weather API
    @Provides
    @Singleton
    fun provideWeatherApi(okHttpClient: OkHttpClient): WeatherApiService = Retrofit.Builder()
        .baseUrl(Constants.WEATHER_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
        .create(WeatherApiService::class.java)

    // Retrofit for Cities API
    @Provides
    @Singleton
    fun provideCitiesApi(okHttpClient: OkHttpClient): CitiesApiService = Retrofit.Builder()
        .baseUrl(Constants.CITIES_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
        .create(CitiesApiService::class.java)

    // cities remote source repository
    @Provides
    @Singleton
    fun provideCitiesRemoteRepository(
        citiesApiService: CitiesApiService
    ): CitiesRemoteRepository = CitiesRemoteRepositoryImpl(citiesApiService)

    // weather remote source repository
    @Provides
    @Singleton
    fun provideWeatherRemoteRepository(
        weatherApiService: WeatherApiService
    ): WeatherRemoteRepository = WeatherRemoteRepositoryImpl(weatherApiService)
}