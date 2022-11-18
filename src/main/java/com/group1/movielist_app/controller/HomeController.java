package com.group1.movielist_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.group1.movielist_app.dao.MovieListRepository;
import com.group1.movielist_app.dao.MovieRepository;
import com.group1.movielist_app.dao.UserRepositry;
import com.group1.movielist_app.entity.Movie;
import com.group1.movielist_app.entity.MovieList;
import com.group1.movielist_app.entity.User;

@Controller
public class HomeController {
    
    @Autowired
    UserRepositry userRepositry;

    @Autowired
    MovieListRepository movieListRepository;

    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {
        List<User> users =  userRepositry.findAll();
        List<MovieList> movieLists = movieListRepository.findAll();
        List<Movie> movies = movieRepository.findAll();

        model.addAttribute("user", users);
        model.addAttribute("movieList", movieLists);
        model.addAttribute("movie", movies);

        return "home/index";
    }

}
