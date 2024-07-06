package com.bryan.backend.usersapp.backendusersapp.models.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    @Column(name = "identification", unique = true)
    private String identification;

    @NotBlank
    @Size(max = 30)
    @Column(name = "name", unique = true)
    private String name;

    @NotBlank
    @Size(max = 30)
    @Column(name = "last_name", unique = true)
    private String last_name;

    @NotBlank
    @Size(max = 50)
    @Column(name = "email", unique = true)
    private String email;

    @NotBlank
    @Size(max = 20)
    @Column(name = "phone_number", unique = true)
    private String phone_number;

    @NotBlank
    @Column(name = "date_begin", unique = true)
    private Date inscription_date;

    @NotBlank
    @Column(name = "date_birthday", unique = true)
    private Date date_birthday;

    @NotBlank
    @Size(max = 200)
    @Column(name = "address", unique = true)
    private Date address;

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getUsername() {
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
}
