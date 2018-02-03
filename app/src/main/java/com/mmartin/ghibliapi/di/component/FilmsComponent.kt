package com.mmartin.ghibliapi.di.component

import com.mmartin.ghibliapi.di.Activity
import com.mmartin.ghibliapi.di.module.FilmsModule
import com.mmartin.ghibliapi.film.FilmsActivity
import dagger.Component

/**
 * Created by mmartin on 10/21/17.
 */
@Activity
@Component(dependencies = [(RepositoryComponent::class)], modules = [(FilmsModule::class)])
interface FilmsComponent {
    fun inject(view: FilmsActivity)
}