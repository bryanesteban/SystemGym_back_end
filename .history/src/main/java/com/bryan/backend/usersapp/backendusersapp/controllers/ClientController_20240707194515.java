package com.bryan.backend.usersapp.backendusersapp.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bryan.backend.usersapp.backendusersapp.models.DTO.ClientDTO;
import com.bryan.backend.usersapp.backendusersapp.models.entities.Client;
import com.bryan.backend.usersapp.backendusersapp.services.ClientService;

import jakarta.validation.Valid;

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

    @GetMapping("/{identification}")
    public ResponseEntity<?> findForIdentification(@PathVariable (name="identification") String identification){

        Optional<ClientDTO> clientOptional = clientService.findByIdentificaction(identification);

        if(clientOptional.isPresent()){
            return ResponseEntity.ok(clientOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/find/{nameValue}")
    public ResponseEntity<?> findForNameOrLastname(@PathVariable (name="nameValue") String nameValue){
            
        List<ClientDTO> clientsFound = clientService.findByNameOrLast_name(nameValue);
        if(clientsFound.size() > 0){
            System.out.println("Funciona: "+clientsFound);
            return ResponseEntity.status(HttpStatus.OK).body(clientsFound);  
        }

        return  ResponseEntity.notFound().build();

    }

    @PostMapping
    public ResponseEntity<?> createClient (@Valid @RequestBody Client client, BindingResult result)
    {
            System.out.println("Antes de:"+client);
            if(result.hasErrors()){
                return validation(result);
            }

            ClientDTO clientBD = clientService.saveClient(client);

            return ResponseEntity.status(HttpStatus.CREATED).body(clientBD);

    }

    @PutMapping("/{identification}")
    public ResponseEntity<?> updateClient(@Valid @RequestBody Client client, BindingResult result, @PathVariable String identification )
    {
        if(result.hasErrors()){
            return validation(result);
        }
        Optional<ClientDTO> o = clientService.update(client, identification);
        if(o.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(o.orElseThrow());
        }


        return ResponseEntity.notFound().build();
    }



     private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo "+err.getField()+" "+err.getDefaultMessage());
        });        
        return ResponseEntity.badRequest().body(errors);
    }

}
