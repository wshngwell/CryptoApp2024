package com.example.cryptoapp2024.domain

class LoadDataUseCase(private val repository: CoinRepository) {

    operator fun invoke() {
        repository.loadData()
    }
}