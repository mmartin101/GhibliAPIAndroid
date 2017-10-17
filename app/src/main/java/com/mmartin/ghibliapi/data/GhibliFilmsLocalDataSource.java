package com.mmartin.ghibliapi.data;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by mmartin on 10/11/17.
 */
@Singleton
public class GhibliFilmsLocalDataSource implements GhibliFilmsDataSource {

    @Inject public GhibliFilmsLocalDataSource(Context context) {

    }

    @Override
    public void getFilms(@NonNull LoadFilmsCallback callback) {

    }

    @Override
    public void getFilm(@NonNull String id, @NonNull LoadFilmCallback callback) {

    }
}
