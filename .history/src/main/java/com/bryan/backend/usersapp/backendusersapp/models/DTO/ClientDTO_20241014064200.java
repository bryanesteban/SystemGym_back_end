package com.bryan.backend.usersapp.backendusersapp.models.DTO;

import java.util.Date;

import com.bryan.backend.usersapp.backendusersapp.models.entities.Client;

public class ClientDTO {

    private String identification;
    private String name;
    private String lastName;
    private String email;
    private String phone_number;
    private Date inscription_date;
    private Date date_birthday;
    private String address;


    // private Client client;
    
    public ClientDTO()  {
    }

    public ClientDTO(String identification, String name, String lastName, String email, String phone_number,
            Date inscription_date, Date date_birthday, String address) {
        this.identification = identification;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone_number = phone_number;
        this.inscription_date = inscription_date;
        this.date_birthday = date_birthday;
        this.address = address;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String last_name) {
        this.lastName = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Date getInscription_date() {
        return inscription_date;
    }

    public void setInscription_date(Date inscription_date) {
        this.inscription_date = inscription_date;
    }

    public Date getDate_birthday() {
        return date_birthday;
    }

    public void setDate_birthday(Date date_birthday) {
        this.date_birthday = date_birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // public static ClientDTO builder()
    // {
    //     return new ClientDTO();
    // }

    
    // public Client setClient(Client client){
    //     this.client = client;
    //     return this.client;
    // }

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
