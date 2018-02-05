package com.mmartin.ghibliapi.data.model

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
        var eye_color: String? = null,
        var hair_color: String? = null,
        var url: String? = null,
        var species: String? = null,

        var films: List<String>? = null
)
