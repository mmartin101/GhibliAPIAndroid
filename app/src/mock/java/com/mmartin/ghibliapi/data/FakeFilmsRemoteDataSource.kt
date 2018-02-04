package com.mmartin.ghibliapi.data

import com.mmartin.ghibliapi.App
import com.mmartin.ghibliapi.data.model.Film
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import io.reactivex.Single
import okio.Buffer
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject

/**
 * Concrete implementation for getting data from the Ghibli API
 *
 * Created by mmartin on 9/12/17.
 */
class FakeFilmsRemoteDataSource @Inject
constructor(internal var app: App) : DataSource<Film>() {
    private var moshi = Moshi.Builder().build()
    private var filmList = listOf<Film>()

    override val allItems: Single<List<Film>>
        get() {
            return Single.create<List<Film>> { sub ->
                try {
                    val inputStream = app.assets.open("json/films.json")
                    val type = Types.newParameterizedType(List::class.java, Film::class.java)
                    val jsonAdapter = moshi.adapter<List<Film>>(type)
                    filmList = jsonAdapter.fromJson(Buffer().readFrom(inputStream))
                    sub.onSuccess(filmList)
                } catch (e: IOException) {
                    Timber.e(e, "error reading file")
                }
            }
        }

    override fun getItem(id: String): Single<Film> {
        return Single.create { sub ->
            filmList.find { it.id == id }?.let { sub.onSuccess(it) }
                    ?: sub.onError(NoSuchElementException("No film with that id..."))
        }
    }
}
