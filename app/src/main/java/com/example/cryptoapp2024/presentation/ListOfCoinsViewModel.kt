package com.example.cryptoapp2024.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp2024.domain.GetCoinFullInfoListUseCase
import com.example.cryptoapp2024.domain.LoadDataUseCase
import kotlinx.coroutines.launch

class ListOfCoinsViewModel(
    private val getCoinFullInfoListUseCase: GetCoinFullInfoListUseCase,
    private val loadDataUseCase: LoadDataUseCase
) :
    ViewModel() {
        init {
            viewModelScope.launch {
                loadDataUseCase()
            }
        }

    fun getCoinFullInfoList(){
        viewModelScope.launch {
            getCoinFullInfoListUseCase()
        }
    }

}