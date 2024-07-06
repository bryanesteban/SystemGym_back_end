package com.bryan.backend.usersapp.backendusersapp.models.DTO;

import java.util.Date;

public class ClientDTO {

    private String identification;
    private String name;
    private String last_name;
    private String email;
    private String phone_number;
    private Date inscription_date;
    private Date date_birthday;
    private Date address;


    private ClientDTO clientDTO;
    
    public ClientDTO()  {
    }

    public ClientDTO(String identification, String name, String last_name, String email, String phone_number,
            Date inscription_date, Date date_birthday, Date address) {
        this.identification = identification;
        this.name = name;
        this.last_name = last_name;
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

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public Date getAddress() {
        return address;
    }

    public void setAddress(Date address) {
        this.address = address;
    }

    
    public ClientDTO build(){

        if( )
    }


}
