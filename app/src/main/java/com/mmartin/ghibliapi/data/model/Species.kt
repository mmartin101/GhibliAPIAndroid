package com.mmartin.ghibliapi.data.model

/**
 * Created by mmartin on 2/3/18.
 */
data class Species(
        var id: String,
        var name: String,
        var classification: String,
        var eye_colors: String,
        var hair_colors: String,
        var films: List<String>,
        var people: List<String>,
        var url: List<String>
)