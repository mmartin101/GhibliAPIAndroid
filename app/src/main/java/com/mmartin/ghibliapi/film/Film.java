package com.mmartin.ghibliapi.film;

import com.squareup.moshi.Json;

import java.util.List;

/**
 * Model for Film objects
 * <p>
 * Created by mmartin on 4/10/17.
 */

public class Film {
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
