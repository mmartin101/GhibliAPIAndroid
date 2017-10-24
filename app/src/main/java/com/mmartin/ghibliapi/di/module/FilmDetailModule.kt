package com.mmartin.ghibliapi.di.module

import com.mmartin.ghibliapi.data.GhibliFilmsRepository
import com.mmartin.ghibliapi.film.detail.FilmDetailPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by mmartin on 10/12/17.
 */
@Module
class FilmDetailModule {

    @Provides
    fun providePresenter(dataRepository: GhibliFilmsRepository) = FilmDetailPresenter(dataRepository)
}