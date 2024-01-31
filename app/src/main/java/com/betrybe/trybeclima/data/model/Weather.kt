package com.betrybe.trybeclima.data.model

data class Weather (
    val cityName:String,
    val temp:Double,
    val maxTemp:Double,
    val minTemp:Double,
    val feelsTemp:Double,
    val humidity:Int,
    val forecast01Temp:Double,
    val forecast01Date: String,
    val forecast02Temp:Double,
    val forecast02Date: String,
    val forecast03Temp:Double,
    val forecast03Date: String,
    val forecast04Temp:Double,
    val forecast04Date: String,
    val forecast05Temp:Double,
    val forecast05Date: String,
)
