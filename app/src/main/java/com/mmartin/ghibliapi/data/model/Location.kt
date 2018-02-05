package com.mmartin.ghibliapi.data.model

/**
 * Created by mmartin on 2/3/18.
 */
data class Location(
        var id: String,
        var name: String,
        var climate: String,
        var terrain: String,
        var surface_water: Int,
        var residents: List<String>,
        var films: List<String>,
        var url: List<String>
)