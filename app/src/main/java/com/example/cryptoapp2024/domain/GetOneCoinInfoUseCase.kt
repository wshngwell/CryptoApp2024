package com.example.cryptoapp2024.domain

import androidx.lifecycle.LiveData

class GetOneCoinInfoUseCase(private val repository: CoinRepository) {

    operator fun invoke(): LiveData<CoinFullInfo> {
        return repository.getOneCoinInfo()
    }
}