package com.mmartin.ghibliapi.film

import com.mmartin.ghibliapi.data.GhibliFilmsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 * Presenter for any view that shows multiple Films
 *
 * Created by mmartin on 10/13/17.
 */
class FilmsPresenter(repository: GhibliFilmsRepository) : FilmsContract.Presenter {
    private var view: FilmsContract.View? = null
    private var dataRepository: GhibliFilmsRepository = repository

    override fun start() {
        loadFilms()
    }

    override fun attachView(view: FilmsContract.View) {
        this.view = view
    }

    override fun loadFilms() {
        dataRepository.films
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view?.showFilms(it)
                }, {
                    Timber.e(it)
                    view?.showError()
                })
    }

}