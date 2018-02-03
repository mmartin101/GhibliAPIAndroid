package com.mmartin.ghibliapi.data;

import android.support.annotation.NonNull;

import com.mmartin.ghibliapi.data.model.Film;
import com.mmartin.ghibliapi.network.GhibliApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Concrete implementation for getting data from the Ghibli API
 * <p>
 * Created by mmartin on 9/12/17.
 */
public class FilmsRemoteDataSource extends FilmsDataSource {
    GhibliApi api;

    @Inject
    public FilmsRemoteDataSource(@NonNull GhibliApi api) {
        this.api = api;
    }

    @Override
    public Observable<List<Film>> getFilms() {
        return api.getFilmService().getFilms();
    }

    @Override
    public Observable<Film> getFilm(@NonNull String id) {
        return api.getFilmService().getFilmById(id);
    }
}
