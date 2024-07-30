package com.example.cryptoapp2024.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cryptoapp2024.data.database.DBmodel.CoinFullInfoDb
import javax.inject.Inject


@Dao
interface CryptoDao {

   @Query("SELECT * FROM COIN_FULL_INFO")
    fun getCoinsFullInfoList():LiveData<List<CoinFullInfoDb>>

    @Query("SELECT * FROM COIN_FULL_INFO WHERE FROMSYMBOL=:fsym")
    fun getOneCoinFullInfo(fsym:String):LiveData<CoinFullInfoDb>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCoinFullInfoList(list:List<CoinFullInfoDb>)
}