package com.mmartin.ghibliapi.data;

import android.support.annotation.NonNull;

import com.mmartin.ghibliapi.App;
import com.mmartin.ghibliapi.film.Film;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import okio.Buffer;
import timber.log.Timber;

/**
 * Concrete implementation for getting data from the Ghibli API
 * <p>
 * Created by mmartin on 9/12/17.
 */
public class FakeFilmsRemoteDataSource extends GhibliFilmsDataSource {
    App app;
    Moshi moshi = new Moshi.Builder().build();

    @Inject
    public FakeFilmsRemoteDataSource(@NonNull App app) {
        this.app = app;

    }

    @Override
    public Observable<List<Film>> getFilms() {
        try {
            InputStream inputStream = app.getAssets().open("json/films.json");
            Type type = Types.newParameterizedType(List.class, Film.class);
            JsonAdapter<List<Film>> jsonAdapter = moshi.adapter(type);
            List<Film> films = jsonAdapter.fromJson(new Buffer().readFrom(inputStream));
            return Observable.just(films);
        } catch (IOException e) {
            Timber.e(e, "error reading file");
        }

        return Observable.empty();
    }

    @Override
    public Observable<Film> getFilm(@NonNull String id) {
        return Observable.empty();
    }
}
