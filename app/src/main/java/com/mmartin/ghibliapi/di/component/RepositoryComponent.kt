package com.mmartin.ghibliapi.di.component

import com.mmartin.ghibliapi.data.DataRepositoryModule
import com.mmartin.ghibliapi.data.FilmsRepository
import com.mmartin.ghibliapi.di.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by mmartin on 10/22/17.
 */
@Singleton
@Component(dependencies = [(AppComponent::class)], modules = [(NetworkModule::class), (DataRepositoryModule::class)])
interface RepositoryComponent {
    fun getFilmsRepository(): FilmsRepository
}