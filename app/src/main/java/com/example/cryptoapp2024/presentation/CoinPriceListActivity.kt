package com.example.cryptoapp2024.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoappaugust2024.databinding.ActivityMainBinding
import javax.inject.Inject

class CoinPriceListActivity : AppCompatActivity() {

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
        if (binding.coinsListRvHorizontal != null) {
            binding.coinsListRvHorizontal?.adapter = adapter
            adapter.onCoinCardListener = {
                supportFragmentManager.beginTransaction()
                    .replace(
                        binding.fragmentHorizontalContainer!!.id,
                        CoinDetailFragment.createCoinDetailFragment(it.toString())
                    )
                    .commit()
            }

        } else {
            binding.coinsListRv?.adapter = adapter
            adapter.onCoinCardListener = {
                startActivity(
                    CoinDetailActivity.newCoinDetailActivity(this, it.toString())
                )
            }
        }

        viewModel.listOfCoins.observe(this) {
            Log.d("MainActivity", "$it")
            adapter.submitList(it)
        }


    }
}