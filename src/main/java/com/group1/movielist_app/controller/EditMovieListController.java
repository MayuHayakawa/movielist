package com.group1.movielist_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group1.movielist_app.dao.MovieRepository;
import com.group1.movielist_app.entity.Movie;


@Controller
@RequestMapping("/movie")
public class EditMovieListController {

    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/new")
    public String displayMovieForm(Model model) {
        model.addAttribute("movie", new Movie());

        return "movie/movie";
    }

    @PostMapping("/save")
    public String editMovie(Movie movie, Model model) {
        movieRepository.save(movie);
        
        return "redirect:/movie/new";
    }
    
}
