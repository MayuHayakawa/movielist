package com.group1.movielist_app.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.group1.movielist_app.dao.MovieListRepository;
import com.group1.movielist_app.dao.MovieRepository;
import com.group1.movielist_app.dao.UserRepository;
import com.group1.movielist_app.entity.Movie;
import com.group1.movielist_app.entity.MovieList;
import com.group1.movielist_app.entity.User;

@ControllerAdvice
@RequestMapping("/movie")
public class EditMovieListController {
    
    @Autowired
    UserRepository userRepositry;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MovieListRepository movieListRepository;

    public String displayMovieList(Model model, HttpSession session) throws JsonProcessingException {
        Long userId = (Long) session.getAttribute(SessionConstants.APP_USERID);
        Optional<User> user = userId == null ? Optional.empty() : userRepositry.findById(userId);
        List<MovieList> movieLists = user.get().getMovielists();
        model.addAttribute("movieLists", movieLists);

        return "movielist/select";
    }

    @GetMapping("/new")
    public String displayMovieForm(Model model, HttpSession session) throws JsonProcessingException{
        model.addAttribute("movie", new Movie());
        
        // Display only movie list of logged-in users
        Long userId = (Long) session.getAttribute(SessionConstants.APP_USERID);
        Optional<User> user = userId == null ? Optional.empty() : userRepositry.findById(userId);
        List<MovieList> movieLists = user.get().getMovielists();
        model.addAttribute("movieLists", movieLists);

        return "movie/new-movie";
    }

    @PostMapping("/save")
    public String createMovie(Movie movie) {
        movieRepository.save(movie);
        return "redirect:/movie/new";
    }
    
}
