package com.example.cryptoapp2024

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoapp2024.presentation.CoinAdapter
import com.example.cryptoapp2024.presentation.CoinApp
import com.example.cryptoapp2024.presentation.CoinDetailActivity
import com.example.cryptoapp2024.presentation.CoinsViewModel
import com.example.cryptoappaugust2024.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinsViewModel
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val mainComponent by lazy {
        (application as CoinApp).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainComponent.inject(this)

        viewModel = ViewModelProvider(this)[CoinsViewModel::class.java]


        val adapter = CoinAdapter()
        binding.coinsListRv.adapter = adapter

        viewModel.listOfCoins.observe(this) {
            adapter.submitList(it)
        }
        adapter.onCoinCardListener = {
            startActivity(
                CoinDetailActivity.newCoinDetailActivity(this, it.toString())
            )
        }


    }
}