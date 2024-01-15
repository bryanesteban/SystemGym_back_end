package com.bryan.backend.usersapp.backendusersapp.services;

import java.util.List;
import java.util.Optional;

import com.bryan.backend.usersapp.backendusersapp.models.entities.User;

public interface UserService {

    List<User> findAll();
    Optional<User> findById(Long id);
}
