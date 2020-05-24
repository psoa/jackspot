package br.com.psoa.jackpot

import androidx.annotation.NonNull
import androidx.annotation.Nullable

class Resource<T> private constructor(
    @NonNull
    status: Status,
    @Nullable
    data: T,
    @Nullable message: String?
) {
    @NonNull
    val status: Status = status

    @Nullable
    val data: T = data

    @Nullable
    val message: String? = message

    companion object {
        fun <T> success(@NonNull data: T): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String?, @Nullable data: T): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }

        fun <T> loading(@Nullable data: T): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }

}
enum class Status {
    LOADING,
    SUCCESS,
    ERROR

}
