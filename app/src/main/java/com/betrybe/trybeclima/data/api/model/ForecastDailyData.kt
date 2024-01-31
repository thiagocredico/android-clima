package com.betrybe.trybeclima.data.api.model

data class ForecastDailyData (
    val city: CityData,
    val cod: Int,
    val message: Double,
    val cnt: Int,
    val list: List<ForecastData>
)