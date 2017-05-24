package com.mmartin.ghibliapi.retrofit;

import com.mmartin.ghibliapi.film.GhibliFilmService;
import com.mmartin.ghibliapi.people.GhibliPeopleService;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Created by mmartin on 4/10/17.
 */

public class GhibliApiManager {
    public static String API_URL = "https://ghibliapi.herokuapp.com/";
    private static GhibliApiManager instance;

    private Retrofit retrofit;

    private GhibliApiManager() {
        retrofit = new Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create()).baseUrl(API_URL).build();
    }

    public static GhibliApiManager getInstance() {
        if (instance == null) {
            instance = new GhibliApiManager();
        }

        return instance;
    }

    public GhibliFilmService getFilmService() {
        return retrofit.create(GhibliFilmService.class);
    }

    public GhibliPeopleService getPeopleService() {
        return retrofit.create(GhibliPeopleService.class);
    }
}
