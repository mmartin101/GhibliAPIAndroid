package com.mmartin.ghibliapi.data;

import android.support.annotation.NonNull;

import com.mmartin.ghibliapi.film.Film;
import com.mmartin.ghibliapi.retrofit.GhibliApiManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Concrete implementation for getting data from the Ghibli API
 * <p>
 * Created by mmartin on 9/12/17.
 */

public class GhibliFilmsRemoteDataSource implements GhibliFilmsDataSource {
    @Override
    public void getFilms(@NonNull final LoadFilmsCallback callback) {
        GhibliApiManager.getInstance().getFilmService().getFilms().enqueue(new retrofit2.Callback<List<Film>>() {
            @Override
            public void onResponse(@NonNull Call<List<Film>> call, @NonNull Response<List<Film>> response) {
                callback.onFilmsLoaded(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<Film>> call, @NonNull Throwable t) {
                Timber.e(t);
                callback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void getFilm(@NonNull String id, @NonNull final LoadFilmCallback callback) {
        GhibliApiManager.getInstance().getFilmService().getFilmById(id).enqueue(new retrofit2.Callback<Film>() {
            @Override
            public void onResponse(@NonNull Call<Film> call, @NonNull Response<Film> response) {
                callback.onFilmLoaded(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<Film> call, @NonNull Throwable t) {
                Timber.e(t);
                callback.onDataNotAvailable();
            }
        });
    }
}
