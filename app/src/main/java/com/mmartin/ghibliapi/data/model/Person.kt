package com.mmartin.ghibliapi.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Model for People objects
 *
 * Created by mmartin on 5/24/17.
 */
@Entity
data class Person(
        @PrimaryKey var id: String,
        var name: String? = null,
        var gender: String? = null,
        var age: String? = null,
        var eye_color: String? = null,
        var hair_color: String? = null,
        var url: String? = null,
        var species: String? = null,

        var films: List<String>? = null
)
