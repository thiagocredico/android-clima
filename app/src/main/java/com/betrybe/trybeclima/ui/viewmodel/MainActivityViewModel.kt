package com.betrybe.trybeclima.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.betrybe.trybeclima.data.api.OpenWeatherServiceClient
import com.betrybe.trybeclima.data.api.model.CurrentWeatherData
import com.betrybe.trybeclima.data.api.model.ForecastDailyData
import com.betrybe.trybeclima.data.repository.WeatherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class MainActivityViewModel : ViewModel() {

    private val mWeatherRepository = WeatherRepository()

    private var _cityName = MutableLiveData("")
    val cityName: LiveData<String>
        get() = _cityName

    private var _temp = MutableLiveData(0.0)
    val temp: LiveData<Double>
        get() = _temp

    private var _maxTemp = MutableLiveData(0.0)
    val maxTemp: LiveData<Double>
        get() = _maxTemp

    private var _minTemp = MutableLiveData(0.0)
    val minTemp: LiveData<Double>
        get() = _minTemp

    private var _feelsTemp = MutableLiveData(0.0)
    val feelsTemp: LiveData<Double>
        get() = _feelsTemp

    private var _humidity = MutableLiveData(0)
    val humidity: LiveData<Int>
        get() = _humidity

    private var _forecast01Temp = MutableLiveData(0.0)
    val forecast01Temp: LiveData<Double>
        get() = _forecast01Temp

    private var _forecast01Date = MutableLiveData("")
    val forecast01Date: LiveData<String>
        get() = _forecast01Date

    private var _forecast02Temp = MutableLiveData(0.0)
    val forecast02Temp: LiveData<Double>
        get() = _forecast02Temp

    private var _forecast02Date = MutableLiveData("")
    val forecast02Date: LiveData<String>
        get() = _forecast02Date

    private var _forecast03Temp = MutableLiveData(0.0)
    val forecast03Temp: LiveData<Double>
        get() = _forecast03Temp

    private var _forecast03Date = MutableLiveData("")
    val forecast03Date: LiveData<String>
        get() = _forecast03Date

    private var _forecast04Temp = MutableLiveData(0.0)
    val forecast04Temp: LiveData<Double>
        get() = _forecast04Temp

    private var _forecast04Date = MutableLiveData("")
    val forecast04Date: LiveData<String>
        get() = _forecast04Date

    private var _forecast05Temp = MutableLiveData(0.0)
    val forecast05Temp: LiveData<Double>
        get() = _forecast05Temp

    private var _errorMessage = MutableLiveData("")
    val errorMessage: LiveData<String>
        get() = _errorMessage

    private var _forecast05Date = MutableLiveData("")
    val forecast05Date: LiveData<String>
        get() = _forecast05Date

    private var _isForecastContainerVisible = MutableStateFlow(false)
    val isForecastContainerVisible: StateFlow<Boolean>
        get() = _isForecastContainerVisible

    private var _isErrorOccurred = MutableStateFlow(false)
    val isErrorOccurred: StateFlow<Boolean>
        get() = _isErrorOccurred

    fun getWeatherData(cityName: String) {

        CoroutineScope(Dispatchers.IO).launch {
            val response = mWeatherRepository.getWeather(cityName)
            if (response.success) {
                val weather = response.data!!
                _cityName.postValue(weather.cityName)
                _temp.postValue(weather.temp)
                _maxTemp.postValue(weather.maxTemp)
                _minTemp.postValue(weather.minTemp)
                _feelsTemp.postValue(weather.feelsTemp)
                _humidity.postValue(weather.humidity)
                _forecast01Temp.postValue(weather.forecast01Temp)
                _forecast01Date.postValue(weather.forecast01Date)
                _forecast02Temp.postValue(weather.forecast02Temp)
                _forecast02Date.postValue(weather.forecast02Date)
                _forecast03Temp.postValue(weather.forecast03Temp)
                _forecast03Date.postValue(weather.forecast03Date)
                _forecast04Temp.postValue(weather.forecast04Temp)
                _forecast04Date.postValue(weather.forecast04Date)
                _forecast05Temp.postValue(weather.forecast05Temp)
                _forecast05Date.postValue(weather.forecast05Date)
                _isForecastContainerVisible.value = true
                _isErrorOccurred.value = false
            } else {
                _errorMessage.postValue(response.message)
                _isErrorOccurred.value = true
                _isForecastContainerVisible.value = false
            }
        }


    }
}