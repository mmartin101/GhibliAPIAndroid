package com.mmartin.ghibliapi.di.component

import com.mmartin.ghibliapi.data.DataRepositoryModule
import com.mmartin.ghibliapi.data.FilmsRepository
import com.mmartin.ghibliapi.di.Activity
import com.mmartin.ghibliapi.di.module.NetworkModule
import dagger.Component
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by mmartin on 10/22/17.
 */
@Singleton
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(NetworkModule::class, DataRepositoryModule::class))
interface RepositoryComponent {
    fun getFilmsRepository(): FilmsRepository
}