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
import javax.persistence.ManyToOne;
// import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class MovieList {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    // @SequenceGenerator(name = "movielist_seq")
    private long movieListId;

    private String movieListName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "movielist_info", joinColumns = @JoinColumn(name = "movieListId"), inverseJoinColumns = @JoinColumn(name = "movieId"))
    private List<Movie> movies;

    @Override
    public String toString() {
        return movieListName;
    }

}
