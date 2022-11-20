package com.group1.movielist_app.controller;

import javax.servlet.http.HttpSession;

import org.apache.catalina.manager.util.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group1.movielist_app.dao.MovieListRepository;
import com.group1.movielist_app.dao.UserRepository;
import com.group1.movielist_app.entity.MovieList;

@Controller
@RequestMapping("/movielist")
public class CreateMovieListController {

    @Autowired
    MovieListRepository movieListRepository;

    @Autowired
    UserRepository userRepositry;

    @GetMapping("/new")
    public String displayMovieListForm(Model model) {
        model.addAttribute("movieList", new MovieList());
        return "movielist/new-movielist";
    }

    @PostMapping("/save")
    public String createMovieList(MovieList movieList, Model model, HttpSession httpSession) {
        Long userId = (Long) httpSession.getAttribute(SessionConstants.APP_USERID);
        movieList.setUser(userRepositry.getReferenceById(userId));
        movieListRepository.save(movieList);
        return "redirect:/movielist/new";
    }

}
