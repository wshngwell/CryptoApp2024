package com.example.cryptoapp2024.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.example.cryptoapp2024.data.network.Mapper
import com.example.cryptoapp2024.data.worker.RefreshDataWorker
import com.example.cryptoapp2024.domain.CoinFullInfo
import com.example.cryptoapp2024.domain.CoinRepository

class CoinRepositoryImpl(
    private val mapper: Mapper,
    private val application: Application,
) : CoinRepository {

    override fun getCoinFullInfoList(): LiveData<List<CoinFullInfo>> {

    }

    override fun getOneCoinInfo(): LiveData<CoinFullInfo> {
        TODO("Not yet implemented")
    }

    override fun loadData() {
        val workManager = WorkManager.getInstance(application)

        workManager.enqueueUniqueWork(
            RefreshDataWorker.REFRESH_DATA,
            ExistingWorkPolicy.APPEND,
            RefreshDataWorker.getOneTimeWorkRequest()
        )

    }
}