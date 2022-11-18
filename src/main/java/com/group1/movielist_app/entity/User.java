package com.group1.movielist_app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
// import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    // @SequenceGenerator(name = "user_sequence")
    private long userId;

    private String email;
    private String fullName;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<MovieList> movielists = new ArrayList<>();


    public User() {
    }

    public User(String email, String fullName, String password) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
    }

    
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<MovieList> getMovielists() {
        return movielists;
    }

    public void setMovielists(List<MovieList> movielists) {
        this.movielists = movielists;
    }

}
