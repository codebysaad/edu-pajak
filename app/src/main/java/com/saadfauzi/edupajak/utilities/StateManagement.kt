package com.saadfauzi.edupajak.utilities

sealed class StateManagement<out T: Any?> {
    object Loading : StateManagement<Nothing>()
    data class Success<out T: Any>(val data: T) : StateManagement<T>()
    data class Error(val message: String) : StateManagement<Nothing>()
}
