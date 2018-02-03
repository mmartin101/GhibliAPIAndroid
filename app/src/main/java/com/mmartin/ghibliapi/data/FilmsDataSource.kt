package com.mmartin.ghibliapi.data

import com.mmartin.ghibliapi.data.model.Film
import io.reactivex.Single

/**
 * Main entry point for accessing film data
 *
 *
 * Created by mmartin on 8/12/17.
 */

abstract class FilmsDataSource {
    open val isEmpty: Boolean
        get() = false

    abstract val films: Single<List<Film>>

    abstract fun getFilm(id: String): Single<Film>

    internal open fun storeFilms(films: List<Film>) {}

    internal open fun storeFilm(film: Film) {}
}
