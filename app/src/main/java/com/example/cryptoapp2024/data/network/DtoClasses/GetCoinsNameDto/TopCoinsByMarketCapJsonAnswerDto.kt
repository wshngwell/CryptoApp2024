package com.example.cryptoapp2024.data.network.DtoClasses.GetCoinsNameDto

import com.google.gson.annotations.SerializedName


data class TopCoinsByMarketCapJsonAnswerDto (
    @SerializedName("Data")
    val listOfTopCoinInfoDto: List<TopCoinInfoDto>?
)