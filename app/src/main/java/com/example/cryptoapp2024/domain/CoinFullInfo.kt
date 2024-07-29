package com.example.cryptoapp2024.domain


data class CoinFullInfo(
    var FROMSYMBOL: String?,
    var TOSYMBOL: String?,
    var LASTMARKET: String? = null,
    var PRICE: Double? = null,
    var LASTUPDATE: Int? = null,
    var HIGHDAY: Double? = null,
    var LOWDAY: Double? = null,
    var IMAGEURL: String? = null
)