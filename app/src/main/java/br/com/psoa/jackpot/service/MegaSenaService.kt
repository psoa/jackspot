package br.com.psoa.jackpot.service

import androidx.lifecycle.LiveData
import br.com.psoa.jackpot.entity.MegaSenaEntity
import io.reactivex.Maybe

interface MegaSenaService {
    fun getMegaSenaResult(numberLottery: String): Maybe<MegaSenaEntity>
    fun getMegaSenaResult(): Maybe<MegaSenaEntity>
}