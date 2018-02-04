package com.mmartin.ghibliapi.film

import com.mmartin.ghibliapi.data.FilmsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 * Presenter for any view that shows multiple Films
 *
 * Created by mmartin on 10/13/17.
 */
class FilmsPresenter(repository: FilmsRepository) : FilmsContract.Presenter {
    private var view: FilmsContract.View? = null
    private var dataRepository: FilmsRepository = repository

    override fun start() {
        loadFilms()
    }

    override fun attachView(view: FilmsContract.View) {
        this.view = view
    }

    override fun loadFilms() {
        dataRepository.allItems
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