package com.mmartin.ghibliapi.di.module

import com.mmartin.ghibliapi.network.GhibliApi
import dagger.Module
import dagger.Provides

/**
 * Created by mmartin on 10/11/17.
 */
@Module
class NetworkModule {
    @Provides
    fun provideGhibliApi(): GhibliApi {
        return GhibliApi()
    }
}