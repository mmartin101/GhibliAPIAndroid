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

public interface GhibliFilmsDataSource {
    Observable<List<Film>> getFilms();

    Observable<Film> getFilm(@NonNull String id);

    void storeFilms(List<Film> films);
    void storeFilm(Film film);
}
