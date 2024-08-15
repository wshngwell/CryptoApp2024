package com.example.cryptoapp2024.di

import android.app.Application
import com.example.cryptoapp2024.presentation.CoinPriceListActivity
import com.example.cryptoapp2024.presentation.CoinApp
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DomainModule::class, DataModule::class, PresentationModule::class])
interface ApplicationComponent {

    fun inject(activity: CoinPriceListActivity)
    fun inject(coinApp: CoinApp)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}