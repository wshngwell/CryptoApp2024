package com.example.cryptoapp2024.data.network

import android.util.Log
import com.example.cryptoapp2024.data.database.DBmodel.CoinFullInfoDb
import com.example.cryptoapp2024.data.network.DtoClasses.GetCoinsNameDto.TopCoinsByMarketCapJsonAnswerDto
import com.example.cryptoapp2024.data.network.DtoClasses.GetFullDataOfCoinsDto.CoinFullInfoDto
import com.example.cryptoapp2024.data.network.DtoClasses.GetFullDataOfCoinsDto.FullDataOfCoinsJsonAnswer
import com.example.cryptoapp2024.domain.CoinFullInfo
import com.google.gson.Gson
import javax.inject.Inject

class Mapper @Inject constructor(){

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

    fun mapCoinFullInfoDtoToCoinFullInfoDb(coinFullInfoDto: CoinFullInfoDto): CoinFullInfoDb {
        return CoinFullInfoDb(
            FROMSYMBOL = coinFullInfoDto.fromsymbol,
            LASTMARKET = coinFullInfoDto.lastmarket,
            PRICE = coinFullInfoDto.price,
            LASTUPDATE = coinFullInfoDto.lastupdate.toInt(),
            TOSYMBOL = coinFullInfoDto.tosymbol,
            HIGHDAY = coinFullInfoDto.highday,
            LOWDAY = coinFullInfoDto.lowday,
            IMAGEURL = ApiFactory.BASE_URL + coinFullInfoDto.imageurl
        )
    }

    fun mapCoinFullInfoDbToCoinFullInfo(coinFullInfoDb: CoinFullInfoDb):CoinFullInfo{
        return CoinFullInfo(
            FROMSYMBOL = coinFullInfoDb.FROMSYMBOL,
            LASTMARKET = coinFullInfoDb.LASTMARKET,
            PRICE = coinFullInfoDb.PRICE,
            LASTUPDATE = coinFullInfoDb.LASTUPDATE,
            TOSYMBOL = coinFullInfoDb.TOSYMBOL,
            HIGHDAY = coinFullInfoDb.HIGHDAY,
            LOWDAY = coinFullInfoDb.LOWDAY,
            IMAGEURL = ApiFactory.BASE_URL + coinFullInfoDb.IMAGEURL
        )
    }
}