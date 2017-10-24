package com.mmartin.ghibliapi.data;

import android.support.annotation.NonNull;

import com.mmartin.ghibliapi.di.Local;
import com.mmartin.ghibliapi.di.Remote;
import com.mmartin.ghibliapi.film.Film;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * The concrete implementation for accessing Film data from remote or local sources
 * <p>
 * Created by mmartin on 9/12/17.
 */
@Singleton
public class GhibliFilmsRepository implements GhibliFilmsDataSource {
    GhibliFilmsDataSource remoteDataSource;
    GhibliFilmsDataSource localDataSource;

    @Inject
    public GhibliFilmsRepository(@Remote GhibliFilmsDataSource remoteDataSource, @Local GhibliFilmsDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    @Override
    public Observable<List<Film>> getFilms() {
        if (localDataSource.getFilms() != null) {
            return localDataSource.getFilms();
        }

        return remoteDataSource.getFilms();
    }

    @Override
    public Observable<Film> getFilm(@NonNull String id) {
        if (localDataSource.getFilm(id) != null) {
            return localDataSource.getFilm(id);
        }

        return remoteDataSource.getFilm(id);
    }

    @Override
    public void storeFilms(List<Film> films) {
        // nada
    }

    @Override
    public void storeFilm(Film film) {
        // nada
    }
}
