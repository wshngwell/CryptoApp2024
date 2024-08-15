package com.example.cryptoapp2024.presentation

import android.app.Application
import android.util.Log
import androidx.work.Configuration
import com.example.cryptoapp2024.di.DaggerApplicationComponent
import javax.inject.Inject

class CoinApp : Application(), Configuration.Provider {


    @Inject
    lateinit var workerFactory: WorkerFactory

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
    }
}