package com.mmartin.ghibliapi.network

import com.mmartin.ghibliapi.data.model.Person
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Ghibli People API
 *
 * Created by mmartin on 5/24/17.
 */

interface PeopleService {
    @get:GET("people")
    val people: Single<List<Person>>

    @GET("people/{id}")
    fun getPeopleById(@Path("id") personId: String): Single<Person>
}
