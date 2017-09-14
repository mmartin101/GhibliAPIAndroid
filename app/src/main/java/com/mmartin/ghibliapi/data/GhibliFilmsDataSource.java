package com.mmartin.ghibliapi.data;

import android.support.annotation.NonNull;

import com.mmartin.ghibliapi.film.Film;

import java.util.List;

/**
 * Main entry point for accessing film data
 * <p>
 * Created by mmartin on 8/12/17.
 */

public interface GhibliFilmsDataSource {
    void getFilms(@NonNull LoadFilmsCallback callback);

    void getFilm(@NonNull String id, @NonNull LoadFilmCallback callback);

    interface Callback {
        void onDataNotAvailable();
    }

    interface LoadFilmsCallback extends Callback {
        void onFilmsLoaded(List<Film> data);
    }

    interface LoadFilmCallback extends Callback {
        void onFilmLoaded(Film film);
    }
}
