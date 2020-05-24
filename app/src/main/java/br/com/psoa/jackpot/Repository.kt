package br.com.psoa.jackpot

import android.annotation.SuppressLint
import androidx.lifecycle.*
import br.com.psoa.jackpot.dao.MegaSenaDao
import br.com.psoa.jackpot.entity.MegaSenaEntity
import br.com.psoa.jackpot.service.MegaSenaService
import io.reactivex.*
import timber.log.Timber
import javax.inject.Inject


class Repository @Inject constructor(private val service : MegaSenaService,
                                     private val dao: MegaSenaDao)  {

    fun getMegaSenaLastResult() : Single<MegaSenaEntity> {
         return  Single.create {
             dao.loadLastLottery().subscribe(
                 { entity ->
                     if (entity.isLast()) {
                         Timber.d("Retrieve data from database")
                         it.onSuccess(entity)
                     }
                     else {
                         Timber.d("Database is out of date, retrieve from network")
                         service.getMegaSenaResult().subscribe(
                             updateDatabase(it),
                             {sEx ->
                                 run {
                                     sEx.printStackTrace();
                                     it.onSuccess(entity)
                                 }},
                             { it.onSuccess(entity) }
                         )
                     }
                },
                 { daoEx ->
                     daoEx.printStackTrace()
                     loadFromService(it)
                 },
                 { loadFromService(it) }
             )
         }
    }

    @SuppressLint("CheckResult")
    private fun loadFromService(it: SingleEmitter<MegaSenaEntity>) {
        service.getMegaSenaResult().subscribe(
            updateDatabase(it),
            { sEx -> it.onError(sEx) },
            { it.onError(RuntimeException("Unable to retrieve a value")) }
        )
    }

    private fun updateDatabase(emitter: SingleEmitter<MegaSenaEntity>): (t: MegaSenaEntity) -> Unit {
        return {
            run {
                dao.insert(it)
                emitter.onSuccess(it)
            }
        }
    }
}

