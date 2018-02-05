package com.mmartin.ghibliapi.data

import com.mmartin.ghibliapi.data.model.Person
import com.mmartin.ghibliapi.network.GhibliApi
import io.reactivex.Single
import javax.inject.Inject

/**
 * Concrete implementation for getting people data from the Ghibli API
 *
 * Created by mmartin on 2/3/18.
 */
class PeopleRemoteDataSource @Inject
constructor(private val api: GhibliApi) : DataSource<Person>() {
    override val allItems: Single<List<Person>>
        get() = api.peopleService.people

    override fun getItem(id: String): Single<Person> = api.peopleService.getPeopleById(id)
}