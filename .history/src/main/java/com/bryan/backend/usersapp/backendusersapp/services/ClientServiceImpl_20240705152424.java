package com.bryan.backend.usersapp.backendusersapp.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bryan.backend.usersapp.backendusersapp.models.DTO.ClientDTO;
import com.bryan.backend.usersapp.backendusersapp.models.entities.Client;
import com.bryan.backend.usersapp.backendusersapp.repositories.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {


    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<ClientDTO> findAll() {

        List<Client> clients = (List<Client>) clientRepository.findAll();

        return clients
                .stream()
                .map(u -> ClientDTO.builder().setClient(u).build())
                .collect(Collectors.toList());

    }

    @Override
    public Optional<ClientDTO> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Optional<ClientDTO> findByNameAndLast_name(String name, String last_name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByNameAndLast_name'");
    }

    @Override
    public ClientDTO save(Client client) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Optional<ClientDTO> update(ClientDTO client, String identification) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void remove(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }


}
