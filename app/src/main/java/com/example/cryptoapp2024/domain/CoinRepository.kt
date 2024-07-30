package com.example.cryptoapp2024.domain

import androidx.lifecycle.LiveData


interface CoinRepository {
    fun getCoinFullInfoList(): LiveData<List<CoinFullInfo>>
    fun getOneCoinInfo(fsym:String): LiveData<CoinFullInfo>
    fun loadData()
}