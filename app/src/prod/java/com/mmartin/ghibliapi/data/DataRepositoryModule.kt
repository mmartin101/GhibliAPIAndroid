package com.mmartin.ghibliapi.data

import com.mmartin.ghibliapi.App
import com.mmartin.ghibliapi.di.Local
import com.mmartin.ghibliapi.di.Remote
import com.mmartin.ghibliapi.network.GhibliApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by mmartin on 10/11/17.
 */
@Module
class DataRepositoryModule {
    @Singleton
    @Provides
    @Remote
    fun provideFilmsRemoteDataSource(api: GhibliApi): FilmsRemoteDataSource {
        return FilmsRemoteDataSource(api)
    }
    @Singleton
    @Provides
    @Local
    fun provideFilmsLocalDataSource(application: App): FilmsLocalDataSource {
        return FilmsLocalDataSource(application)
    }
}