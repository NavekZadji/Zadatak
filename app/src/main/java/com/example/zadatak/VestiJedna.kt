package com.example.zadatak

import com.google.gson.annotations.SerializedName

data class VestiJedna(
    @SerializedName("source")
    var source: VestiSource,
    @SerializedName("author")
    var author: String,
    @SerializedName("title")
    var title: String,
    @SerializedName("description")
    var description: String,
    @SerializedName("url")
    var url: String,
    @SerializedName("urlToImage")
    var urlToImage: String,
    @SerializedName("publishedAt")
    var publishedAT: String,
    @SerializedName("content")
    var content: String
)
