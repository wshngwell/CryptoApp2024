package com.example.cryptoapp2024.data.network

import android.util.Log
import com.example.cryptoapp2024.data.database.DBmodel.CoinFullInfoDb
import com.example.cryptoapp2024.data.network.DtoClasses.GetCoinsNameDto.TopCoinsByMarketCapJsonAnswerDto
import com.example.cryptoapp2024.data.network.DtoClasses.GetFullDataOfCoinsDto.CoinFullInfoDto
import com.example.cryptoapp2024.data.network.DtoClasses.GetFullDataOfCoinsDto.FullDataOfCoinsJsonAnswer
import com.example.cryptoapp2024.domain.CoinFullInfo
import com.google.gson.Gson
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone
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

        return listOfCoinFullInfoDto
    }

    fun mapCoinFullInfoDtoToCoinFullInfoDb(coinFullInfoDto: CoinFullInfoDto): CoinFullInfoDb {

        return CoinFullInfoDb(
            FROMSYMBOL = coinFullInfoDto.fromsymbol,
            LASTMARKET = coinFullInfoDto.lastmarket,
            PRICE = coinFullInfoDto.price,
            LASTUPDATE = coinFullInfoDto.lastupdate,
            TOSYMBOL = coinFullInfoDto.tosymbol,
            HIGHDAY = coinFullInfoDto.highday,
            LOWDAY = coinFullInfoDto.lowday,
            IMAGEURL = BASE_IMAGE_URL + coinFullInfoDto.imageurl
        )
    }

    fun mapCoinFullInfoDbToCoinFullInfo(coinFullInfoDb: CoinFullInfoDb):CoinFullInfo{
        val coinInfo =  CoinFullInfo(
            FROMSYMBOL = coinFullInfoDb.FROMSYMBOL,
            LASTMARKET = coinFullInfoDb.LASTMARKET,
            PRICE = ("%.3f".format(coinFullInfoDb.PRICE)),
            LASTUPDATE = convertTimestampToTime(coinFullInfoDb.LASTUPDATE),
            TOSYMBOL = coinFullInfoDb.TOSYMBOL,
            HIGHDAY = ("%.3f".format(coinFullInfoDb.HIGHDAY)),
            LOWDAY = ("%.3f".format(coinFullInfoDb.LOWDAY)),
            IMAGEURL = coinFullInfoDb.IMAGEURL
        )

        return coinInfo
    }
    private fun convertTimestampToTime(timestamp: Long?): String {
        if (timestamp == null) return ""
        val stamp = Timestamp(timestamp * 1000)
        val date = Date(stamp.time)
        val pattern = "HH:mm:ss"
        val sdf = SimpleDateFormat(pattern, Locale.getDefault())
        sdf.timeZone = TimeZone.getDefault()
        return sdf.format(date)
    }

    companion object{
        const val BASE_IMAGE_URL = "https://cryptocompare.com"
    }
}