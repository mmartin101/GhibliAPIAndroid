package com.mmartin.ghibliapi.data.model

import com.squareup.moshi.Json

/**
 * Created by mmartin on 2/3/18.
 */
data class Species(
        var id: String,
        var name: String,
        var classification: String,
        @Json(name = "eye_colors")
        var eyeColors: String,
        @Json(name = "hair_colors")
        var hairColors: String,
        var films: List<String>,
        var people: List<String>,
        var url: List<String>
)