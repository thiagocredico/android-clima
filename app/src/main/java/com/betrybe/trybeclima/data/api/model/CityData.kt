package com.betrybe.trybeclima.data.api.model

import java.util.SimpleTimeZone

data class CityData (
    val id: Int,
    val name: String,
    val coord: CoordinatesData,
    val country: String,
    val population: Int,
    val timeZone: Int
)
