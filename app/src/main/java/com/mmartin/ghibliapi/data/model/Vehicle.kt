package com.mmartin.ghibliapi.data.model

import com.squareup.moshi.Json

/**
 * Created by mmartin on 2/3/18.
 */
data class Vehicle(
        var id: String,
        var name: String,
        var description: String,
        @Json(name = "vehicle_class")
        var vehicleClass: String,
        var length: String,
        var pilot: String,
        var films: String,
        var url: String
)