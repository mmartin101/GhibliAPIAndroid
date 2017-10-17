package com.mmartin.ghibliapi.film.detail;

import com.mmartin.ghibliapi.data.GhibliFilmsDataSource;
import com.mmartin.ghibliapi.data.GhibliFilmsRepository;
import com.mmartin.ghibliapi.film.Film;

import javax.inject.Inject;

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

        dataRepository.getFilm(filmId, new GhibliFilmsDataSource.LoadFilmCallback() {
            @Override
            public void onFilmLoaded(Film film) {
                showFilm(film);
            }

            @Override
            public void onDataNotAvailable() {
                view.showMissingFilm();
            }
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
