package com.betrybe.trybeclima.data.api.model

data class CurrentWeatherData(
    val coord: CoordinatesData,
    val weather: List<WeatherData>,
    val base: String,
    val main: MainData,
    val visibility: Int,
    val wind: WindData,
    val rain: RainData,
    val clouds: CloudsData,
    val dt: Long,
    val sys: SysData,
    val timezone: Int,
    val id: Int,
    val name: String,
    val cod: Int
)
