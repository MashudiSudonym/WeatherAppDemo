package com.example.weatherappdemo.presentation.cities_list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherappdemo.common.Resource
import com.example.weatherappdemo.domain.use_case.get_cities.GetCitiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CitiesListViewModel @Inject constructor(private val getCitiesUseCase: GetCitiesUseCase) :
    ViewModel() {
    var uiState by mutableStateOf(CitiesListState())
        private set

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getCities()
        }
    }

    private suspend fun getCities() {
        getCitiesUseCase().collect { result ->
            uiState = when (result) {
                is Resource.Error -> CitiesListState(
                    error = result.message ?: "An unexpected error occurred"
                )
                is Resource.Loading -> CitiesListState(isLoading = true)
                is Resource.Success -> CitiesListState(cities = result.data?.data ?: emptyList())
            }
        }
    }
}