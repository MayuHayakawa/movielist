package com.group1.movielist_app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
// import javax.persistence.SequenceGenerator;
import javax.persistence.ManyToOne;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    // @SequenceGenerator(name = "movie_sequence")
    private long movieId;
    
    private String movieImg;
    private String movieTitle;
    private String movieGenre; //A,B,C
    private String movieActor;
    private String movieDescription;
    private String movieRating; //1,2,3

    @ManyToOne
    @JoinColumn(name="movielist_id")
    private MovieList movielist;

    public Movie() {
    }

    public Movie(String movieImg, String movieTitle, String movieGenre, String movieActor, String movieDescription,
            String movieRating) {
        this.movieImg = movieImg;
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

    public String getMovieImg() {
        return movieImg;
    }

    public void setMovieImg(String movieImg) {
        this.movieImg = movieImg;
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

    public String getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }

    public MovieList getMovielist() {
        return movielist;
    }

    public void setMovielist(MovieList movielist) {
        this.movielist = movielist;
    }

}
