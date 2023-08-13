package com.mubarak.tmdb.utils

sealed class ViewState<T> {
    class Loading<T> : ViewState<T>()
    class Success<T>(val data: T) : ViewState<T>()
    class Error<T>(val error: kotlin.Error) : ViewState<T>()

    companion object {
        fun <T> loading() = Loading<T>()
        fun <T> success(data: T) = Success(data)
        fun <T> error(error: kotlin.Error) = Error<T>(error)
    }
}

fun <T> Throwable.toViewState(): ViewState <T> {
    return ViewState.Error(error("Error"))
}