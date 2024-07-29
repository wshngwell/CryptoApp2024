package com.example.cryptoapp2024.domain

import androidx.lifecycle.LiveData

class GetCoinFullInfoListUseCase(private val repository: CoinRepository) {

    operator fun invoke(): LiveData<List<CoinFullInfo>> {
        return repository.getCoinFullInfoList()
    }
}