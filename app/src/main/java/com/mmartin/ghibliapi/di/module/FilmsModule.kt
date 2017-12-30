package com.mmartin.ghibliapi.di.module

import com.mmartin.ghibliapi.data.FilmsRepository
import com.mmartin.ghibliapi.film.FilmsPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by mmartin on 10/21/17.
 */
@Module
class FilmsModule {

    @Provides
    fun provideFilmsPresenter(repository: FilmsRepository): FilmsPresenter = FilmsPresenter(repository)
}