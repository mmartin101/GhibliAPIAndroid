package com.mmartin.ghibliapi.data

import com.mmartin.ghibliapi.data.model.Film
import io.reactivex.Single
import java.util.HashMap
import javax.inject.Inject
import kotlin.Boolean
import kotlin.NoSuchElementException
import kotlin.String

/**
 * Film repo for Films stored in local storage
 *
 *
 * Created by mmartin on 10/11/17.
 */
class FilmsLocalDataSource @Inject
constructor() : DataSource<Film>() {
    private val filmMap: MutableMap<String, Film>

    override val isEmpty: Boolean
        get() = filmMap.isEmpty()

    override val allItems: Single<List<Film>>
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

    override fun getItem(id: String): Single<Film> {
        return Single.create { sub ->
            if (filmMap.containsKey(id)) {
                sub.onSuccess(filmMap[id]!!)
            } else {
                sub.onError(NoSuchElementException("Film not found in local cache"))
            }
        }
    }

    override fun store(itemList: List<Film>) {
        itemList.forEach { filmMap[it.id] = it }
    }

    override fun store(item: Film) {
        filmMap[item.id] = item
    }
}
