package br.com.psoa.jackpot.lotodicas

import android.util.Log
import br.com.psoa.jackpot.JackpotApp
import br.com.psoa.jackpot.R
import br.com.psoa.jackpot.entity.MegaSenaEntity
import br.com.psoa.jackpot.service.MegaSenaService
import io.reactivex.Maybe
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LotoDicasServiceImpl @Inject constructor(private val lotoDicasService : LotoDicasService)
     : MegaSenaService {

    fun convert (lotoDicas: LotoDicasEntity): MegaSenaEntity {

        var prize = 0.0
        if (lotoDicas.data.prizes.isNotEmpty()) {
            prize = lotoDicas.data.prizes[0].prize
        }
        return MegaSenaEntity(
            lotoDicas.data.draw_number,
            lotoDicas.data.draw_date.substring(0,10),
            lotoDicas.data.drawing.draw,
            prize,
            lotoDicas.data.has_winner,
            lotoDicas.data.next_draw_prize,
            lotoDicas.data.next_draw_date.substring(0,10)
        )
    }
    override fun getMegaSenaResult(numberLottery: String):
            Maybe<MegaSenaEntity> {
        val token = JackpotApp.appContext().resources.getString(R.string.token)
        return Maybe.create {
            lotoDicasService.searchMegaSena(numberLottery, token)
                .enqueue(object : Callback<LotoDicasEntity> {
                    override fun onResponse(
                        call: Call<LotoDicasEntity>,
                        response: Response<LotoDicasEntity>
                    ) {

                        if (response.isSuccessful) {
                            val entity = convert(response.body()!!)
                            it.onSuccess(entity)
                        } else {
                            it.onComplete()
                        }
                    }

                    override fun onFailure(call: Call<LotoDicasEntity>?, t: Throwable?) {
                        Timber.e(t)
                        if (t != null)
                            it.onError(t)
                        else
                            it.onComplete()
                    }

                })
        }
    }
    override fun getMegaSenaResult():
            Maybe<MegaSenaEntity> {
        val token = JackpotApp.appContext().resources.getString(R.string.token)
        return Maybe.create {
            lotoDicasService.searchMegaSena(token)
                .enqueue(object : Callback<LotoDicasEntity> {
                    override fun onResponse(
                        call: Call<LotoDicasEntity>,
                        response: Response<LotoDicasEntity>
                    ) {

                        if (response.isSuccessful) {
                            val rsp = LotoDicasResponse(response?.body())
                            val entity = convert(response.body()!!)
                            it.onSuccess(entity)
                        } else {
                            it.onComplete()
                        }
                    }

                    override fun onFailure(call: Call<LotoDicasEntity>?, t: Throwable?) {
                        Timber.e(t)
                        if (t != null)
                            it.onError(t)
                        else
                            it.onComplete()
                    }

                })
        }
    }
}