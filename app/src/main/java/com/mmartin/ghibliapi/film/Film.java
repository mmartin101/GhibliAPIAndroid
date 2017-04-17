package com.mmartin.ghibliapi.film;

import android.os.Parcel;
import android.os.Parcelable;

import com.squareup.moshi.Json;

import java.util.List;

/**
 * Model for Film objects
 * <p>
 * Created by mmartin on 4/10/17.
 */

public class Film implements Parcelable {
    private String id;
    private String title;
    private String description;
    private String director;
    private String producer;
    @Json(name = "release_date")
    private String releaseDate;
    private Integer rtScore;
    private String url;

    private List<String> people;
    private List<String> species;
    private List<String> locations;
    private List<String> vehicles;

    protected Film(Parcel in) {
        id = in.readString();
        title = in.readString();
        description = in.readString();
        director = in.readString();
        producer = in.readString();
        releaseDate = in.readString();
        url = in.readString();
        people = in.createStringArrayList();
        species = in.createStringArrayList();
        locations = in.createStringArrayList();
        vehicles = in.createStringArrayList();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(director);
        dest.writeString(producer);
        dest.writeString(releaseDate);
        dest.writeString(url);
        dest.writeStringList(people);
        dest.writeStringList(species);
        dest.writeStringList(locations);
        dest.writeStringList(vehicles);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Film> CREATOR = new Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel in) {
            return new Film(in);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getRtScore() {
        return rtScore;
    }

    public void setRtScore(Integer rtScore) {
        this.rtScore = rtScore;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getPeople() {
        return people;
    }

    public void setPeople(List<String> people) {
        this.people = people;
    }

    public List<String> getSpecies() {
        return species;
    }

    public void setSpecies(List<String> species) {
        this.species = species;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public List<String> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<String> vehicles) {
        this.vehicles = vehicles;
    }
}
