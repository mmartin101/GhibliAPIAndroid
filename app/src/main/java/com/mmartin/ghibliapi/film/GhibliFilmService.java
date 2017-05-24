package com.mmartin.ghibliapi.film;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Ghibli Films API
 * <p>
 * Created by mmartin on 4/10/17.
 */

public interface GhibliFilmService {
    @GET("films")
    Call<List<Film>> getFilms();

    @GET("films/{id}")
    Call<Film> getFilmById(@Path("id") String filmId);
}
