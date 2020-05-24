package br.com.psoa.jackpot.lotodicas

import retrofit2.Call

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LotoDicasService {

    @GET("/api/v2/mega_sena/results/{numberLottery}")
    fun searchMegaSena(@Path("numberLottery") numberLottery: String,
                       @Query("token") token: String) : Call<LotoDicasEntity>

    @GET("/api/v2/mega_sena/results/last")
    fun searchMegaSena(@Query("token") token: String) : Call<LotoDicasEntity>

}