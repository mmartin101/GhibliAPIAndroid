package com.mmartin.ghibliapi.data

import com.mmartin.ghibliapi.App
import com.mmartin.ghibliapi.network.GhibliApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by mmartin on 10/11/17.
 */
@Module
class GhibliFilmsRepositoryModule {
    @Singleton
    @Provides
    @Remote
    fun provideGhibliFilmsRemoteDataSource(api: GhibliApi) {
        GhibliFilmsRemoteDataSource(api)
    }

    @Singleton
    @Provides
    @Local
    fun provideGhibliFilmsLocalDataSource(application: App) {
        GhibliFilmsLocalDataSource(application)
    }
}