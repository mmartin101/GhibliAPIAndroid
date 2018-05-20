package com.mmartin.ghibliapi.data

import com.mmartin.ghibliapi.App
import com.mmartin.ghibliapi.data.model.Film
import com.mmartin.ghibliapi.data.model.Person
import com.mmartin.ghibliapi.di.Local
import com.mmartin.ghibliapi.di.Remote
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by mmartin on 10/11/17.
 */
@Module
class DataRepositoryModule {
    @Singleton
    @Remote
    @Provides
    fun provideGhibliFilmsRemoteDataSource(application: App): DataSource<Film> {
        return FakeFilmsRemoteDataSource(application)
    }

    @Singleton
    @Provides
    @Local
    fun provideGhibliFilmsLocalDataSource(): DataSource<Film> {
        return FilmsLocalDataSource()
    }

    @Singleton
    @Provides
    @Remote
    fun providePeopleRemoteDataSource(application: App): DataSource<Person> = PeopleFakeRemoteDataSource(application)

    @Singleton
    @Provides
    @Local
    fun providePeopleLocalDataSource(): DataSource<Person> = PeopleLocalDataSource()
}