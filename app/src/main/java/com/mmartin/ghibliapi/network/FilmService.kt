package com.mmartin.ghibliapi.network

import com.mmartin.ghibliapi.data.model.Film


import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Ghibli Films API
 *
 *
 * Created by mmartin on 4/10/17.
 */

interface FilmService {
    @get:GET("films")
    val films: Observable<List<Film>>

    @GET("films/{id}")
    fun getFilmById(@Path("id") filmId: String): Observable<Film>
}
