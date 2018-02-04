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
constructor(@Remote val remoteDataSource: DataSource<Film>, @Local val localDataSource: DataSource<Film>) : DataSource<Film>() {
    override val allItems: Single<List<Film>>
        get() {
            return if (localDataSource.isEmpty) {
                remoteDataSource.allItems
                        .map {
                            localDataSource.store(it)
                            it
                        }
            } else {
                localDataSource.allItems
            }
        }

    override fun getItem(id: String): Single<Film> {
        return if (localDataSource.isEmpty) {
            remoteDataSource.getItem(id)
                    .map {
                        localDataSource.store(it)
                        it
                    }
        } else {
            localDataSource.getItem(id)
        }
    }
}
