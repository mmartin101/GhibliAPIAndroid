package com.mmartin.ghibliapi.data;

import android.support.annotation.NonNull;

import com.mmartin.ghibliapi.film.Film;

import java.util.List;

import io.reactivex.Observable;

/**
 * Main entry point for accessing film data
 * <p>
 * Created by mmartin on 8/12/17.
 */

public abstract class GhibliFilmsDataSource {
    boolean isEmpty() {
        return false;
    }

    public abstract Observable<List<Film>> getFilms();

    public abstract Observable<Film> getFilm(@NonNull String id);

    void storeFilms(List<Film> films) {
    }

    void storeFilm(Film film) {
    }
}
