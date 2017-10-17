package com.mmartin.ghibliapi.network;

import com.mmartin.ghibliapi.people.GhibliPeopleService;

import javax.inject.Singleton;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Created by mmartin on 4/10/17.
 */
@Singleton
public class GhibliApi {
    public static String API_URL = "https://ghibliapi.herokuapp.com/";

    private Retrofit retrofit;

    public GhibliApi() {
        retrofit = new Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create()).baseUrl(API_URL).build();
    }

    public GhibliFilmService getFilmService() {
        return retrofit.create(GhibliFilmService.class);
    }

    public GhibliPeopleService getPeopleService() {
        return retrofit.create(GhibliPeopleService.class);
    }
}
