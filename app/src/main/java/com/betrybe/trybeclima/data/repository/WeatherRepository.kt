package com.betrybe.trybeclima.data.repository

import android.util.Log
import com.betrybe.trybeclima.data.model.Response
import com.betrybe.trybeclima.data.model.Weather
import com.betrybe.trybeclima.data.network.WeatherDataSource
import java.lang.Exception
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Optional

class WeatherRepository(private val mWeatherDataSource: WeatherDataSource = WeatherDataSource()) {

    suspend fun getWeather(cityName: String): Response<Weather> {

        try {

            val currentWeatherData = mWeatherDataSource.getCurrentWeatherData(cityName)
            val forecastDailyData = mWeatherDataSource.getForecastDailyData(cityName)

            if (currentWeatherData != null && forecastDailyData != null) {
                val weather = Weather(
                    currentWeatherData.name,
                    currentWeatherData.main.temp,
                    currentWeatherData.main.tempMax,
                    currentWeatherData.main.tempMin,
                    currentWeatherData.main.feelsLike,
                    currentWeatherData.main.humidity,
                    forecastDailyData.list[0].temp.day,
                    formatDatetime(forecastDailyData.list[0].dt),
                    forecastDailyData.list[1].temp.day,
                    formatDatetime(forecastDailyData.list[1].dt),
                    forecastDailyData.list[2].temp.day,
                    formatDatetime(forecastDailyData.list[2].dt),
                    forecastDailyData.list[3].temp.day,
                    formatDatetime(forecastDailyData.list[3].dt),
                    forecastDailyData.list[4].temp.day,
                    formatDatetime(forecastDailyData.list[4].dt),
                )
                return Response(true, "", weather)
            }

        } catch (ex: Exception) {
            Log.e("Trybe Clima", "Oie: ${ex.message}")
            return Response(false, ex.message.orEmpty(), null)
        }

        return Response(false, "Um erro ocorreu", null)

    }

    private fun formatDatetime(dateTime: Long): String {
        val zoneId = ZoneId.systemDefault()
        val formatter = DateTimeFormatter.ofPattern("dd/yy")
        val instant = Instant.ofEpochSecond(dateTime)
        val forecastDate = instant.atZone(zoneId).toLocalDate()
        return forecastDate.format(formatter)
    }

}