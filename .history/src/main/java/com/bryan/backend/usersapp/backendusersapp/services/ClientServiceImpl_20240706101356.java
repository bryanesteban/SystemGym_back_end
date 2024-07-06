package com.bryan.backend.usersapp.backendusersapp.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
                .map(u -> ClientDTO.build(u))
                .collect(Collectors.toList());

    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ClientDTO> findByIdentificaction(String identification) {
        
        return clientRepository
                .findByIdentification(identification)
                .map(u -> ClientDTO.build(u));


    }

    @Override
    public List<ClientDTO> findByNameOrLast_name(String nameValue) {
        
        System.out.println("palabra clave:"+nameValue);
        List<Client> clients = clientRepository.findByNameContainingOrLastNameContaining(nameValue, nameValue);
        System.out.println("Respuesta:"+clients);
        return clients
                .stream()
                .map(u -> ClientDTO.build(u))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ClientDTO saveClient(Client client) {
        System.out.println("client:"+client);
        return ClientDTO.build(clientRepository.save(client));
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
