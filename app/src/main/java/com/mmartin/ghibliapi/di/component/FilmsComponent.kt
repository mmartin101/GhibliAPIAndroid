package com.mmartin.ghibliapi.di.component

import com.mmartin.ghibliapi.di.module.FilmsModule
import com.mmartin.ghibliapi.film.FilmsActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by mmartin on 10/21/17.
 */
@Singleton
@Component(dependencies = arrayOf(RepositoryComponent::class), modules = arrayOf(FilmsModule::class))
interface FilmsComponent {
    fun inject(view: FilmsActivity)
}