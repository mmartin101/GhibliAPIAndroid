package com.mmartin.ghibliapi.people;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Ghibli People API
 * <p>
 * Created by mmartin on 5/24/17.
 */

public interface GhibliPeopleService {
    @GET("people")
    Call<List<Person>> getPeople();

    @GET("people/{id}")
    Call<Person> getPeopleById(@Path("id") String personId);
}
