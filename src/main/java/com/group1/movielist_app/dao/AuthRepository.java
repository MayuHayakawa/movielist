package com.group1.movielist_app.dao;

import org.springframework.data.repository.CrudRepository;

import com.group1.movielist_app.entity.User;

public interface AuthRepository extends CrudRepository<User, Long> {
    
    User findByEmailAndPassword(String email, String password);
}
