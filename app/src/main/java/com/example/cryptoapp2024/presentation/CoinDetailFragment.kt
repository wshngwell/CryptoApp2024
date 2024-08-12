package com.example.cryptoapp2024.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.cryptoappaugust2024.databinding.DetailCoinFragmentBinding

class CoinDetailFragment : Fragment() {

    var _binding: DetailCoinFragmentBinding? = null
    val binding: DetailCoinFragmentBinding
        get() = _binding ?: throw RuntimeException("Binding is null")

    private val viewModel by lazy {

        ViewModelProvider.create(this)[CoinsViewModel::class]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DetailCoinFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val coinId =
            requireArguments().getString(COIN_ID) ?: throw RuntimeException("Unknown CoinId")

        viewModel.getOneCoinInfo(coinId).observe(viewLifecycleOwner) {
            with(binding) {
                Glide.with(view.context)
                    .load(it.IMAGEURL)
                    .into(coinImage)

                fromSymbol.text = it.FROMSYMBOL
                toSymbol.text = it.TOSYMBOL
                price.text = it.PRICE.toString()
                priceMinimum.text = it.LOWDAY.toString()
                priceMaximum.text = it.HIGHDAY.toString()
                lastDeal.text = it.LASTMARKET
                updateTime.text = it.LASTUPDATE.toString()
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val COIN_ID = "id"
        fun createCoinDetailFragment(id: String): CoinDetailFragment {
            return CoinDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(COIN_ID, id)
                }
            }
        }
    }

}