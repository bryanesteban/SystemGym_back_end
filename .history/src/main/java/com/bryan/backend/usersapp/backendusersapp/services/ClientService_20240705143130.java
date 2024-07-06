package com.bryan.backend.usersapp.backendusersapp.services;

import java.util.List;
import java.util.Optional;

import com.bryan.backend.usersapp.backendusersapp.models.DTO.ClientDTO;
import com.bryan.backend.usersapp.backendusersapp.models.entities.Client;

public interface ClientService {

    List<ClientDTO> findAll();

    Optional<ClientDTO> findById( Long id);
    Optional<ClientDTO> findByNameAndLast_name(String name, String last_name);
    
    ClientDTO save ( Client client);

    Optional<ClientDTO> update(ClientDTO client, String identification);

    void remove(String id );


}
