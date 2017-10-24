package com.mmartin.ghibliapi.di.component

import com.mmartin.ghibliapi.data.GhibliFilmsRepository
import com.mmartin.ghibliapi.data.GhibliFilmsRepositoryModule
import com.mmartin.ghibliapi.di.module.ApplicationModule
import dagger.Component

/**
 * Created by mmartin on 10/22/17.
 */
@Component(dependencies = arrayOf(AppComponent::class, NetworkComponent::class), modules = arrayOf(GhibliFilmsRepositoryModule::class))
interface RepositoryComponent {
    fun getRepository(): GhibliFilmsRepository
}