package com.example.zadatak

import com.google.gson.annotations.SerializedName

data class VestiSource(
    @SerializedName("id")
    var id: String,
    @SerializedName("name")
    var name: String
)
