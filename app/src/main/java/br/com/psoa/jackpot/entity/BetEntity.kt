package br.com.psoa.jackpot.entity


import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "bet", indices = [(Index(value = ["lottery"]))])
data class BetEntity(
        @PrimaryKey
        val id: String,
        @NonNull
        val dateOfBet: String, //YYYY-mm-dd
        @NonNull
        val numbers: String, //(n1,n2,n3)
        @NonNull
        val lottery: String
) {
    @Ignore
    constructor(dateOfBet: String,
                numbers: String,
                lottery: String) : this(
            UUID.randomUUID().toString(),
            dateOfBet,
            numbers,
            lottery)


}