package com.betrybe.trybeclima

import com.betrybe.trybeclima.data.api.model.CityData
import com.betrybe.trybeclima.data.api.model.CloudsData
import com.betrybe.trybeclima.data.api.model.CoordinatesData
import com.betrybe.trybeclima.data.api.model.CurrentWeatherData
import com.betrybe.trybeclima.data.api.model.FeelsLikeData
import com.betrybe.trybeclima.data.api.model.ForecastDailyData
import com.betrybe.trybeclima.data.api.model.ForecastData
import com.betrybe.trybeclima.data.api.model.MainData
import com.betrybe.trybeclima.data.api.model.RainData
import com.betrybe.trybeclima.data.api.model.SysData
import com.betrybe.trybeclima.data.api.model.TempData
import com.betrybe.trybeclima.data.api.model.WeatherData
import com.betrybe.trybeclima.data.api.model.WindData
import com.betrybe.trybeclima.data.model.Response
import com.betrybe.trybeclima.data.model.Weather

object WeatherTestMock {

    val currentWeatherDataMock = CurrentWeatherData(
        CoordinatesData(0.0, 0.0),
        listOf(WeatherData(0, "", "", "")),
        "",
        MainData(0.0, 0.0, 0.0, 0.0, 0, 0, 0, 0),
        0,
        WindData(0.0, 0, 0.0),
        RainData(0.0, 0.0), CloudsData(0), 0L,
        SysData(0, 0, "", 0L, 0L),
        0,
        0,
        "",
        0
    )
    val forecastDailyDataMock = ForecastDailyData(
        CityData(
            0, "",
            CoordinatesData(0.0, 0.0), "", 0, 0
        ),
        0,
        0.0,
        0,
        listOf(
            ForecastData(
                1701982191L,
                0L,
                0L,
                TempData(0.0, 0.0, 0.0, 0.0, 0.0, 0.0),
                FeelsLikeData(
                    0.0,
                    0.0,
                    0.0,
                    0.0),
                0,
                0,
                listOf(WeatherData(0, "", "", "")),
                0.0,
                0,
                0.0,
                0,
                0.0,
                0.0
            ),
            ForecastData(
                1701982191L,
                0L,
                0L,
                TempData(0.0, 0.0, 0.0, 0.0, 0.0, 0.0),
                FeelsLikeData(
                    0.0,
                    0.0,
                    0.0,
                    0.0),
                0,
                0,
                listOf(WeatherData(0, "", "", "")),
                0.0,
                0,
                0.0,
                0,
                0.0,
                0.0
            ),
            ForecastData(
                1701982191L,
                0L,
                0L,
                TempData(0.0, 0.0, 0.0, 0.0, 0.0, 0.0),
                FeelsLikeData(
                    0.0,
                    0.0,
                    0.0,
                    0.0),
                0,
                0,
                listOf(WeatherData(0, "", "", "")),
                0.0,
                0,
                0.0,
                0,
                0.0,
                0.0
            ),
            ForecastData(
                1701982191L,
                0L,
                0L,
                TempData(0.0, 0.0, 0.0, 0.0, 0.0, 0.0),
                FeelsLikeData(
                    0.0,
                    0.0,
                    0.0,
                    0.0),
                0,
                0,
                listOf(WeatherData(0, "", "", "")),
                0.0,
                0,
                0.0,
                0,
                0.0,
                0.0
            ),
            ForecastData(
                1701982191L,
                0L,
                0L,
                TempData(0.0, 0.0, 0.0, 0.0, 0.0, 0.0),
                FeelsLikeData(
                    0.0,
                    0.0,
                    0.0,
                    0.0),
                0,
                0,
                listOf(WeatherData(0, "", "", "")),
                0.0,
                0,
                0.0,
                0,
                0.0,
                0.0
            )
        )
    )

    val weatherResponseMock = Response(
        true,
        "",
        Weather(
            "",
            0.0,
            0.0,
            0.0,
            0.0,
            0,
            0.0,
            "07/23",
            0.0,
            "07/23",
            0.0,
            "07/23",
            0.0,
            "07/23",
            0.0,
            "07/23",)
    )

}