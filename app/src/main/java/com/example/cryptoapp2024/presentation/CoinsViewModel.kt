package com.example.cryptoapp2024.presentation

import androidx.lifecycle.ViewModel
import com.example.cryptoapp2024.domain.GetCoinFullInfoListUseCase
import com.example.cryptoapp2024.domain.GetOneCoinInfoUseCase
import com.example.cryptoapp2024.domain.LoadDataUseCase
import javax.inject.Inject

class CoinsViewModel @Inject constructor(
    private val getCoinFullInfoListUseCase: GetCoinFullInfoListUseCase,
    private val getOneCoinInfoUseCase: GetOneCoinInfoUseCase,
    private val loadDataUseCase: LoadDataUseCase

) :
    ViewModel() {



    val listOfCoins = getCoinFullInfoListUseCase()

    fun getOneCoinInfo(fsym: String) = getOneCoinInfoUseCase(fsym)

    init {
        loadDataUseCase()
    }


}