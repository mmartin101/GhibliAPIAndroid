package com.mmartin.ghibliapi.di.component

import com.mmartin.ghibliapi.data.GhibliFilmsRepository
import com.mmartin.ghibliapi.data.GhibliFilmsRepositoryModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by mmartin on 10/22/17.
 */
@Singleton
@Component(dependencies = arrayOf(AppComponent::class, NetworkComponent::class), modules = arrayOf(GhibliFilmsRepositoryModule::class))
interface RepositoryComponent {
    fun getRepository(): GhibliFilmsRepository
}