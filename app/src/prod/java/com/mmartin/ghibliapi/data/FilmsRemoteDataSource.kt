package com.mmartin.ghibliapi.data

import com.mmartin.ghibliapi.data.model.Film
import com.mmartin.ghibliapi.network.GhibliApi
import io.reactivex.Single
import javax.inject.Inject

/**
 * Concrete implementation for getting data from the Ghibli API
 *
 *
 * Created by mmartin on 9/12/17.
 */
class FilmsRemoteDataSource @Inject
constructor(private val api: GhibliApi) : FilmsDataSource() {

    override val films: Single<List<Film>>
        get() = api.filmService.films

    override fun getFilm(id: String): Single<Film> {
        return api.filmService.getFilmById(id)
    }
}
