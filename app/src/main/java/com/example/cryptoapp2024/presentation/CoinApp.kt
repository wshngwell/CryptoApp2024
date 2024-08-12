package com.example.cryptoapp2024.presentation

import android.app.Application
import com.example.cryptoapp2024.di.DaggerApplicationComponent

class CoinApp : Application() {


    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}