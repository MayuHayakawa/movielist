package com.group1.movielist_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group1.movielist_app.dao.MovieListRepository;
import com.group1.movielist_app.dao.MovieRepository;
import com.group1.movielist_app.entity.Movie;
import com.group1.movielist_app.entity.MovieList;


@Controller
@RequestMapping("/movie")
public class EditMovieListController {

    @Autowired
    MovieListRepository movieListRepository;

    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/new")
    public String displayMovieForm(Model model) {
        // for (MovieList movie : movieLists) {
        //     System.out.println(movie.getMovieListName());
        // }
        model.addAttribute("movie", new Movie());

        List<MovieList> movieLists = movieListRepository.findAll();
        model.addAttribute("movieLists", movieLists);

        return "movie/new-movie";
    }

    @PostMapping("/save")
    public String createMovie(Movie movie, Model model) {
        movieRepository.save(movie);
        return "redirect:/movie/new";
    }
    
}
