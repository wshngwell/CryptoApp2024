package com.example.cryptoapp2024.data.network

import android.util.Log
import com.example.cryptoapp2024.data.network.DtoClasses.GetCoinsNameDto.TopCoinsByMarketCapJsonAnswerDto
import com.example.cryptoapp2024.data.network.DtoClasses.GetFullDataOfCoinsDto.CoinFullInfoDto
import com.example.cryptoapp2024.data.network.DtoClasses.GetFullDataOfCoinsDto.FullDataOfCoinsJsonAnswer
import com.google.gson.Gson

class Mapper {

    fun convertListOfNamesToString(names: List<String?>?): String {
        return names?.map {
            it.toString()
        }?.joinToString(",").toString()
    }

    fun loadCoinFullInfoDtoFromNamesOfCoins(jsonAnswer: FullDataOfCoinsJsonAnswer)
            : List<CoinFullInfoDto> {

        val listOfCoinFullInfoDto: MutableList<CoinFullInfoDto> = mutableListOf()
        val coinskeySet =
            jsonAnswer.jsonObject?.keySet() ?: throw RuntimeException("Unknown key set coins")

        for (coin in coinskeySet) {
            val coinObject = jsonAnswer.jsonObject.getAsJsonObject(coin)
            val keySetOfCurrency =
                coinObject?.keySet() ?: throw RuntimeException("Unknown key set currency")
            for (currency in keySetOfCurrency) {
                val result = Gson().fromJson(
                    coinObject.getAsJsonObject(currency),
                    CoinFullInfoDto::class.java
                )
                listOfCoinFullInfoDto.add(result)
            }
        }

        Log.d("MainActivity", listOfCoinFullInfoDto.toString())
        return listOfCoinFullInfoDto
    }
}