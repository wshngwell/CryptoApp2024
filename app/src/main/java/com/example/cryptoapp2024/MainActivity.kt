package com.example.cryptoapp2024

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoapp2024.presentation.CoinAdapter
import com.example.cryptoapp2024.presentation.CoinApp
import com.example.cryptoapp2024.presentation.CoinDetailActivity
import com.example.cryptoapp2024.presentation.CoinsViewModel
import com.example.cryptoapp2024.presentation.ViewModelFactory
import com.example.cryptoappaugust2024.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[CoinsViewModel::class]
    }


    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val mainComponent by lazy {
        (application as CoinApp).component

    }

    override fun onCreate(savedInstanceState: Bundle?) {

        mainComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapter = CoinAdapter(this)
        binding.coinsListRv.adapter = adapter

        viewModel.listOfCoins.observe(this) {
            Log.d("MainActivity", "$it")
            adapter.submitList(it)
        }
        adapter.onCoinCardListener = {
            startActivity(
                CoinDetailActivity.newCoinDetailActivity(this, it.toString())
            )
        }


    }
}