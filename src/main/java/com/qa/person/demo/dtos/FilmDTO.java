package com.qa.person.demo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

// Class to represent the film data from the API
public class FilmDTO {

    private String imdbID;

    //dodgy API uses PascalCase for fields so I've had to add some config to let the Jackson library process it
    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private String year;

    @JsonProperty("Rated")
    private String rated;

    public FilmDTO() {
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }
}
