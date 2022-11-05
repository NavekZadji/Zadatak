package com.example.zadatak

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {
    suspend fun getNews(): Response<VestiNadskup> {
            return newsRepository.fetchNewsFromAPI()
    }
    suspend fun getNewsSve(): Response<VestiNadskup> {
        return newsRepository.fetchNewsSveFromAPI()
    }
}