package com.mmartin.ghibliapi.network;

import com.mmartin.ghibliapi.film.Film;

import java.util.List;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Ghibli Films API
 * <p>
 * Created by mmartin on 4/10/17.
 */

public interface GhibliFilmService {
    @GET("films")
    Observable<List<Film>> getFilms();

    @GET("films/{id}")
    Observable<Film> getFilmById(@Path("id") String filmId);
}
