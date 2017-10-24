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
class GhibliFilmsRepositoryModule() {
    @Singleton
    @Remote
    @Provides
    fun provideGhibliFilmsRemoteDataSource(api: GhibliApi): GhibliFilmsRemoteDataSource {
        return GhibliFilmsRemoteDataSource(api)
    }
    @Singleton
    @Provides
    @Local
    fun provideGhibliFilmsLocalDataSource(application: App): GhibliFilmsLocalDataSource {
        return GhibliFilmsLocalDataSource(application)
    }

    @Provides
    fun provideGhibliFilmsRepository(remote: GhibliFilmsRemoteDataSource, local: GhibliFilmsLocalDataSource): GhibliFilmsRepository {
        return GhibliFilmsRepository(remote, local)
    }
}