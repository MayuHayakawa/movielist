package com.group1.movielist_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.group1.movielist_app.dao.MovieRepository;
import com.group1.movielist_app.entity.Movie;


public class HomeController {
    
    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {
        List<Movie> movies = movieRepository.findAll();

        model.addAttribute("movies", movies);

        return "home/index";
    }

}
