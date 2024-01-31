package com.betrybe.trybeclima.data.api.model

data class SysData(
    val type: Int,
    val id: Int,
    val country: String,
    val sunrise: Long,
    val sunset: Long
)
