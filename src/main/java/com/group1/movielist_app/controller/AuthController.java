package com.group1.movielist_app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.group1.movielist_app.dao.AuthRepository;
import com.group1.movielist_app.entity.User;

//Added
// import java.util.List;
// import com.group1.movielist_app.entity.MovieList;
// import com.fasterxml.jackson.core.JsonProcessingException;
// import java.util.Optional;
// import com.group1.movielist_app.dao.UserRepository;


@Controller
public class AuthController {

    // @Autowired
    // UserRepository userRepositry;

    @Autowired
    AuthRepository authRepository;

    @GetMapping("/login")
    public String showLogin(Model model) {
        model.addAttribute("user", new User());
        return "auth/login";
    }
    @GetMapping("/logout")
    public String showLogout(Model model) {
        model.addAttribute("user", new User());
        return "auth/login";
    }

    @GetMapping("/register")
    public String showRegister(Model model) {
        model.addAttribute("user", new User());
        return "auth/register";
    }

    @GetMapping("/account")
    public String showAccount(Model model) {
        model.addAttribute("user", new User());
        return "auth/account";
    }

    @GetMapping("/catalogue")
    
    public String showCatalogue(Model model) {
        model.addAttribute("user", new User());
        return "auth/catalogue";
    }


    @PostMapping("/login")
    public String handleLogin(User user, Model model, HttpSession session) {
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        User searchResult = authRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if (searchResult != null) {
            session.setAttribute(SessionConstants.APP_USERID, Long.valueOf(searchResult.getUserId()));
            return "redirect:/";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/logout")
    public String handleLogout(Model model, HttpSession session) {
        session.removeAttribute(SessionConstants.APP_USERID);
        return "redirect:/login";
    }

    @PostMapping("/register")
    public String handleRegister(User user, Model model) {
        if (user.getFullName() != null && user.getEmail() != null && user.getPassword() != null) {
            authRepository.save(user);
            return "redirect:/";
        } else {
            return "redirect:/register";
        }
    }

    @PostMapping("/account")
    public String handleAccount(User user, Model model) {
        if (user.getFullName() != null && user.getEmail() != null && user.getPassword() != null) {
            authRepository.save(user);
            return "redirect:/";
        } else {
            return "redirect:/account";
        }
    }

    @PostMapping("/catalogue")
    public String handleCatalogue(User user, Model model) {
        if (user.getFullName() != null && user.getEmail() != null && user.getPassword() != null) {
            authRepository.save(user);
            return "redirect:/";
        } else {
            return "redirect:/catalogue";
        }
    }


}
