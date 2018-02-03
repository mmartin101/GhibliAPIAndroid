package com.mmartin.ghibliapi.film

import com.mmartin.ghibliapi.BasePresenter
import com.mmartin.ghibliapi.BaseView
import com.mmartin.ghibliapi.data.model.Film

interface FilmsContract {
    interface View : BaseView {
        fun showFilms(filmList: List<Film>)
        fun showError()
    }

    interface Presenter : BasePresenter<View> {
        fun loadFilms()
    }
}