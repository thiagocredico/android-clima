package com.betrybe.trybeclima.data.api

import com.betrybe.trybeclima.data.api.model.CurrentWeatherData
import com.betrybe.trybeclima.data.api.model.ForecastDailyData
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherService {

    @GET("weather")
    suspend fun getCurrentWeatherData(
        @Query("appid") apiKey: String,
        @Query("q") cityQuery: String,
        @Query("units") units: String = "metric"
    ): Response<CurrentWeatherData>

    @GET("forecast/daily")
    suspend fun getForecastDailyData(
        @Query("appid") apiKey: String,
        @Query("q") cityQuery: String,
        @Query("cnt") days: Int,
        @Query("units") units: String = "metric"
    ): Response<ForecastDailyData>

}