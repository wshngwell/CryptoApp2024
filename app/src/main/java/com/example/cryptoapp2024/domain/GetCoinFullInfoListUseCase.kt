package com.example.cryptoapp2024.domain

import android.util.Log
import androidx.lifecycle.LiveData
import javax.inject.Inject

class GetCoinFullInfoListUseCase @Inject constructor(private val repository: CoinRepository) {

    operator fun invoke(): LiveData<List<CoinFullInfo>> {

        return repository.getCoinFullInfoList()
    }
}