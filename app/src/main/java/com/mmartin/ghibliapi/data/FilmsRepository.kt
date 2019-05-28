package com.mmartin.ghibliapi.data

import com.mmartin.ghibliapi.data.model.Film
import com.mmartin.ghibliapi.di.Local
import com.mmartin.ghibliapi.di.Remote
import io.reactivex.Flowable
import io.reactivex.Single
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalAmount
import java.time.temporal.TemporalUnit
import java.util.*
import javax.inject.Inject

/**
 * The concrete implementation for accessing Film data from remote or local sources
 *
 *
 * Created by mmartin on 9/12/17.
 */
class FilmsRepository @Inject
constructor(@Remote val remoteDataSource: DataSource<Film>, @Local val localDataSource: DataSource<Film>) : DataSource<Film>() {
    override val allItems: Flowable<List<Film>>
        get() {
            val now = Date().time
            val expDate = now + FIVE_HOURS_IN_MILLIS
            val remote = remoteDataSource.allItems
                    .map {
                        it.forEach { film -> film.expirationDate = expDate }
                        localDataSource.store(it)
                        it
                    }
                    .flatMapIterable { it }
            return localDataSource.allItems.firstOrError()
                    .onErrorResumeNext { remote.toS }
                    .toFlowable()
                    .flatMapIterable { it }
                    .filter { it.expirationDate > now }
                    .toList().toFlowable()

        }

    override fun getItem(id: String): Flowable<Film> {
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
    companion object {
        const val FIVE_HOURS_IN_MILLIS: Long = 1000L * 60L * 60L *5L
    }
}
