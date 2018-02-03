package com.mmartin.ghibliapi.data

import com.mmartin.ghibliapi.App
import com.mmartin.ghibliapi.data.model.Film
import io.reactivex.Single
import java.util.*
import javax.inject.Inject
import kotlin.NoSuchElementException

/**
 * Film repo for Films stored in local storage
 *
 *
 * Created by mmartin on 10/11/17.
 */
// TODO implement Local DB storage instead of in memory
class FilmsLocalDataSource @Inject
constructor(app: App) : FilmsDataSource() {
    private val filmMap: MutableMap<String, Film>

    override val isEmpty: Boolean
        get() = filmMap.isEmpty()

    override val films: Single<List<Film>>
        get() {
            return Single.create { sub ->
                if (filmMap.isEmpty()) {
                    // TODO use a custom exception here, no such element doesn't really fit...
                    sub.onError(NoSuchElementException("Local cache is empty"))
                } else {
                    sub.onSuccess(filmMap.values.toList())
                }
            }
        }

    init {
        filmMap = HashMap()
    }

    override fun getFilm(id: String): Single<Film> {
        return Single.create { sub ->
            if (filmMap.containsKey(id)) {
                sub.onSuccess(filmMap[id]!!)
            } else {
                sub.onError(NoSuchElementException("Film not found in local cache"))
            }
        }
    }

    override fun storeFilms(films: List<Film>) {
        films.forEach { filmMap[it.id] = it }
    }

    override fun storeFilm(film: Film) {
        filmMap[film.id] = film
    }
}
