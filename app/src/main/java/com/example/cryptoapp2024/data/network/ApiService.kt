package com.example.cryptoapp2024.data.network

import com.example.cryptoapp2024.data.network.DtoClasses.GetCoinsNameDto.TopCoinsByMarketCapJsonAnswerDto
import com.example.cryptoapp2024.data.network.DtoClasses.GetFullDataOfCoinsDto.FullDataOfCoinsJsonAnswer
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("data/top/mktcapfull?limit=15")
    suspend fun loadNamesOfTopCoins(
        @Query(API_KEY) apikey: String = "",
        @Query(CURRENCY) tsym: String = USD
    ): TopCoinsByMarketCapJsonAnswerDto

    @GET("data/pricemultifull")
    suspend fun loadFullDataOfTopCoins(
        @Query(API_KEY) apikey: String = "",
        @Query(CURRENCIES) tsym: String = USD,
        @Query(FSYMS) fsym: String,
    ): FullDataOfCoinsJsonAnswer

    companion object {
        private const val API_KEY = "api_key"
        private const val CURRENCY = "tsym"
        private const val CURRENCIES = "tsyms"
        private const val USD = "USD"
        private const val FSYMS = "fsyms"
    }
}