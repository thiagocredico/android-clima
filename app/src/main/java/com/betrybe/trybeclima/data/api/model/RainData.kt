package com.betrybe.trybeclima.data.api.model

import com.google.gson.annotations.SerializedName

data class RainData (
    @SerializedName("1h")
    val lastOneHour:Double,
    @SerializedName("3h")
    val lastThreeHour:Double,
)
