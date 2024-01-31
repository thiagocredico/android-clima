package com.betrybe.trybeclima.data.network

import com.betrybe.trybeclima.data.api.OpenWeatherServiceClient
import com.betrybe.trybeclima.data.api.model.CurrentWeatherData
import com.betrybe.trybeclima.data.api.model.ForecastDailyData

class WeatherDataSource {

    private val mOpenWeatherService = OpenWeatherServiceClient.instance

    suspend fun getCurrentWeatherData(cityName: String): CurrentWeatherData? {
        val currentWeatherDataResponse = mOpenWeatherService.getCurrentWeatherData(
            OpenWeatherServiceClient.API_KEY,
            cityName
        )
        return currentWeatherDataResponse.body()
    }

    suspend fun getForecastDailyData(cityName: String): ForecastDailyData? {
        val forecastDailyDataResponse = mOpenWeatherService.getForecastDailyData(
            OpenWeatherServiceClient.API_KEY,
            cityName,
            5
        )
        return forecastDailyDataResponse.body()
    }

}