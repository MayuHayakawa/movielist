package com.group1.movielist_app.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.group1.movielist_app.dao.MovieListRepository;
import com.group1.movielist_app.dao.MovieRepository;
import com.group1.movielist_app.dao.UserRepository;
import com.group1.movielist_app.entity.Movie;
import com.group1.movielist_app.entity.MovieList;
import com.group1.movielist_app.entity.User;

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

}
