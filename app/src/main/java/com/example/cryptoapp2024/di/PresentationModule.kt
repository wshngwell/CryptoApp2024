package com.example.cryptoapp2024.di

import androidx.lifecycle.ViewModel
import com.example.cryptoapp2024.presentation.CoinsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
interface PresentationModule {

    @IntoMap
    @ViewModelKey(CoinsViewModel::class)
    @Binds
    fun bindsCoinsViewModel(coinsViewModel: CoinsViewModel): ViewModel

}