package com.group1.movielist_app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
// import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
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

    @ManyToMany(
        cascade=CascadeType.ALL,
        fetch=FetchType.LAZY
    )
    @JoinTable(
        name="movielist_info",
        joinColumns = @JoinColumn(name="movieId"),
        inverseJoinColumns = @JoinColumn(name="movieListId")
        )
    private List<MovieList> movielist;

}
