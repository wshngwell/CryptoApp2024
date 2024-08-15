package com.example.cryptoapp2024.domain


data class CoinFullInfo(
    var FROMSYMBOL: String?,
    var TOSYMBOL: String?,
    var LASTMARKET: String? = null,
    var PRICE: String? = null,
    var LASTUPDATE: String? = null,
    var HIGHDAY: String? = null,
    var LOWDAY: String? = null,
    var IMAGEURL: String? = null
)