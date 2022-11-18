package com.group1.movielist_app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group1.movielist_app.entity.User;

public interface UserRepositry extends JpaRepository<User, Long>{

    @Override
    public List<User> findAll();
    
}
