package com.example.zadatak

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPIService {
    @GET("/v2/top-headlines")
    suspend fun fetchNews(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String
    ): Response<VestiNadskup>
    @GET("/v2/everything")
    suspend fun fetchNewsSve(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String
    ): Response<VestiNadskup>
}