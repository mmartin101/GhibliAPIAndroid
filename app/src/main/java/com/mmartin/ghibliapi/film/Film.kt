package com.mmartin.ghibliapi.film

import com.squareup.moshi.Json

/**
 * Model for Film objects
 *
 * Created by mmartin on 4/10/17.
 */

data class Film(
        var id: String,
        var title: String? = null,
        var description: String? = null,
        var director: String? = null,
        var producer: String? = null,
        @Json(name = "release_date")
        var releaseDate: String? = null,
        var rtScore: Int? = null,
        var url: String? = null,

        var people: List<String>? = null,
        var species: List<String>? = null,
        var locations: List<String>? = null,
        var vehicles: List<String>? = null
)
