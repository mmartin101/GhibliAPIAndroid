package com.mmartin.ghibliapi.film.detail

import com.mmartin.ghibliapi.data.GhibliFilmsRepository
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