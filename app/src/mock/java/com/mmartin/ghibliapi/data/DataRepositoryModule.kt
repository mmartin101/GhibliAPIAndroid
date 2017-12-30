package com.mmartin.ghibliapi.data

import com.mmartin.ghibliapi.App
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
    fun provideGhibliFilmsRemoteDataSource(application: App): FakeFilmsRemoteDataSource {
        return FakeFilmsRemoteDataSource(application)
    }

    @Singleton
    @Provides
    @Local
    fun provideGhibliFilmsLocalDataSource(application: App): FilmsLocalDataSource {
        return FilmsLocalDataSource(application)
    }

    @Singleton
    @Provides
    fun provideGhibliFilmsRepository(remote: FakeFilmsRemoteDataSource, local: FilmsLocalDataSource): FilmsRepository {
        return FilmsRepository(remote, local)
    }
}