package com.mmartin.ghibliapi.data

import com.mmartin.ghibliapi.App
import com.mmartin.ghibliapi.data.model.Person
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Film repo for Films stored in local storage
 *
 * Created by mmartin on 2/3/18.
 */
// TODO implement Local DB storage instead of in memory
class PeopleLocalDataSource @Inject
constructor(app: App) : DataSource<Person>() {
    private val map: MutableMap<String, Person> = mutableMapOf()

    override val allItems: Flowable<List<Person>>
        get() {
            return Flowable.create({ sub ->
                if (map.isEmpty()) {
                    // TODO use a custom exception here, no such element doesn't really fit...
                    sub.onError(NoSuchElementException("Local cache is empty"))
                } else {
                    sub.onNext(map.values.toList())
                    sub.onComplete()
                }
            }, BackpressureStrategy.BUFFER)
        }

    override fun getItem(id: String): Flowable<Person> {
        return Flowable.create({ sub ->
            if (map.containsKey(id)) {
                sub.onNext(map[id]!!)
                sub.onComplete()
            } else {
                sub.onError(NoSuchElementException("Person not found in local cache"))
            }
        }, BackpressureStrategy.BUFFER)
    }

    override val isEmpty: Boolean
        get() = map.isEmpty()

    override fun store(itemList: List<Person>) {
        itemList.forEach { map[it.id] = it }
    }

    override fun store(item: Person) {
        map[item.id] = item
    }
}