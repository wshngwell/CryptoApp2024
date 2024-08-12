package com.example.cryptoapp2024.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cryptoappaugust2024.R
import com.example.cryptoappaugust2024.databinding.ActivityCoinDetailBinding

class CoinDetailActivity : AppCompatActivity() {

    private val coinId by lazy {
        intent.getStringExtra(COIN_ID)
    }
    private val binding by lazy {
        ActivityCoinDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(
                binding.detailFragmentContainer.id,
                CoinDetailFragment.createCoinDetailFragment(coinId.toString())
            )
            .commit()

    }


    companion object {
        private const val COIN_ID = "id"
        fun newCoinDetailActivity(context: Context, id: String): Intent {
            return Intent(context, CoinDetailActivity::class.java).apply {
                putExtra(COIN_ID, id)
            }
        }
    }
}