package com.mmartin.ghibliapi.film.detail

import com.mmartin.ghibliapi.BasePresenter
import com.mmartin.ghibliapi.BaseView

/**
 * Contract interfaces for film detail presenter and view
 *
 * Created by mmartin on 8/12/17.
 */

interface FilmDetailContract {
    interface View : BaseView {
        fun showMissingFilm()
        fun showTitle(title: String)
        fun showDescription(description: String)
        fun showDirector(director: String)
        fun showProducer(producer: String)
        fun showPeople(people: List<Pair<String, String>>)
    }

    interface Presenter : BasePresenter<View>
}
