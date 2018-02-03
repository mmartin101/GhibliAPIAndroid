package com.mmartin.ghibliapi.di.module

import com.mmartin.ghibliapi.App

import dagger.Module
import dagger.Provides

/**
 * Created by mmartin on 10/11/17.
 */
@Module
class ApplicationModule(internal var app: App) {

    @Provides
    fun provideApp(): App {
        return app
    }
}
