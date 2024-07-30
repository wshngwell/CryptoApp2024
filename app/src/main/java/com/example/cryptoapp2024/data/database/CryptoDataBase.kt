package com.example.cryptoapp2024.data.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database()
abstract class CryptoDataBase : RoomDatabase() {


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