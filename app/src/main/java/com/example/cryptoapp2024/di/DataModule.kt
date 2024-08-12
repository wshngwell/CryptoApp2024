package com.example.cryptoapp2024.di

import android.app.Application
import com.example.cryptoapp2024.data.database.CryptoDao
import com.example.cryptoapp2024.data.database.CryptoDataBase
import dagger.Module
import dagger.Provides
@Module
interface DataModule {

    companion object {
        @Provides
        fun providesDao(application: Application): CryptoDao {
            return CryptoDataBase.createCryptoDataBase(application).getCryptoDao()
        }
    }
}