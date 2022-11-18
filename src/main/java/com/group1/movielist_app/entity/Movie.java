package com.group1.movielist_app.entity;

import javax.persistence.Entity;

@Entity
public class Movie {

    private long movieId;
    private String movieTitle;
    private String movieGenre;
    private String movieActor;
    private String movieDescription;
    private int movieRating;

    public Movie() {
    }

    public Movie(String movieTitle, String movieGenre, String movieActor, String movieDescription, int movieRating) {
        this.movieTitle = movieTitle;
        this.movieGenre = movieGenre;
        this.movieActor = movieActor;
        this.movieDescription = movieDescription;
        this.movieRating = movieRating;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public String getMovieActor() {
        return movieActor;
    }

    public void setMovieActor(String movieActor) {
        this.movieActor = movieActor;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public int getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(int movieRating) {
        this.movieRating = movieRating;
    }
    
}
