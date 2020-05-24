package br.com.psoa.jackpot.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.format.DateTimeFormatter


/**
 * Mega Sena entity.
 *
 */
@Entity(tableName = "mega_sena", indices = [(Index(value = ["lottery"]))])
data class MegaSenaEntity(
        @PrimaryKey
        val lottery: Int,
        @NonNull
        val date: String,
        @NonNull
        val numbers: List<Int>,
        val prize: Double,
        val has_winner: Boolean,
        val next_amount: Double,
        val next_date: String


) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MegaSenaEntity

        if (lottery != other.lottery) return false

        return true
    }

    override fun hashCode(): Int {
        return lottery.hashCode()
    }

    fun isLast(): Boolean {
        val nextDate = LocalDate.parse(next_date,
                DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        return nextDate.isAfter(LocalDate.now())
    }
}