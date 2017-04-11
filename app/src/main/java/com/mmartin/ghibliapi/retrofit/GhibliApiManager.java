package com.mmartin.ghibliapi.retrofit;

import com.mmartin.ghibliapi.film.GhibliFilmService;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Created by mmartin on 4/10/17.
 */

public class GhibliApiManager {
    private static GhibliApiManager instance;

    private Retrofit retrofit;

    public static GhibliApiManager getInstance() {
        if (instance == null) {
            instance = new GhibliApiManager();
        }

        return instance;
    }

    private GhibliApiManager() {
        retrofit = new Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create()).baseUrl("https://ghibliapi.herokuapp.com/").build();
    }

    public GhibliFilmService getFilmService() {
        return retrofit.create(GhibliFilmService.class);
    }
}
