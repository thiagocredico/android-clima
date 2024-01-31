package com.betrybe.trybeclima

import com.betrybe.trybeclima.data.model.Response
import com.betrybe.trybeclima.data.model.Weather
import com.betrybe.trybeclima.data.network.WeatherDataSource
import com.betrybe.trybeclima.data.repository.WeatherRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class WeatherRepositoryTest {

    @Mock
    lateinit var mWeatherDataSourceMock: WeatherDataSource

    @Test
    fun testGetWeatherIfCityExists() = runTest {

        // Arrange
        val cityName = "Fortaleza"
        Mockito.`when`(mWeatherDataSourceMock.getCurrentWeatherData(cityName)).thenReturn(WeatherTestMock.currentWeatherDataMock)
        Mockito.`when`(mWeatherDataSourceMock.getForecastDailyData(cityName)).thenReturn(WeatherTestMock.forecastDailyDataMock)
        val expected = WeatherTestMock.weatherResponseMock
        val weatherRepository = WeatherRepository(mWeatherDataSourceMock)

        // Act
        val result = weatherRepository.getWeather(cityName)

        // Assert
        Assert.assertEquals(expected, result)

    }

    @Test
    fun testGetWeatherIfCityNotExists() = runTest {

        // Arrange
        val expected = Response<Weather>(false, "Um erro ocorreu", null)
        val cityName = "Sildávia"
        val weatherRepository = WeatherRepository()

        // Act
        val result = weatherRepository.getWeather(cityName)

        // Assert
        Assert.assertEquals(expected, result)

    }


}