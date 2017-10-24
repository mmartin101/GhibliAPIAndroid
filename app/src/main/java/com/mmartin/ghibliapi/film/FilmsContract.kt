package com.mmartin.ghibliapi.film

import com.mmartin.ghibliapi.BasePresenter
import com.mmartin.ghibliapi.BaseView

interface FilmsContract {
    interface View : BaseView {
        fun showFilms(filmList: List<Film>)
        fun showError()
    }

    interface Presenter : BasePresenter<View> {
        fun loadFilms()
    }
}