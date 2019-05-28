package com.mmartin.ghibliapi.data

import androidx.room.Room
import com.mmartin.ghibliapi.App
import com.mmartin.ghibliapi.data.model.Film
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * Film repo for Films stored in local storage
 *
 * Created by mmartin on 10/11/17.
 */
class FilmsLocalDataSource @Inject
constructor(app: App) : DataSource<Film>() {
    private val appDatabase: AppDatabase = Room.databaseBuilder(app, AppDatabase::class.java, "AppDatabase.db")
            .build()

    override val isEmpty: Boolean
        get() = appDatabase.filmDao().loadAllFilms()
                .isEmpty.blockingGet()

    override val allItems: Flowable<List<Film>>
        get() {
            return appDatabase.filmDao().loadAllFilms()
        }

    override fun getItem(id: String): Flowable<Film> {
        return appDatabase.filmDao().getFilm(id)
    }

    override fun store(itemList: List<Film>) {
        appDatabase.filmDao()
                .insertFilms(*itemList.toTypedArray())
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe({}, { error -> Timber.e(error) })
    }

    override fun store(item: Film) {
        appDatabase.filmDao()
                .insertFilms(item)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe({}, { error -> Timber.e(error) })
    }
}
