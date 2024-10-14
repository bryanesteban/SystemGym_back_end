package com.bryan.backend.usersapp.backendusersapp.models.DTO;

import java.util.Date;

import com.bryan.backend.usersapp.backendusersapp.models.entities.Client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private String identification;
    private String name;
    private String lastName;
    private String email;
    private String phone_number;
    private Date inscription_date;
    private Date date_birthday;
    private String address;


    public static ClientDTO build(Client client){


        
        if( client == null ){
            throw new RuntimeException("Debe pasar el entity Client!");
        }

        return new ClientDTO(client.getIdentification(),
                             client.getName(),
                             client.getLastName(),
                             client.getEmail(),
                             client.getPhone_number(),
                             client.getInscription_date(),
                             client.getDate_birthday(),
                             client.getAddress()
                             );
    }


}
