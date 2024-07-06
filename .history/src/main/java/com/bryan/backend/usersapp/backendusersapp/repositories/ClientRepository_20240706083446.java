package com.bryan.backend.usersapp.backendusersapp.repositories;

import org.springframework.data.repository.CrudRepository;
import com.bryan.backend.usersapp.backendusersapp.models.entities.Client;

import java.util.Collection;
import java.util.List;
import java.util.Optional;



public interface ClientRepository 
       extends CrudRepository<Client,Long> {

       Optional<Client> findByIdentification(String identification);

       List<Client>findByNameOrLastName(String name, String lastName);
        

}
