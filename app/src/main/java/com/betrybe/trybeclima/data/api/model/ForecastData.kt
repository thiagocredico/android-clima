package com.betrybe.trybeclima.data.api.model

data class ForecastData (
    val dt: Long,
    val sunrise: Long,
    val sunset: Long,
    val temp: TempData,
    val feelsLike: FeelsLikeData,
    val pressure: Int,
    val humidity: Int,
    val weather: List<WeatherData>,
    val speed: Double,
    val deg: Int,
    val gust: Double,
    val clouds: Int,
    val pop: Double,
    val rain: Double
)
