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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class MovieList {

    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "project_sequence")
    private long movieListId;

    private String movieListName;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
        name = "movielistinfo",
        joinColumns = @JoinColumn(name="movieListId"),
        inverseJoinColumns = @JoinColumn(name="movieId")
    )
    List<MovieList> movieLists;

    public MovieList() {
    }

    


}
