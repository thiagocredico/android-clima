package com.betrybe.trybeclima.data.api.model

data class TempData(
    val day: Double,
    val min: Double,
    val max: Double,
    val night: Double,
    val eve: Double,
    val morn: Double
)
