package com.group1.movielist_app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group1.movielist_app.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAll();

}
