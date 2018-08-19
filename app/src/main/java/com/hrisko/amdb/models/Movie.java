package com.hrisko.amdb.models;

public class Movie {
    public String id;
    public String cast;
    public String director;
    public float imdbRating;
    public int metascore;
    public String storyline;
    public String title_eng;
    public int year;

    public Movie() {
        //Required empty constructor.
    }

    public Movie( String cast, String director, float imdbRating, int metascore, String storyline, String title_eng, int year) {
        this.cast = cast;
        this.director = director;
        this.imdbRating = imdbRating;
        this.metascore = metascore;
        this.storyline = storyline;
        this.title_eng = title_eng;
        this.year = year;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public float getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(float imdbRating) {
        this.imdbRating = imdbRating;
    }

    public int getMetascore() {
        return metascore;
    }

    public void setMetascore(int metascore) {
        this.metascore = metascore;
    }

    public String getStoryline() {
        return storyline;
    }

    public void setStoryline(String storyline) {
        this.storyline = storyline;
    }

    public String getTitle_eng() {
        return title_eng;
    }

    public void setTitle_eng(String title_eng) {
        this.title_eng = title_eng;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return title_eng + " (" + year + ")";
    }
}
