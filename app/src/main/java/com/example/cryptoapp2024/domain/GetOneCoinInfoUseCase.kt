package com.example.cryptoapp2024.domain

import androidx.lifecycle.LiveData
import javax.inject.Inject

class GetOneCoinInfoUseCase @Inject constructor(private val repository: CoinRepository) {

    operator fun invoke(fsym:String): LiveData<CoinFullInfo> {
        return repository.getOneCoinInfo(fsym)
    }
}