package br.com.psoa.jackpot.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import br.com.psoa.jackpot.Repository
import br.com.psoa.jackpot.entity.MegaSenaEntity
import io.reactivex.*
import javax.inject.Inject

class MainViewModel @Inject constructor(private val megaSenaRepository: Repository) :
    ViewModel() {

    fun loadLastResult()
            : LiveData<MegaSenaEntity> {
        return megaSenaRepository.getMegaSenaLastResult().toLiveData()
    }
}

fun <T> Flowable<T>.toLiveData() :  LiveData<T> {
    return LiveDataReactiveStreams.fromPublisher(this)
}

fun <T> Observable<T>.toLiveData(backPressureStrategy: BackpressureStrategy) :  LiveData<T> {
    return LiveDataReactiveStreams.fromPublisher(this.toFlowable(backPressureStrategy))
}

fun <T> Single<T>.toLiveData() :  LiveData<T> {
    return LiveDataReactiveStreams.fromPublisher(this.toFlowable())
}

fun <T> Maybe<T>.toLiveData() :  LiveData<T> {
    return LiveDataReactiveStreams.fromPublisher(this.toFlowable())
}

fun <T> Completable.toLiveData() :  LiveData<T> {
    return LiveDataReactiveStreams.fromPublisher(this.toFlowable())
}