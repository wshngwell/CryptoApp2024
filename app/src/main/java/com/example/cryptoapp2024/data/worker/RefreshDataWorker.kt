package com.example.cryptoapp2024.data.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.cryptoapp2024.data.database.CryptoDao
import com.example.cryptoapp2024.data.network.ApiService
import com.example.cryptoapp2024.data.network.Mapper
import kotlinx.coroutines.delay

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
            cryptoDao.addCoinFullInfoList(listOfCoinFullInfoDb)
            delay(10000)
        }

    }
}