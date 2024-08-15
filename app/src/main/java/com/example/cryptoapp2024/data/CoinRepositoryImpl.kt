package com.example.cryptoapp2024.data

import android.app.Application
import android.util.Log
import android.view.animation.Transformation
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.example.cryptoapp2024.data.database.CryptoDao
import com.example.cryptoapp2024.data.network.Mapper
import com.example.cryptoapp2024.data.worker.RefreshDataWorker
import com.example.cryptoapp2024.domain.CoinFullInfo
import com.example.cryptoapp2024.domain.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val mapper: Mapper,
    private val application: Application,
    private val cryptoDao: CryptoDao,
) : CoinRepository {

    override fun getCoinFullInfoList(): LiveData<List<CoinFullInfo>> =
        MediatorLiveData<List<CoinFullInfo>>().apply {
            addSource(cryptoDao.getCoinsFullInfoList()) {
                value = it.map {
                  mapper.mapCoinFullInfoDbToCoinFullInfo(it)
                }

            }

        }

    override fun getOneCoinInfo(fsym: String): LiveData<CoinFullInfo> =
        MediatorLiveData<CoinFullInfo>().apply {
            addSource(cryptoDao.getOneCoinFullInfo(fsym)) {
                value = mapper.mapCoinFullInfoDbToCoinFullInfo(it)
            }
        }

    override fun loadData() {
        val workManager = WorkManager.getInstance(application)
        workManager.enqueueUniqueWork(
            RefreshDataWorker.REFRESH_DATA,
            ExistingWorkPolicy.REPLACE,
            RefreshDataWorker.getOneTimeWorkRequest()
        )

    }
}