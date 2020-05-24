package br.com.psoa.jackpot.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import br.com.psoa.jackpot.entity.MegaSenaEntity
import io.reactivex.Maybe


@Dao
interface MegaSenaDao {

    @Insert(onConflict = REPLACE)
    fun insert(bet: MegaSenaEntity)

    @Delete
    fun delete (bet: MegaSenaEntity)

    @Query("SELECT * FROM mega_sena WHERE lottery Is :id")
    fun load(id: String): Maybe<MegaSenaEntity>

    @Query("SELECT * FROM mega_sena WHERE lottery = (SELECT MAX(lottery) FROM mega_sena)")
    fun loadLastLottery(): Maybe<MegaSenaEntity>

}