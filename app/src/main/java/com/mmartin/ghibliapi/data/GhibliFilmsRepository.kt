package com.mmartin.ghibliapi.data

import com.mmartin.ghibliapi.di.Local
import com.mmartin.ghibliapi.di.Remote
import com.mmartin.ghibliapi.film.Film
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import javax.inject.Inject
import javax.inject.Singleton

/**
 * The concrete implementation for accessing Film data from remote or local sources
 *
 *
 * Created by mmartin on 9/12/17.
 */
@Singleton
class GhibliFilmsRepository @Inject
constructor(@param:Remote internal var remoteDataSource: GhibliFilmsDataSource, @param:Local internal var localDataSource: GhibliFilmsDataSource) : GhibliFilmsDataSource {
    override fun isEmpty(): Boolean {
        return false
    }

    override fun getFilms(): Observable<List<Film>> {
        if (localDataSource.isEmpty) {
            return Observable.zip(localDataSource.films, remoteDataSource.films, BiFunction { local, remote ->
                localDataSource.storeFilms(remote)
                remote
            })
        }

        return localDataSource.films
    }

    override fun getFilm(id: String): Observable<Film> {
        return if (localDataSource.getFilm(id) != null) {
            localDataSource.getFilm(id)
        } else remoteDataSource.getFilm(id)

    }

    override fun storeFilms(films: List<Film>) {
        // nada
    }

    override fun storeFilm(film: Film) {
        // nada
    }
}