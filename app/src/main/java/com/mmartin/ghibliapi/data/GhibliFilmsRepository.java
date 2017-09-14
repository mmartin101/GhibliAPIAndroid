package com.mmartin.ghibliapi.data;

import android.support.annotation.NonNull;

/**
 * The concrete implementation for accessing Film data from remote or local sources
 * <p>
 * Created by mmartin on 9/12/17.
 */

public class GhibliFilmsRepository implements GhibliFilmsDataSource {
    private final GhibliFilmsDataSource remoteDataSource;
    private final GhibliFilmsDataSource localDataSource;

    public GhibliFilmsRepository(@NonNull GhibliFilmsDataSource remoteDataSource, @NonNull GhibliFilmsDataSource localDataSource) {
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
