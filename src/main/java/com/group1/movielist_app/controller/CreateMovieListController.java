package com.group1.movielist_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group1.movielist_app.dao.MovieListRepository;
import com.group1.movielist_app.entity.MovieList;

@Controller
@RequestMapping("/movielist")
public class CreateMovieListController {

    @Autowired
    MovieListRepository movieListRepository;

    @GetMapping("/new")
    public String displayMovieListForm(Model model) {
        model.addAttribute("movieList", new MovieList());
        return "movielist/new-movielist";
    }

    @PostMapping("/save")
    public String createMovieList(MovieList movieList, Model model) {
        movieListRepository.save(movieList);
        return "redirect:/movielist/new";
    }
    
}
