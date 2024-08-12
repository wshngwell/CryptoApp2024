package com.example.cryptoapp2024.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.cryptoapp2024.domain.CoinFullInfo

class DiffUtilCoins : DiffUtil.ItemCallback<CoinFullInfo> (){

    override fun areItemsTheSame(oldItem: CoinFullInfo, newItem: CoinFullInfo): Boolean {
        return oldItem.FROMSYMBOL == newItem.FROMSYMBOL
    }

    override fun areContentsTheSame(oldItem: CoinFullInfo, newItem: CoinFullInfo): Boolean {
        return oldItem == newItem
    }
}