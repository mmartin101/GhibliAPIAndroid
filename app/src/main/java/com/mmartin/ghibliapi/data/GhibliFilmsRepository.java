package com.mmartin.ghibliapi.data;

import android.support.annotation.NonNull;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * The concrete implementation for accessing Film data from remote or local sources
 * <p>
 * Created by mmartin on 9/12/17.
 */
@Singleton
public class GhibliFilmsRepository implements GhibliFilmsDataSource {
    private final GhibliFilmsDataSource remoteDataSource;
    private final GhibliFilmsDataSource localDataSource;

    @Inject
    public GhibliFilmsRepository(@Remote GhibliFilmsDataSource remoteDataSource, @Local GhibliFilmsDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    @Override
    public void getFilms(@NonNull LoadFilmsCallback callback) {
        remoteDataSource.getFilms(callback);
    }

    @Override
    public void getFilm(@NonNull String id, @NonNull LoadFilmCallback callback) {
        remoteDataSource.getFilm(id, callback);
    }
}
