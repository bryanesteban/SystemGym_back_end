package com.bryan.backend.usersapp.backendusersapp.repositories;

import org.springframework.data.repository.CrudRepository;
import com.bryan.backend.usersapp.backendusersapp.models.entities.Client;


import java.util.List;
import java.util.Optional;



public interface ClientRepository 
       extends CrudRepository<Client,Long> {

       Optional<Client> findByIdentification(String identification);

       List<Client> findByNameContainingOrLastNameContaining(String name, String lastName);
       
       void deleteByIdentification(String identification);
        

}
