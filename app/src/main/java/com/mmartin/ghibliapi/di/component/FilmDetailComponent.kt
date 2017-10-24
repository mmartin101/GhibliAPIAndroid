package com.mmartin.ghibliapi.di.component

import com.mmartin.ghibliapi.film.detail.FilmDetailContract
import dagger.Component

/**
 * Created by mmartin on 10/21/17.
 */
@Component
interface FilmDetailComponent {
    fun inject(view: FilmDetailContract.View)
}