package com.group1.movielist_app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group1.movielist_app.entity.MovieList;

public interface MovieListRepository extends JpaRepository<MovieList, Long>{
    
    List<MovieList> findAll();

}
