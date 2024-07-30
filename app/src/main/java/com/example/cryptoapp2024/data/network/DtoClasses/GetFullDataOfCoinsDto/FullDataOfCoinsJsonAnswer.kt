package com.example.cryptoapp2024.data.network.DtoClasses.GetFullDataOfCoinsDto

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class FullDataOfCoinsJsonAnswer(
    @SerializedName("RAW")
    val jsonObject: JsonObject?
)