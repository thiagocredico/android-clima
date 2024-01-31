package com.betrybe.trybeclima.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object OpenWeatherServiceClient {

    const val API_KEY = "2dbf6a905778a62678f46bbc0db92ed4"

    val instance: OpenWeatherService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(OpenWeatherService::class.java)
    }

}