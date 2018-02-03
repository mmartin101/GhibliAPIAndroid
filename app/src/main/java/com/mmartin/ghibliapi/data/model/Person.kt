package com.mmartin.ghibliapi.data.model

import com.squareup.moshi.Json

/**
 * Model for People objects
 *
 * Created by mmartin on 5/24/17.
 */

data class Person(
        var id: String,
        var name: String? = null,
        var gender: String? = null,
        var age: String? = null,
        @Json(name = "eye_color")
        var eyeColor: String? = null,
        @Json(name = "hair_color")
        var hairColor: String? = null,
        var url: String? = null,
        var species: String? = null,

        var films: List<String>? = null
)
