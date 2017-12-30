package com.mmartin.ghibliapi.di.component

import com.mmartin.ghibliapi.di.Activity
import com.mmartin.ghibliapi.di.module.FilmDetailModule
import com.mmartin.ghibliapi.film.detail.FilmDetailActivity
import dagger.Component

/**
 * Created by mmartin on 10/21/17.
 */
@Activity
@Component(dependencies = arrayOf(RepositoryComponent::class), modules = arrayOf(FilmDetailModule::class))
interface FilmDetailComponent {
    fun inject(view: FilmDetailActivity)
}