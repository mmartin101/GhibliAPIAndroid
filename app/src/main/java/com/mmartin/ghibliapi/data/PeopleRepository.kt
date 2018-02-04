package com.mmartin.ghibliapi.data

import com.mmartin.ghibliapi.data.model.Person
import io.reactivex.Single

/**
 * Created by mmartin on 2/3/18.
 */
class PeopleRepository: DataSource<Person>() {
    override val allItems: Single<List<Person>>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun getItem(id: String): Single<Person> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}