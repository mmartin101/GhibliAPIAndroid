package com.mmartin.ghibliapi.film.detail;

import com.mmartin.ghibliapi.data.GhibliFilmsRepository;
import com.mmartin.ghibliapi.film.Film;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by mmartin on 8/12/17.
 */

public class FilmDetailPresenter implements FilmDetailContract.Presenter {
    FilmDetailContract.View view;
    GhibliFilmsRepository dataRepository;
    String filmId;

    @Inject
    public FilmDetailPresenter(GhibliFilmsRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public void start() {
        loadFilm();
    }

    public void loadFilm() {
        if (filmId == null) {
            view.showMissingFilm();
            return;
        }

        dataRepository.getFilm(filmId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        this::showFilm,
                        (foo) -> {
                            Timber.e(foo);
                            view.showMissingFilm();
                        });
    }

    private void showFilm(Film film) {
        if (film.getTitle() != null) {
            view.showTitle(film.getTitle());
        }

        if (film.getDescription() != null) {
            view.showTitle(film.getDescription());
        }

        if (film.getDirector() != null) {
            view.showTitle(film.getDirector());
        }
    }

    @Override
    public void setView(FilmDetailContract.View view) {
        this.view = view;
    }

    @Override
    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }


}
