package com.example.cryptoapp2024.data.database.DBmodel

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity("coin_full_info")
data class CoinFullInfoDb(
    @PrimaryKey(autoGenerate = true)
    var FROMSYMBOL: String?,
    var TOSYMBOL: String?,
    var LASTMARKET: String? = null,
    var PRICE: Double? = null,
    var LASTUPDATE: Int? = null,
    var HIGHDAY: Double? = null,
    var LOWDAY: Double? = null,
    var IMAGEURL: String? = null
)
