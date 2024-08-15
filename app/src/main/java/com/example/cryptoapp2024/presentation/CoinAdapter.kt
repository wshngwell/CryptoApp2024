package com.example.cryptoapp2024.presentation

import android.content.Context
import android.provider.Settings.Global.getString
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.cryptoapp2024.domain.CoinFullInfo
import com.example.cryptoappaugust2024.R
import com.example.cryptoappaugust2024.databinding.CardCoinBinding
import com.example.cryptoappaugust2024.databinding.DetailCoinFragmentBinding

class CoinAdapter(
    private val context: Context
) : ListAdapter<CoinFullInfo, CoinViewHolder>(DiffUtilCoins()) {


    var onCoinCardListener: ((String?) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {

        val view = CardCoinBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CoinViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {

        val currentCoin = currentList[position]

        with(holder.binding) {

            fromSymbol.text = currentCoin.FROMSYMBOL
            toSymbol.text = currentCoin.TOSYMBOL

            price.text = currentCoin.PRICE.toString()

            lastUpdate.text = root.context.getString(
                R.string.timeOflastUpdate,
                currentCoin.LASTUPDATE.toString()
            )
            Glide.with(context)
                .load(currentCoin.IMAGEURL)
                .into(imageIdMini)

            holder.binding.root.setOnClickListener {
                onCoinCardListener?.invoke(currentCoin.FROMSYMBOL)
            }

        }


    }
}