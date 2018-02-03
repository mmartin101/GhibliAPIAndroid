package com.mmartin.ghibliapi.di.module

import com.mmartin.ghibliapi.network.GhibliApi
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {
    @Provides
    fun provideGhibliApi(): GhibliApi {
        return GhibliApi()
    }
}