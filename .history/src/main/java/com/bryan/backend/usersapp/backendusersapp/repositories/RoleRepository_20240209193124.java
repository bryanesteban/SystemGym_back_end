package com.bryan.backend.usersapp.backendusersapp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bryan.backend.usersapp.backendusersapp.models.entities.Role;

public interface RoleRepository 
       extends CrudRepository<Role,Long>{

              Optional<Role> findByname(String username);
}
