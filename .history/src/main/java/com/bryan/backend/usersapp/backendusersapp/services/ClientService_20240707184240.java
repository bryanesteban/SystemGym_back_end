package com.bryan.backend.usersapp.backendusersapp.services;

import java.util.List;
import java.util.Optional;

import com.bryan.backend.usersapp.backendusersapp.models.DTO.ClientDTO;
import com.bryan.backend.usersapp.backendusersapp.models.entities.Client;

public interface ClientService {

    List<ClientDTO> findAll();

    Optional<ClientDTO> findByIdentificaction( String identification);
    List<ClientDTO> findByNameOrLast_name(String nameValue);
    
    ClientDTO saveClient ( Client client);

    Optional<ClientDTO> update(Client client, String identification);

    void remove(String id );


}
