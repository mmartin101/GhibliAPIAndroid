package com.mmartin.ghibliapi.data.model

import com.mmartin.ghibliapi.network.moshi.UrlsWithId

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
        var release_date: String? = null,
        var rtScore: Int? = null,
        var url: String? = null,

        @UrlsWithId
        var people: List<String>? = null,
        @UrlsWithId
        var species: List<String>? = null,
        @UrlsWithId
        var locations: List<String>? = null,
        @UrlsWithId
        var vehicles: List<String>? = null
)
