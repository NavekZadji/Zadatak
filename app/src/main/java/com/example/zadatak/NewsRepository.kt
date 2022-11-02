package com.example.zadatak

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

class NewsRepository() {
    private val retrofit: NewsAPIService = Retrofit.Builder().baseUrl("https://newsapi.org/")
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()
        .create(NewsAPIService::class.java)

    suspend fun fetchNewsFromAPI(): Response<String> {
        return retrofit.fetchNews(country = "US", category = "business", apiKey = "9965ce12862f40b8ab5d125fb4d4488e")
    }

}