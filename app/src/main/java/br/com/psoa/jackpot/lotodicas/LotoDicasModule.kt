package br.com.psoa.jackpot.lotodicas

import br.com.psoa.jackpot.R
import br.com.psoa.jackpot.service.MegaSenaService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class LotoDicasModule {

    private var apiBaseUrl = "https://www.lotodicas.com.br"

    @Provides
    @Singleton
    @Named ("lotoDicasRetrofit")
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(apiBaseUrl)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun providesLotoDicasService (@Named("lotoDicasRetrofit") retrofit: Retrofit):
            LotoDicasService = retrofit.create(LotoDicasService::class.java)

    @Provides
    @Singleton
    fun providesMegaSenaService (service: LotoDicasService):
            MegaSenaService = LotoDicasServiceImpl(service)

}