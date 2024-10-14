package com.bryan.backend.usersapp.backendusersapp.services;

import java.util.List;
import java.util.Optional;

import com.bryan.backend.usersapp.backendusersapp.models.DTO.UserDTO;
import com.bryan.backend.usersapp.backendusersapp.models.entities.User;
import com.bryan.backend.usersapp.backendusersapp.models.request.userRequest;

public interface UserService {

    List<UserDTO> findAll();

    Optional<UserDTO> findById(Long id);

    UserDTO save(User user);
    Optional<UserDTO> update(userRequest user, Long id);

    void remove(Long id);

}
