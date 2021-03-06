package com.mmartin.ghibliapi.film.detail

import com.mmartin.ghibliapi.data.FilmsRepository
import com.mmartin.ghibliapi.data.PeopleRepository
import com.mmartin.ghibliapi.data.model.Film
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * Presenter for the film detail screen
 *
 * Created by mmartin on 8/12/17.
 */

class FilmDetailPresenter @Inject
constructor(private val filmsRepository: FilmsRepository,
            private val peopleRepository: PeopleRepository) : FilmDetailContract.Presenter {
    var view: FilmDetailContract.View? = null
    var filmId: String? = null

    override fun start() {
        loadFilm()
    }

    private fun loadFilm() {
        filmId?.let {
            filmsRepository.getItem(it)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        this.showFilm(it)
                    }, { foo ->
                        Timber.e(foo)
                        view?.showMissingFilm()
                    })
        } ?: view?.showMissingFilm()
    }

    private fun showFilm(film: Film) {
        film.title?.let {
            view?.showTitle(it)
        }

        film.description?.let {
            view?.showDescription(it)
        }

        film.director?.let {
            view?.showDirector(it)
        }

        film.people?.let {
            peopleRepository.allItems
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .map { it.map { Pair(it.id, it.name!!) } }
                    .subscribe({ view?.showPeople(it) }, { Timber.d(it) })
        }
    }

    override fun attachView(view: FilmDetailContract.View) {
        this.view = view
    }
}
