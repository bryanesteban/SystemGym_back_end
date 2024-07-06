package com.bryan.backend.usersapp.backendusersapp.repositories;

import org.springframework.data.repository.CrudRepository;
import com.bryan.backend.usersapp.backendusersapp.models.entities.Client;
import java.util.Optional;


public interface ClientRepository 
       extends CrudRepository<Client,Long> {

       Optional<Client> findByIdentification(String identification);

       Optional<Client> finByNameOrLast_name(String name, String last_name);
        

}
