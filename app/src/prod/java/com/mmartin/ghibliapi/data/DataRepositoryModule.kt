package com.mmartin.ghibliapi.data

import com.mmartin.ghibliapi.App
import com.mmartin.ghibliapi.data.model.Film
import com.mmartin.ghibliapi.data.model.Person
import com.mmartin.ghibliapi.di.Local
import com.mmartin.ghibliapi.di.Remote
import com.mmartin.ghibliapi.network.GhibliApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Provides all data source instances
 * Created by mmartin on 10/11/17.
 */
@Module
class DataRepositoryModule {
    @Singleton
    @Provides
    @Remote
    fun provideFilmsRemoteDataSource(api: GhibliApi): DataSource<Film> = FilmsRemoteDataSource(api)

    @Singleton
    @Provides
    @Local
    fun provideFilmsLocalDataSource(application: App): DataSource<Film> = FilmsLocalDataSource(application)

    @Singleton
    @Provides
    @Remote
    fun providePeopleRemoteDataSource(api: GhibliApi): DataSource<Person> = PeopleRemoteDataSource(api)

    @Singleton
    @Provides
    @Local
    fun providePeopleLocalDataSource(application: App): DataSource<Person> = PeopleLocalDataSource(application)
}