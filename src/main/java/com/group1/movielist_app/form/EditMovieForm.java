package com.group1.movielist_app.form;

import lombok.Data;

@Data
public class EditMovieForm {
    
    private long movieId;
    private String movieImg;
    private String movieTitle;
    private String movieGenre;
    private String movieActor;
    private String movieDescription;
    private String movieRating;
    
}
