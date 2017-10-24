package com.mmartin.ghibliapi.data;

import android.support.annotation.NonNull;

import com.mmartin.ghibliapi.App;
import com.mmartin.ghibliapi.film.Film;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Film repo for Films stored in local storage
 * <p>
 * Created by mmartin on 10/11/17.
 */
public class GhibliFilmsLocalDataSource implements GhibliFilmsDataSource {
    private Map<String, Film> filmMap;

    @Inject
    public GhibliFilmsLocalDataSource(App app) {
        filmMap = new HashMap<>();
    }

    @Override
    public Observable<List<Film>> getFilms() {
        if (filmMap.isEmpty()) {
            return null;
        }

        return Observable.just(new ArrayList<>(filmMap.values()));
    }

    @Override
    public Observable<Film> getFilm(@NonNull String id) {
        if (filmMap.containsKey(id)) {
            return Observable.just(filmMap.get(id));
        }

        return null;
    }

    @Override
    public void storeFilms(List<Film> films) {
        for (Film f : films) {
            filmMap.put(f.getId(), f);
        }
    }

    @Override
    public void storeFilm(Film film) {
        filmMap.put(film.getId(), film);
    }
}
