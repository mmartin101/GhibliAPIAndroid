package com.mmartin.ghibliapi.network

import com.mmartin.ghibliapi.network.moshi.GhibliUrlWithIdAdapter
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * Created by mmartin on 4/10/17.
 */
@Singleton
class GhibliApi {

    private val retrofit: Retrofit

    val filmService: FilmService
        get() = retrofit.create(FilmService::class.java)

    val peopleService: PeopleService
        get() = retrofit.create(PeopleService::class.java)

    init {
        val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .add(GhibliUrlWithIdAdapter())
                .build()
        retrofit = Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(API_URL)
                .build()
    }

    companion object {
        var API_URL = "https://ghibliapi.herokuapp.com/"
    }
}
