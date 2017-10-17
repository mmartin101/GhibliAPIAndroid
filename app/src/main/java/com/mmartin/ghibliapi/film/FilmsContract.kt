package com.mmartin.ghibliapi.film

import com.mmartin.ghibliapi.BasePresenter
import com.mmartin.ghibliapi.BaseView

/**
 * Created by mmartin on 10/13/17.
 */
interface FilmsContract {
    interface View : BaseView {
        fun showFilms(filmList: List<Film>)
    }

    interface Presenter : BasePresenter<View> {
        fun loadFilms()
    }
}