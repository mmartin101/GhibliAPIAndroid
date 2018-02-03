package com.mmartin.ghibliapi.data

import com.mmartin.ghibliapi.data.model.Film
import com.mmartin.ghibliapi.di.Local
import com.mmartin.ghibliapi.di.Remote
import io.reactivex.Single
import javax.inject.Inject

/**
 * The concrete implementation for accessing Film data from remote or local sources
 *
 *
 * Created by mmartin on 9/12/17.
 */
class FilmsRepository @Inject
constructor(@Remote val remoteDataSource: FilmsDataSource, @Local val localDataSource: FilmsDataSource) : FilmsDataSource() {
    override val films: Single<List<Film>>
        get() {
            return if (localDataSource.isEmpty) {
                remoteDataSource.films
                        .map {
                            localDataSource.storeFilms(it)
                            it
                        }
            } else {
                localDataSource.films
            }
        }

    override fun getFilm(id: String): Single<Film> {
        return if (localDataSource.isEmpty) {
            remoteDataSource.getFilm(id)
                    .map {
                        localDataSource.storeFilm(it)
                        it
                    }
        } else {
            localDataSource.getFilm(id)
        }
    }
}
