package com.mmartin.ghibliapi.network

import com.mmartin.ghibliapi.people.Person
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Ghibli People API
 *
 *
 * Created by mmartin on 5/24/17.
 */

interface PeopleService {
    @get:GET("people")
    val people: Call<Observable<List<Person>>>

    @GET("people/{id}")
    fun getPeopleById(@Path("id") personId: String): Call<Observable<Person>>
}
