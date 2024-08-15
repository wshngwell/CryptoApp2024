package com.example.cryptoapp2024.di

import android.app.Application
import com.example.cryptoapp2024.data.database.CryptoDao
import com.example.cryptoapp2024.data.database.CryptoDataBase
import com.example.cryptoapp2024.data.network.ApiFactory
import com.example.cryptoapp2024.data.network.ApiService
import com.example.cryptoapp2024.data.worker.ChildWorkerFactory
import com.example.cryptoapp2024.data.worker.RefreshDataWorker
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
interface DataModule {

    @Binds
    @IntoMap
    @WorkerKey(RefreshDataWorker::class)
    fun bindsRefreshDataWorker(refreshDataWorker: RefreshDataWorker.Factory): ChildWorkerFactory

    companion object {
        @Provides
        fun providesDao(application: Application): CryptoDao {
            return CryptoDataBase.createCryptoDataBase(application).getCryptoDao()
        }

        @Provides
        fun providesApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}