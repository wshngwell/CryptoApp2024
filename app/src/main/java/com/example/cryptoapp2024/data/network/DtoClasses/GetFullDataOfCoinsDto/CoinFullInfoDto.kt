package com.example.cryptoapp2024.data.network.DtoClasses.GetFullDataOfCoinsDto


import com.google.gson.annotations.SerializedName

data class CoinFullInfoDto(
    @SerializedName("TYPE")
    val type: String,
    @SerializedName("MARKET")
    val market: String,
    @SerializedName("FROMSYMBOL")
    val fromsymbol: String,
    @SerializedName("TOSYMBOL")
    val tosymbol: String,
    @SerializedName("FLAGS")
    val flags: String,
    @SerializedName("LASTMARKET")
    val lastmarket: String,
    @SerializedName("MEDIAN")
    val median: Double,
    @SerializedName("TOPTIERVOLUME24HOUR")
    val toptiervolume24Hour: Double,
    @SerializedName("TOPTIERVOLUME24HOURTO")
    val toptiervolume24Hourto: Double,
    @SerializedName("LASTTRADEID")
    val lasttradeid: String,
    @SerializedName("PRICE")
    val price: Double,
    @SerializedName("LASTUPDATE")
    val lastupdate: Long,
    @SerializedName("LASTVOLUME")
    val lastvolume: Double,
    @SerializedName("LASTVOLUMETO")
    val lastvolumeto: Double,
    @SerializedName("VOLUMEHOUR")
    val volumehour: Double,
    @SerializedName("VOLUMEHOURTO")
    val volumehourto: Double,
    @SerializedName("OPENHOUR")
    val openhour: Double,
    @SerializedName("HIGHHOUR")
    val highhour: Double,
    @SerializedName("LOWHOUR")
    val lowhour: Double,
    @SerializedName("VOLUMEDAY")
    val volumeday: Double,
    @SerializedName("VOLUMEDAYTO")
    val volumedayto: Double,
    @SerializedName("OPENDAY")
    val openday: Double,
    @SerializedName("HIGHDAY")
    val highday: Double,
    @SerializedName("LOWDAY")
    val lowday: Double,
    @SerializedName("VOLUME24HOUR")
    val volume24Hour: Double,
    @SerializedName("VOLUME24HOURTO")
    val volume24Hourto: Double,
    @SerializedName("OPEN24HOUR")
    val open24Hour: Double,
    @SerializedName("HIGH24HOUR")
    val high24Hour: Double,
    @SerializedName("LOW24HOUR")
    val low24Hour: Double,
    @SerializedName("CHANGE24HOUR")
    val change24Hour: Double,
    @SerializedName("CHANGEPCT24HOUR")
    val changepct24Hour: Double,
    @SerializedName("CHANGEDAY")
    val changeday: Double,
    @SerializedName("CHANGEPCTDAY")
    val changepctday: Double,
    @SerializedName("CHANGEHOUR")
    val changehour: Double,
    @SerializedName("CHANGEPCTHOUR")
    val changepcthour: Double,
    @SerializedName("CONVERSIONTYPE")
    val conversiontype: String,
    @SerializedName("CONVERSIONSYMBOL")
    val conversionsymbol: String,
    @SerializedName("CONVERSIONLASTUPDATE")
    val conversionlastupdate: Long,
    @SerializedName("SUPPLY")
    val supply: Long,
    @SerializedName("MKTCAP")
    val mktcap: Double,
    @SerializedName("MKTCAPPENALTY")
    val mktcappenalty: Long,
    @SerializedName("CIRCULATINGSUPPLY")
    val circulatingsupply: Long,
    @SerializedName("CIRCULATINGSUPPLYMKTCAP")
    val circulatingsupplymktcap: Double,
    @SerializedName("TOTALVOLUME24H")
    val totalvolume24H: Double,
    @SerializedName("TOTALVOLUME24HTO")
    val totalvolume24Hto: Double,
    @SerializedName("TOTALTOPTIERVOLUME24H")
    val totaltoptiervolume24H: Double,
    @SerializedName("TOTALTOPTIERVOLUME24HTO")
    val totaltoptiervolume24Hto: Double,
    @SerializedName("IMAGEURL")
    val imageurl: String,
)
