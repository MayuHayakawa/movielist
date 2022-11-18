package com.group1.movielist_app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
// import javax.persistence.SequenceGenerator;
import javax.persistence.OneToMany;

@Entity
public class MovieList {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    // @SequenceGenerator(name = "movielist_seq")
    private long movieListId;

    private String movieListName;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy = "movielist", cascade = CascadeType.ALL)
    private List<Movie> movies = new ArrayList<>();


    public MovieList() {
    }

    public MovieList(String movieListName) {
        this.movieListName = movieListName;
    }


    public long getMovieListId() {
        return movieListId;
    }

    public void setMovieListId(long movieListId) {
        this.movieListId = movieListId;
    }

    public String getMovieListName() {
        return movieListName;
    }

    public void setMovieListName(String movieListName) {
        this.movieListName = movieListName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
