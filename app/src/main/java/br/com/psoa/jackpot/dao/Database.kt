package br.com.psoa.jackpot.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.psoa.jackpot.entity.BetEntity
import br.com.psoa.jackpot.entity.MegaSenaEntity

@Database(entities = [MegaSenaEntity::class, BetEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class Database : RoomDatabase() {
    abstract fun megaSenaDao(): MegaSenaDao
    abstract fun betDao(): BetDao
}