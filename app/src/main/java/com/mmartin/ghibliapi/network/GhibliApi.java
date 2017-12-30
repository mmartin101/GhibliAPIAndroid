package com.mmartin.ghibliapi.network;

import javax.inject.Singleton;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Created by mmartin on 4/10/17.
 */
@Singleton
public class GhibliApi {
    public static String API_URL = "https://ghibliapi.herokuapp.com/";

    private Retrofit retrofit;

    public GhibliApi() {
        retrofit = new Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(API_URL)
                .build();
    }

    public FilmService getFilmService() {
        return retrofit.create(FilmService.class);
    }

    public PeopleService getPeopleService() {
        return retrofit.create(PeopleService.class);
    }
}
