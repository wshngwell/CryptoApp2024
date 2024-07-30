package com.example.cryptoapp2024.data.network.DtoClasses.GetCoinsNameDto

import com.google.gson.annotations.SerializedName

data class NameContainerDto(
    @SerializedName("Name")
    val nameOfCoin:String?
)
