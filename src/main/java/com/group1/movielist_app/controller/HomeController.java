package com.group1.movielist_app.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.group1.movielist_app.dao.MovieListRepository;
import com.group1.movielist_app.dao.MovieRepository;
import com.group1.movielist_app.dao.UserRepository;
import com.group1.movielist_app.entity.Movie;
import com.group1.movielist_app.entity.MovieList;
import com.group1.movielist_app.entity.User;
import com.group1.movielist_app.form.EditMovieForm;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepositry;

    @Autowired
    MovieListRepository movieListRepository;

    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/")
    public String displayHome(Model model, HttpSession session) throws JsonProcessingException {
        Long userId = (Long) session.getAttribute(SessionConstants.APP_USERID);
        Optional<User> user = userId == null ? Optional.empty() : userRepositry.findById(userId);
        if (user.isPresent()) {
            List<MovieList> movieList = user.get().getMovielists();
            model.addAttribute("user", user.get());
            model.addAttribute("movieList", movieList);
            return "home/index";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/edit-movie/{id}")
    public String editMovie(@PathVariable Long movieId, Model model, EditMovieForm editMovieForm) {
        editMovieForm = getOneMovie(editMovieForm.getMovieId());
        model.addAttribute(editMovieForm);
        return "edit-movie";
    }
    
    public EditMovieForm getOneMovie(Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow();
        // System.out.println(movie);
        EditMovieForm editMovieForm = new EditMovieForm();
        editMovieForm.setMovieId(movie.getMovieId());
        editMovieForm.setMovieImg(movie.getMovieImg());
        editMovieForm.setMovieTitle(movie.getMovieTitle());
        editMovieForm.setMovieGenre(movie.getMovieGenre());
        editMovieForm.setMovieActor(movie.getMovieActor());
        editMovieForm.setMovieDescription(movie.getMovieDescription());
        editMovieForm.setMovieRating(movie.getMovieRating());
        return editMovieForm;
    }

    @PostMapping("/edit-movie")
    public String updateMovie(@ModelAttribute EditMovieForm editMovieForm, Model model) {
        updateOneMovie(editMovieForm);
        return "redirect:/";
    }

    public void updateOneMovie(EditMovieForm editMovieForm) {
        Movie movie = new Movie();

        movie.setMovieId(editMovieForm.getMovieId());
        movie.setMovieImg(editMovieForm.getMovieImg());
        movie.setMovieTitle(editMovieForm.getMovieTitle());
        movie.setMovieGenre(editMovieForm.getMovieGenre());
        movie.setMovieActor(editMovieForm.getMovieActor());
        movie.setMovieActor(editMovieForm.getMovieActor());
        movie.setMovieRating(editMovieForm.getMovieRating());

        movieRepository.save(movie);
    }





}
