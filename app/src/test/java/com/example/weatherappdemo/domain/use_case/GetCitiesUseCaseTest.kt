package com.example.weatherappdemo.domain.use_case

import com.example.weatherappdemo.data.repository.FakeCitiesRemoteRepository
import com.example.weatherappdemo.domain.use_case.get_cities.GetCitiesUseCase
import com.example.weatherappdemo.utils.generateFakeDummyRemoteCitiesResponse
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetCitiesUseCaseTest {
    private lateinit var getCitiesUseCase: GetCitiesUseCase
    private lateinit var fakeCitiesRemoteRepository: FakeCitiesRemoteRepository
    private val citiesSourceResponse = generateFakeDummyRemoteCitiesResponse()

    @Before
    fun setUp() {
        fakeCitiesRemoteRepository = FakeCitiesRemoteRepository()
        getCitiesUseCase = GetCitiesUseCase(fakeCitiesRemoteRepository)
    }

    @Test
    fun `check data not null`() = runBlocking {
        val citiesData = fakeCitiesRemoteRepository.getCities("ID")
        Assert.assertNotNull(citiesData)
    }
}