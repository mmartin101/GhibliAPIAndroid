package com.mmartin.ghibliapi.film

import com.mmartin.ghibliapi.data.GhibliFilmsDataSource
import com.mmartin.ghibliapi.data.GhibliFilmsRepository
import javax.inject.Inject

/**
 * Created by mmartin on 10/13/17.
 */
class FilmsPresenter : FilmsContract.Presenter {
    internal var view: FilmsContract.View? = null
    lateinit internal var dataRepository: GhibliFilmsRepository

    @Inject
    constructor(dataRepository: GhibliFilmsRepository) {
        this.dataRepository = dataRepository
    }

    override fun start() {
        loadFilms()
    }

    override fun setView(view: FilmsContract.View?) {
        this.view = view
    }

    override fun loadFilms() {
    }

}