package com.mmartin.ghibliapi.data

import com.mmartin.ghibliapi.di.Local
import com.mmartin.ghibliapi.di.Remote
import com.mmartin.ghibliapi.film.Film
import io.reactivex.Observable
import javax.inject.Inject

/**
 * The concrete implementation for accessing Film data from remote or local sources
 *
 *
 * Created by mmartin on 9/12/17.
 */
class FilmsRepository @Inject
constructor(@param:Remote internal var remoteDataSource: FilmsDataSource, @param:Local internal var localDataSource: FilmsDataSource) : FilmsDataSource() {
    override fun getFilms(): Observable<List<Film>> {
        if (localDataSource.isEmpty) {
            return remoteDataSource.films
                    .map {
                        localDataSource.storeFilms(it)
                        it
                    }
        }

        return localDataSource.films
    }

    override fun getFilm(id: String): Observable<Film> {
        return if (localDataSource.getFilm(id) != null) {
            localDataSource.getFilm(id)
        } else remoteDataSource.getFilm(id)
                .map {
                    localDataSource.storeFilm(it)
                    it
                }
    }
}
