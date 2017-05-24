package com.mmartin.ghibliapi.people;

import android.os.Parcel;
import android.os.Parcelable;

import com.squareup.moshi.Json;

import java.util.List;

/**
 * Model for People objects
 * <p>
 * Created by mmartin on 5/24/17.
 */

public class Person implements Parcelable {
    private String id;
    private String name;
    private String gender;
    private String age;
    @Json(name = "eye_color")
    private String eyeColor;
    @Json(name = "hair_color")
    private String hairColor;
    private String url;
    private String species;

    private List<String> films;

    protected Person(Parcel in) {
        id = in.readString();
        name = in.readString();
        gender = in.readString();
        age = in.readString();
        eyeColor = in.readString();
        hairColor = in.readString();
        url = in.readString();
        species = in.readString();
        films = in.createStringArrayList();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(gender);
        dest.writeString(age);
        dest.writeString(eyeColor);
        dest.writeString(hairColor);
        dest.writeString(url);
        dest.writeString(species);
        dest.writeStringList(films);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }
}
