package com.example.zadatak

import com.google.gson.annotations.SerializedName


data class VestiNadskup(
    @SerializedName("status")
    var status: String,
    @SerializedName("totalResults")
    var totalResults: Int,
    @SerializedName("articles")
    var articles: Array<VestiJedna>
)
