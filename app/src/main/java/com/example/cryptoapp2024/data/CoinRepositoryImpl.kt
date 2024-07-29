package com.example.cryptoapp2024.data

import androidx.lifecycle.LiveData
import com.example.cryptoapp2024.domain.CoinFullInfo
import com.example.cryptoapp2024.domain.CoinRepository

class CoinRepositoryImpl:CoinRepository {
    override fun getCoinFullInfoList(): LiveData<List<CoinFullInfo>> {
        TODO("Not yet implemented")
    }

    override fun getOneCoinInfo(): LiveData<CoinFullInfo> {
        TODO("Not yet implemented")
    }

    override fun loadData() {
        TODO("Not yet implemented")
    }
}