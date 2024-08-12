package com.example.cryptoapp2024.di

import com.example.cryptoapp2024.data.CoinRepositoryImpl
import com.example.cryptoapp2024.domain.CoinRepository
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {
    @Binds
    fun bindCoinRepository(coinRepositoryImpl: CoinRepositoryImpl): CoinRepository
}