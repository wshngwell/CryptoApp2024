package com.example.cryptoapp2024.data.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cryptoapp2024.data.database.DBmodel.CoinFullInfoDb

@Database(entities = [CoinFullInfoDb::class], version = 1, exportSchema = false)
abstract class CryptoDataBase : RoomDatabase() {

    abstract fun getCryptoDao(): CryptoDao

    companion object {
        private val LOCK = Any()
        private const val CRYPTO_DB = "CRYPTO_DB"
        private var cryptoDataBase: CryptoDataBase? = null

        fun createCryptoDataBase(application: Application): CryptoDataBase {
            cryptoDataBase?.let {
                return it
            }
            synchronized(LOCK) {
                cryptoDataBase?.let {
                    return it
                }
                val instance =
                    Room.databaseBuilder(application, CryptoDataBase::class.java, CRYPTO_DB)
                        .build()
                cryptoDataBase = instance
                return instance

            }
        }
    }
}