package com.mmartin.ghibliapi.data

import javax.inject.Inject
import com.mmartin.ghibliapi.App
import com.mmartin.ghibliapi.data.model.Film
import com.mmartin.ghibliapi.data.model.Person
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import io.reactivex.Single
import okio.Buffer
import java.io.IOException

class PeopleFakeRemoteDataSource @Inject constructor(val app: App) : DataSource<Person>() {
    private var moshi = Moshi.Builder().build()
    private var personList = listOf<Person>()

    override val allItems: Single<List<Person>>
        get() {
            return Single.create<List<Person>> { sub ->
                if (personList.isEmpty()) {
                    try {
                        val inputStream = app.assets.open("json/people.json")
                        val type = Types.newParameterizedType(List::class.java, Film::class.java)
                        val jsonAdapter = moshi.adapter<List<Person>>(type)
                        jsonAdapter.fromJson(Buffer().readFrom(inputStream))?.let {
                            personList = it
                            sub.onSuccess(it)
                        }
                        sub.onSuccess(personList)
                    } catch (e: IOException) {
                        sub.onError(e)
                    }
                } else {
                    Single.create<List<Person>> { emitter ->
                        emitter.onSuccess(personList)
                    }
                }
            }
        }

    override fun getItem(id: String): Single<Person> {
        return Single.create { sub ->
            personList.find { it.id == id }?.let { sub.onSuccess(it) }
                    ?: sub.onError(NoSuchElementException("No film with that id..."))
        }
    }
}