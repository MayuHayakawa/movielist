package com.group1.movielist_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.group1.movielist_app.dao.MovieRepository;
import com.group1.movielist_app.entity.Movie;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public class EditMovieListController {

    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/new")
    public String displayMovieList(Model model) {
        model.addAttribute("movie", new Movie());
        List<Movie> movies = movieRepository.findAll();
        return "movie/new-movie";
    }

    @PostMapping("/create")
    public String createMovie(Movie movie, Model model) {
        movieRepository.save(movie);
        return "redirect:/movie/new";
    }
    
    
}
