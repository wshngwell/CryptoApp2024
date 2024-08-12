package com.example.cryptoapp2024.data.database.DBmodel

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "coin_full_info")
data class CoinFullInfoDb(
    @PrimaryKey
    var FROMSYMBOL: String,
    var TOSYMBOL: String,
    var LASTMARKET: String,
    var PRICE: Double,
    var LASTUPDATE: Int,
    var HIGHDAY: Double,
    var LOWDAY: Double,
    var IMAGEURL: String
)
