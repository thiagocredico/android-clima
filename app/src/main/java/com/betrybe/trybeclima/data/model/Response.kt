package com.betrybe.trybeclima.data.model

data class Response<out T>(
    val success: Boolean,
    val message: String,
    val data: T?
)
