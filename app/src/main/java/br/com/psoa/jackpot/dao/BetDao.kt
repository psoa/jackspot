package br.com.psoa.jackpot.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import br.com.psoa.jackpot.entity.BetEntity


@Dao
interface BetDao {

    @Insert(onConflict = REPLACE)
    fun insert(bet: BetEntity)

    @Delete
    fun delete (bet: BetEntity)

    @Query("SELECT * FROM bet WHERE id Is :id")
    fun load(id: String): BetEntity

}