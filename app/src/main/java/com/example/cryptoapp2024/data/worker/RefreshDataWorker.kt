package com.example.cryptoapp2024.data.worker

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.ListenableWorker
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkerParameters
import com.example.cryptoapp2024.data.database.CryptoDao
import com.example.cryptoapp2024.data.network.ApiService
import com.example.cryptoapp2024.data.network.Mapper
import kotlinx.coroutines.delay
import javax.inject.Inject

class RefreshDataWorker(
    private val apiService: ApiService,
    private val cryptoDao: CryptoDao,
    private val mapper: Mapper,
    private val context: Context,
    private val parameters: WorkerParameters
) : CoroutineWorker(context, parameters) {


    override suspend fun doWork(): Result {
        while (true) {
            val listOfCryptoNames = apiService.loadNamesOfTopCoins().listOfTopCoinInfoDto?.map {
                it.coinInfo?.nameOfCoin
            }
            val refactoredCryptoNames = mapper.convertListOfNamesToString(listOfCryptoNames)

            val fullDataOfCoinsJsonAnswer =
                apiService.loadFullDataOfTopCoins(fsym = refactoredCryptoNames)
            val listOfFullInfoFromNetwork =
                mapper.loadCoinFullInfoDtoFromNamesOfCoins(fullDataOfCoinsJsonAnswer)
            val listOfCoinFullInfoDb = listOfFullInfoFromNetwork.map {
                mapper.mapCoinFullInfoDtoToCoinFullInfoDb(it)
            }
            Log.d("MainActivity", listOfCoinFullInfoDb.toString())
            cryptoDao.addCoinFullInfoList(listOfCoinFullInfoDb)
            delay(10000)
        }
    }


    class Factory @Inject constructor(
        private val apiService: ApiService,
        private val cryptoDao: CryptoDao,
        private val mapper: Mapper,
    ) : ChildWorkerFactory {
        override fun create(
            context: Context,
            workerParameters: WorkerParameters
        ): ListenableWorker {
            return RefreshDataWorker(apiService, cryptoDao, mapper, context, workerParameters)
        }
    }

    companion object {
        const val REFRESH_DATA = "REFRESH_DATA"

        fun getOneTimeWorkRequest(): OneTimeWorkRequest {

            return OneTimeWorkRequestBuilder<RefreshDataWorker>()

                .build()
        }
    }
}