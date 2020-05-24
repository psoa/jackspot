package br.com.psoa.jackpot.dao

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    /*
     * The method returns the Database object
     * */
    @Provides
    @Singleton
    internal fun provideDatabase(application: Application): Database {
        return Room.databaseBuilder(
            application, Database::class.java, "jackpot.db")
            .allowMainThreadQueries().build()
    }

    @Provides
    @Singleton
    internal fun provideMegaSenaDao(appDatabase: Database): MegaSenaDao {
        return appDatabase.megaSenaDao()
    }

    @Provides
    @Singleton
    internal fun provideBetDao(appDatabase: Database): BetDao {
        return appDatabase.betDao()
    }

}