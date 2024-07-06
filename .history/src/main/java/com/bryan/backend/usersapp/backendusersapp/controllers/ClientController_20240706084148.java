package com.bryan.backend.usersapp.backendusersapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bryan.backend.usersapp.backendusersapp.models.DTO.ClientDTO;
import com.bryan.backend.usersapp.backendusersapp.services.ClientService;

@RestController
@RequestMapping("/clients")
@CrossOrigin(originPatterns = "*")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<ClientDTO> list(){
        return clientService.findAll();
    }

    @GetMapping("/{ci}")
    public ResponseEntity<?> findForIdentification(@PathVariable (name="ci") String identification){

        Optional<ClientDTO> clientOptional = clientService.findByIdentificaction(identification);

        if(clientOptional.isPresent()){
            return ResponseEntity.ok(clientOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/find/{nameValue}")
    public List<ClientDTO> findForNameOrLastname(@PathVariable (name="nameValue") String nameValue){
            
        List<ClientDTO> clientsFound = clientService.findByNameOrLast_name(nameValue);
        System.out.println("Funciona: "+clientsFound);
        if(clientsFound.size() > 0){
            System.out.println("Funciona: "+clientsFound);
            return  (List<ClientDTO>)  ResponseEntity.status(HttpStatus.OK).body(clientsFound);  
        }

        return (List<ClientDTO>) ResponseEntity.notFound().build();

    }


}
